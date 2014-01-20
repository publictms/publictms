/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Adres;
import be.pxl.publictms.pojo.Contact;
import be.pxl.publictms.pojo.Persoonsinfo;
import be.pxl.publictms.pojo.Rijbewijsgegevens;
import be.pxl.publictms.pojo.Taal;
import be.pxl.publictms.pojo.Werknemer;
import be.pxl.publictms.service.TaalService;
import be.pxl.publictms.view.WerknemerView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van WerknemerDAO deze klasse zorgt voor de interactie tussen de
 * database en de webservice. Hibernate verzorgt de communicatie tussen beide.
 *
 * @author Laurens Putseys
 */
@Repository
public class WerknemerDAOImpl implements WerknemerDAO {

    private final String qryWerknemer = "select w.actief, w.werknemerid, w.naam, w.voornaam, w.geslacht, w.statuut, w.datuminschrijving, w.datumuitschrijving, w.functie, w.taal, t.taalnaam, "
            + "w.adresid,  a.postcode, a.straat, a.nummer, a.bus, a.land, w.contactid, c.email, c.telefoon, c.gsm, c.fax, "
            + "w.rijbewijsid, r.rijbewijsnr, r.rijbewijscat, r.geldigtot, r.adrcertificaat, r.medischattest, r.tankkaartnr, r.tachograafnr, r.tachograaftot, "
            + "w.infoid, p.rijksregisternr, p.siskaart, p.identiteitsnr, p.pensioennr, p.geboorteplaats, p.geboortedatum, p.iban, p.bic, p.burgerstand, p.aantalkinderen "
            + "from werknemer w, taal t, adres a, contact c, rijbewijsgegevens r, persoonsinfo p "
            + "where w.werknemerid = :id "
            + "and w.taal = t.taalid "
            + "and w.adresid = a.adresid "
            + "and w.contactid = c.contactid "
            + "and w.rijbewijsid = r.rijbewijsid "
            + "and w.infoid = p.infoid";
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private TaalService taalService;

    /**
     * zorgt ervoor dat sessionFactory wordt geïnitialiseerd
     *
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Voeg een werknemer toe aan de hand van een werknemer object.
     *
     * @param werknemer
     */
    @Override
    public void addWerknemer(WerknemerView werknemerView) {
        try{
            Date geldigTot = null,geboorteDatum = null,datumIn = null,datumUit = null;
            try{
                geldigTot = new SimpleDateFormat("yyyy-MM-dd").parse(werknemerView.getGeldigtot().toString());
            }catch(Exception ex){
                ex.toString();
            }try{
                geboorteDatum = new SimpleDateFormat("yyyy-MM-dd").parse(werknemerView.getGeboortedatum().toString());
            }catch(Exception ex){
                ex.toString();
            }try{
                datumIn = new SimpleDateFormat("yyyy-MM-dd").parse(werknemerView.getDatuminschrijving().toString());
            }catch(Exception ex){
                ex.toString();
            }try{
                datumUit = new SimpleDateFormat("yyyy-MM-dd").parse(werknemerView.getDatumuitschrijving().toString());
            }catch(Exception ex){
                ex.toString();
            }
            
            Taal taal = new Taal(werknemerView.getTaalnaam().toString());
            Adres adres = new Adres(werknemerView.getPostcode().toString(), werknemerView.getStraat().toString(), Short.parseShort(werknemerView.getNummer().toString()), werknemerView.getBus().toString(), werknemerView.getLand().toString());
            Contact contact = new Contact(werknemerView.getEmail().toString(), werknemerView.getTelefoon().toString(), werknemerView.getGsm().toString(), werknemerView.getFax().toString());
            Rijbewijsgegevens rijbewijs = new Rijbewijsgegevens(werknemerView.getRijbewijsnr().toString(), werknemerView.getRijbewijscat().toString(), geldigTot, (Boolean) werknemerView.getAdrcertificaat(), (Boolean) werknemerView.getMedischattest(),werknemerView.getTankkaartnr().toString(), werknemerView.getTachograafnr().toString(), Integer.parseInt(werknemerView.getTachograaftot().toString()));
            Persoonsinfo persoonsinfo = new Persoonsinfo(werknemerView.getRijksregisternr().toString(), werknemerView.getSiskaart().toString(), werknemerView.getIdentiteitsnr().toString(), werknemerView.getPensioennr().toString(), werknemerView.getGeboorteplaats().toString(), geboorteDatum, werknemerView.getIban().toString(), werknemerView.getBic().toString(), werknemerView.getBurgerstand().toString(), Integer.parseInt(werknemerView.getAantalkinderen().toString()));
          

            //taalService.updateTaal(taal);
            sessionFactory.getCurrentSession().saveOrUpdate(taal);
            sessionFactory.getCurrentSession().save(adres);
            sessionFactory.getCurrentSession().save(contact);
            sessionFactory.getCurrentSession().save(rijbewijs);
            sessionFactory.getCurrentSession().save(persoonsinfo);

            Werknemer werknemer = new Werknemer(taal.getTaalid(), werknemerView.getNaam().toString(), werknemerView.getVoornaam().toString(), (Boolean)werknemerView.getActief(), adres.getAdresid(), contact.getContactid(), werknemerView.getGeslacht().toString().charAt(0), werknemerView.getStatuut().toString(), datumIn, datumUit, werknemerView.getFunctie().toString(), rijbewijs.getRijbewijsid(), persoonsinfo.getInfoid());
            sessionFactory.getCurrentSession().save(werknemer);
        } catch (Exception ex) {
            Logger.getLogger(OpleggerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Geef een lijst terug met alle werknemers.
     *
     * @return List Werknemer
     */
    @Override
    public List<Werknemer> getWerknemers() {
        return sessionFactory.getCurrentSession().createQuery("from Werknemer").list();
    }

    /**
     * Geeft het record met werknemerid id.
     *
     * @param id waarde dat de kolom werknemerid moet hebben
     * @return de data van de record met werknemerid id.
     */
    @Override
    public WerknemerView getWerknemer(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryWerknemer);
        query.setParameter("id", id);
        return mapJson(query.list()).get(0);
    }

    /**
     * Verwijder een werknemer aan de hand van zijn index.
     *
     * @param id
     */
    @Override
    public void deleteWerknemer(int id) {
        
        Werknemer werknemer = (Werknemer) sessionFactory.getCurrentSession().load(Werknemer.class, id);
        Adres adres = (Adres) sessionFactory.getCurrentSession().load(Adres.class, werknemer.getAdresid());
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, werknemer.getContactid());
        Rijbewijsgegevens rijbewijs = (Rijbewijsgegevens) sessionFactory.getCurrentSession().load(Rijbewijsgegevens.class, werknemer.getRijbewijsid());
        Persoonsinfo persoonsinfo = (Persoonsinfo) sessionFactory.getCurrentSession().load(Persoonsinfo.class, werknemer.getInfoid());
        
        sessionFactory.getCurrentSession().delete(adres);
        sessionFactory.getCurrentSession().delete(contact);
        sessionFactory.getCurrentSession().delete(rijbewijs);
        sessionFactory.getCurrentSession().delete(persoonsinfo);
        sessionFactory.getCurrentSession().delete(werknemer); 
    }

    /**
     * Bewerk een werknemer aan de hand van een werknmer object.
     *
     * @param werknemer
     */
    @Override
    public void updateWerknemer(WerknemerView werknemerView) {

        try {
            Date geldigTot = null,geboorteDatum = null,datumIn = null,datumUit = null;
            try{
                geldigTot = new SimpleDateFormat("yyyy-MM-dd").parse(werknemerView.getGeldigtot().toString());
            }catch(Exception ex){
                ex.toString();
            }try{
                geboorteDatum = new SimpleDateFormat("yyyy-MM-dd").parse(werknemerView.getGeboortedatum().toString());
            }catch(Exception ex){
                ex.toString();
            }try{
                datumIn = new SimpleDateFormat("yyyy-MM-dd").parse(werknemerView.getDatuminschrijving().toString());
            }catch(Exception ex){
                ex.toString();
            }try{
                datumUit = new SimpleDateFormat("yyyy-MM-dd").parse(werknemerView.getDatumuitschrijving().toString());
            }catch(Exception ex){
                ex.toString();
            }
            Taal taal = new Taal(Integer.parseInt(werknemerView.getTaalid().toString()), werknemerView.getTaalnaam().toString());
            Adres adres = new Adres(Integer.parseInt(werknemerView.getAdresid().toString()), werknemerView.getPostcode().toString(), werknemerView.getStraat().toString(), Short.parseShort(werknemerView.getNummer().toString()), werknemerView.getBus().toString(), werknemerView.getLand().toString());
            Contact contact = new Contact(Integer.parseInt(werknemerView.getContactid().toString()), werknemerView.getEmail().toString(), werknemerView.getTelefoon().toString(), werknemerView.getGsm().toString(), werknemerView.getFax().toString());
            Rijbewijsgegevens rijbewijs = new Rijbewijsgegevens(Integer.parseInt(werknemerView.getRijbewijsid().toString()), werknemerView.getRijbewijsnr().toString(), werknemerView.getRijbewijscat().toString(), datumOmzet(werknemerView.getGeldigtot().toString()), (Boolean) werknemerView.getAdrcertificaat(), (Boolean) werknemerView.getMedischattest(), werknemerView.getTankkaartnr().toString(), werknemerView.getTachograafnr().toString(), Integer.parseInt(werknemerView.getTachograaftot().toString()));
            Persoonsinfo persoonsinfo = new Persoonsinfo(Integer.parseInt(werknemerView.getInfoid().toString()), werknemerView.getRijksregisternr().toString(), werknemerView.getSiskaart().toString(), werknemerView.getIdentiteitsnr().toString(), werknemerView.getPensioennr().toString(), werknemerView.getGeboorteplaats().toString(), datumOmzet(werknemerView.getGeboortedatum().toString()), werknemerView.getIban().toString(), werknemerView.getBic().toString(), werknemerView.getBurgerstand().toString(), Integer.parseInt(werknemerView.getAantalkinderen().toString()));
            Werknemer werknemer = new Werknemer(Integer.parseInt(werknemerView.getWerknemerid().toString()), Integer.parseInt(werknemerView.getTaalid().toString()), werknemerView.getNaam().toString(), werknemerView.getVoornaam().toString(), (Boolean) werknemerView.getActief(), Integer.parseInt(werknemerView.getAdresid().toString()), Integer.parseInt(werknemerView.getContactid().toString()), werknemerView.getGeslacht().toString().charAt(0), werknemerView.getStatuut().toString(), datumOmzet(werknemerView.getDatuminschrijving().toString()), datumOmzet(werknemerView.getDatumuitschrijving().toString()), werknemerView.getFunctie().toString(), Integer.parseInt(werknemerView.getRijbewijsid().toString()), Integer.parseInt(werknemerView.getInfoid().toString()));
            
            System.out.println(werknemerView.getTelefoon().toString());
            taalService.updateTaal(taal);
            sessionFactory.getCurrentSession().update(adres);
            sessionFactory.getCurrentSession().update(contact);
            sessionFactory.getCurrentSession().update(rijbewijs);
            sessionFactory.getCurrentSession().update(persoonsinfo);
            sessionFactory.getCurrentSession().update(werknemer);
        } catch (Exception ex) {
            Logger.getLogger(OpleggerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<WerknemerView> mapJson(List list) {
        List<WerknemerView> werknemers = new ArrayList<WerknemerView>();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object[] row = (Object[]) iter.next();
            WerknemerView werknemerView =
                    new WerknemerView(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9],
                    row[10], row[11], row[12], row[13], row[14], row[15], row[16], row[17], row[18], row[19], row[20], row[21],
                    row[22], row[23], row[24], row[25], row[26], row[27], row[28], row[29], row[30], row[31],
                    row[32], row[33], row[34], row[35], row[36], row[37], row[38], row[39], row[40], row[41]);
            werknemers.add(werknemerView);
        }
        return werknemers;
    }

    public Date datumOmzet(String datumString) {
        Date datum = null;
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-mm-dd");
            datum = (Date) formatter.parse(datumString);
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
        }
        return datum;
    }
}

