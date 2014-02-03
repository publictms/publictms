/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Adres;
import be.pxl.publictms.pojo.Contact;
import be.pxl.publictms.pojo.Gebruiker;
import be.pxl.publictms.pojo.Persoonsinfo;
import be.pxl.publictms.pojo.Rijbewijsgegevens;
import be.pxl.publictms.pojo.Werknemer;
import be.pxl.publictms.view.WerknemerView;
import be.pxl.publictms.view.WerknemerObjectView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van WerknemerDAO deze klasse zorgt voor de interactie tussen de
 * database en de webservice. Hibernate verzorgt de communicatie tussen beide.
 *
 * @author Laurens Putseys
 */
@Repository
public class WerknemerDAOImpl implements WerknemerDAO {

    private final String qryWerknemer = "select w.actief, w.werknemerid, w.naam, w.voornaam, w.geslacht, w.statuut, w.datuminschrijving, w.datumuitschrijving, w.functie, w.taal, t.taalnaam, \n" +
        "w.adresid,  a.postcode, a.straat, a.nummer, a.bus, a.land, w.contactid, c.email, c.telefoon, c.gsm, c.fax, \n" +
        "w.rijbewijsid, r.rijbewijsnr, r.rijbewijscat, r.geldigtot, r.adrcertificaat, r.medischattest, r.tankkaartnr, r.tachograafnr, r.tachograaftot, \n" +
        "w.infoid, p.rijksregisternr, p.siskaart, p.identiteitsnr, p.pensioennr, p.geboorteplaats, p.geboortedatum, p.iban, p.bic, p.burgerstand, p.aantalkinderen,\n" +
        "g.gebruikerid, g.gebruikersnaam, g.paswoord, g.administrator\n" +
        "from werknemer w, taal t, adres a, contact c, rijbewijsgegevens r, persoonsinfo p, gebruiker g\n" +
        "where w.werknemerid = :id\n" +
        "and w.taal = t.taalid \n" +
        "and w.adresid = a.adresid \n" +
        "and w.contactid = c.contactid \n" +
        "and w.rijbewijsid = r.rijbewijsid \n" +
        "and w.infoid = p.infoid\n" +
        "and w.werknemerid = g.werknemerid";
    
        private final String qryWerknemers = "select w.actief, w.werknemerid, w.naam, w.voornaam, w.geslacht, w.statuut, w.datuminschrijving, w.datumuitschrijving, w.functie, w.taal, t.taalnaam, \n" +
                "w.adresid,  a.postcode, a.straat, a.nummer, a.bus, a.land, w.contactid, c.email, c.telefoon, c.gsm, c.fax, \n" +
                "w.rijbewijsid, r.rijbewijsnr, r.rijbewijscat, r.geldigtot, r.adrcertificaat, r.medischattest, r.tankkaartnr, r.tachograafnr, r.tachograaftot, \n" +
                "w.infoid, p.rijksregisternr, p.siskaart, p.identiteitsnr, p.pensioennr, p.geboorteplaats, p.geboortedatum, p.iban, p.bic, p.burgerstand, p.aantalkinderen,\n" +
                "g.gebruikerid, g.gebruikersnaam, g.paswoord, g.administrator\n" +
                "from werknemer w, taal t, adres a, contact c, rijbewijsgegevens r, persoonsinfo p, gebruiker g\n" +
                "where w.taal = t.taalid \n" +
                "and w.adresid = a.adresid \n" +
                "and w.contactid = c.contactid \n" +
                "and w.rijbewijsid = r.rijbewijsid \n" +
                "and w.infoid = p.infoid\n" +
                "and w.werknemerid = g.werknemerid";
    @Autowired
    private SessionFactory sessionFactory;


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
    public void addWerknemer(WerknemerView werknemerCompleet) {
            
            Adres adres = new Adres(werknemerCompleet.getPostcode(), werknemerCompleet.getStraat(), werknemerCompleet.getNummer(), werknemerCompleet.getBus(), 1);
            Contact contact = new Contact(werknemerCompleet.getEmail(), werknemerCompleet.getTelefoon(), werknemerCompleet.getGsm(), werknemerCompleet.getFax());
            Rijbewijsgegevens rijbewijs = new Rijbewijsgegevens(werknemerCompleet.getRijbewijsnr(), werknemerCompleet.getRijbewijscat(), werknemerCompleet.getGeldigtot(), werknemerCompleet.getAdrcertificaat(), werknemerCompleet.getMedischattest(), werknemerCompleet.getTankkaartnr(), werknemerCompleet.getTachograafnr(), werknemerCompleet.getTachograaftot());
            Persoonsinfo persoonsinfo = new Persoonsinfo(werknemerCompleet.getRijksregisternr(), werknemerCompleet.getSiskaart(), werknemerCompleet.getIdentiteitsnr(), werknemerCompleet.getPensioennr(), werknemerCompleet.getGeboorteplaats(), werknemerCompleet.getGeboortedatum(), werknemerCompleet.getIban(), werknemerCompleet.getBic(), werknemerCompleet.getBurgerstand(), werknemerCompleet.getAantalkinderen());
            sessionFactory.getCurrentSession().save(adres);
            sessionFactory.getCurrentSession().save(contact);
            sessionFactory.getCurrentSession().save(rijbewijs);
            sessionFactory.getCurrentSession().save(persoonsinfo);

            Werknemer werknemer = new Werknemer(werknemerCompleet.getTaalid(), werknemerCompleet.getNaam(), werknemerCompleet.getVoornaam(), werknemerCompleet.getActief(), adres.getAdresid(), contact.getContactid(), werknemerCompleet.getGeslacht(), werknemerCompleet.getStatuut(), werknemerCompleet.getDatuminschrijving(), werknemerCompleet.getDatumuitschrijving(), werknemerCompleet.getFunctie(), rijbewijs.getRijbewijsid(), persoonsinfo.getInfoid());
            sessionFactory.getCurrentSession().save(werknemer);
            
            String salt = BCrypt.gensalt();
            String paswoord = BCrypt.hashpw(werknemerCompleet.getPaswoord(), BCrypt.gensalt());

            Gebruiker gebruiker = new Gebruiker(werknemerCompleet.getGebruikersnaam(),paswoord, salt, werknemer.getWerknemerid(), werknemerCompleet.isAdmin());
            sessionFactory.getCurrentSession().save(gebruiker);
    }
    /**
     * Geef een lijst terug met alle werknemers.
     *
     * @return List Werknemer
     */
    @Override
    public List<WerknemerObjectView> getWerknemers() {
        //return sessionFactory.getCurrentSession().createQuery("from Werknemer").list();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryWerknemers);
        return mapJson(query.list());
    }

    /**
     * Geeft het record met werknemerid id.
     *
     * @param id waarde dat de kolom werknemerid moet hebben
     * @return de data van de record met werknemerid id.
     */
    @Override
    public WerknemerObjectView getWerknemer(int id) {
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
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Gebruiker where WerknemerId = :id");
        query.setParameter("id", id);
        Gebruiker gebruiker = (Gebruiker) query.list().get(0);
        session.close();
        gebruiker = (Gebruiker) sessionFactory.getCurrentSession().load(Gebruiker.class, gebruiker.getGebruikerid());

        sessionFactory.getCurrentSession().delete(gebruiker);
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
    public void updateWerknemer(WerknemerView werknemerCompleet) {
            Adres adres = new Adres(werknemerCompleet.getAdresid(), werknemerCompleet.getPostcode(), werknemerCompleet.getStraat(), werknemerCompleet.getNummer(), werknemerCompleet.getBus(), 1);
            Contact contact = new Contact(werknemerCompleet.getContactid(), werknemerCompleet.getEmail(), werknemerCompleet.getTelefoon(), werknemerCompleet.getGsm(), werknemerCompleet.getFax());
            Rijbewijsgegevens rijbewijs = new Rijbewijsgegevens(werknemerCompleet.getRijbewijsid(), werknemerCompleet.getRijbewijsnr(), werknemerCompleet.getRijbewijscat(), werknemerCompleet.getGeldigtot(), werknemerCompleet.getAdrcertificaat(), werknemerCompleet.getMedischattest(), werknemerCompleet.getTankkaartnr(), werknemerCompleet.getTachograafnr(), werknemerCompleet.getTachograaftot());
            Persoonsinfo persoonsinfo = new Persoonsinfo(werknemerCompleet.getInfoid(), werknemerCompleet.getRijksregisternr(), werknemerCompleet.getSiskaart(), werknemerCompleet.getIdentiteitsnr(), werknemerCompleet.getPensioennr(), werknemerCompleet.getGeboorteplaats(), werknemerCompleet.getGeboortedatum(), werknemerCompleet.getIban(), werknemerCompleet.getBic(), werknemerCompleet.getBurgerstand(), werknemerCompleet.getAantalkinderen());
            Werknemer werknemer = new Werknemer(werknemerCompleet.getWerknemerid(), werknemerCompleet.getTaalid(), werknemerCompleet.getNaam(), werknemerCompleet.getVoornaam(), werknemerCompleet.getActief(), werknemerCompleet.getAdresid(), werknemerCompleet.getContactid(), werknemerCompleet.getGeslacht(), werknemerCompleet.getStatuut(), werknemerCompleet.getDatuminschrijving(), werknemerCompleet.getDatumuitschrijving(), werknemerCompleet.getFunctie(), werknemerCompleet.getRijbewijsid(), werknemerCompleet.getInfoid());
            
            String salt = BCrypt.gensalt();
            String paswoord = BCrypt.hashpw(werknemerCompleet.getPaswoord(), BCrypt.gensalt());
            Gebruiker gebruiker;
            
            if(werknemerCompleet.getPaswoord() == null){
                Session session = HibernateUtil.getSessionFactory().openSession();
                Query query = session.createSQLQuery("select * from gebruiker where Gebruikersnaam = :gebruikersnaam").addEntity(Gebruiker.class);
                query.setParameter("gebruikersnaam", werknemerCompleet.getGebruikersnaam());
                Gebruiker gebruikercheck = (Gebruiker) query.list().get(0);
                gebruiker = new Gebruiker(werknemerCompleet.getGebruikersid(), werknemerCompleet.getGebruikersnaam(), gebruikercheck.getPaswoord(), gebruikercheck.getSalt(), werknemerCompleet.getWerknemerid(), werknemerCompleet.isAdmin());
            }else{
                gebruiker = new Gebruiker(werknemerCompleet.getGebruikersid(), werknemerCompleet.getGebruikersnaam(), paswoord, salt, werknemerCompleet.getWerknemerid(), werknemerCompleet.isAdmin());
            }
                  

            sessionFactory.getCurrentSession().update(adres);
            sessionFactory.getCurrentSession().update(contact);
            sessionFactory.getCurrentSession().update(rijbewijs);
            sessionFactory.getCurrentSession().update(persoonsinfo);
            sessionFactory.getCurrentSession().update(werknemer);
            sessionFactory.getCurrentSession().update(gebruiker);
    }

    public List<WerknemerObjectView> mapJson(List list) {
        List<WerknemerObjectView> werknemers = new ArrayList<WerknemerObjectView>();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object[] row = (Object[]) iter.next();
            WerknemerObjectView werknemerView =
                    new WerknemerObjectView(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9],
                    row[10], row[11], row[12], row[13], row[14], row[15], row[16], row[17], row[18], row[19], row[20], row[21],
                    row[22], row[23], row[24], row[25], row[26], row[27], row[28], row[29], row[30], row[31],
                    row[32], row[33], row[34], row[35], row[36], row[37], row[38], row[39], row[40], row[41], row[42], row[43], row[44], row[45]);
            werknemers.add(werknemerView);
        }
        return werknemers;
    }
}

