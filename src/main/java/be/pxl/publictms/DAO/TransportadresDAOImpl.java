/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Adres;
import be.pxl.publictms.pojo.Contact;
import be.pxl.publictms.pojo.Klant;
import be.pxl.publictms.pojo.Transportadres;
import be.pxl.publictms.view.KlantView;
import be.pxl.publictms.view.KlantObjectView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van TransportadresDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Stijn Ceunen
 */
@Repository
public class TransportadresDAOImpl implements TransportadresDAO{
    private final String qryKlanten = "select t.transportid,t.adresid,t.contactid,t.taal, t.soortadres,t.actief, t.vensteruren,\n" +
"            t.vrachtbeperking, t.chauffeursbeperking, t.vrijveld,\n" +
"            a.straat, a.nummer, a.bus, a.land, l.landnaam, a.postcode, p.gemeente,c.email, c.telefoon, c.gsm, c.fax, ta.taalnaam, k.klantid,\n" +
"            k.naam as \"klantnaam\", k.voornaam as \"klantvoornaam\", k.bedrijf, k.website, k.betalingscondities, k.munt,\n" +
"            k.btwregime, k.btwnummer, k.ondernemingsnummer, k.iban, k.bic\n" +
"            from klant k \n" +
"            inner join transportadres t\n" +
"            on k.transportadresid = t.transportid\n" +
"            inner join adres a\n" +
"            on a.adresid = t.adresid\n" +
"            inner join postcode p\n" +
"            on p.postcode = a.postcode\n" +
"            inner join contact c\n" +
"            on t.contactid = c.contactid\n" +
"            inner join taal ta\n" +
"            on ta.taalid = taal\n" +
"            inner join land l\n" +
"            on l.landid = a.land";
    
    private final String qryKlant = "select t.transportid,t.adresid,t.taal,t.contactid, t.soortadres,t.actief, t.vensteruren,\n" +
"            t.vrachtbeperking, t.chauffeursbeperking, t.vrijveld,\n" +
"            a.straat, a.nummer, a.bus, a.land, l.landnaam, a.postcode, p.gemeente,c.email, c.telefoon, c.gsm, c.fax, ta.taalnaam, k.klantid,\n" +
"            k.naam as \"klantnaam\", k.voornaam as \"klantvoornaam\", k.bedrijf, k.website, k.betalingscondities, k.munt,\n" +
"            k.btwregime, k.btwnummer, k.ondernemingsnummer, k.iban, k.bic\n" +
"            from klant k \n" +
"            inner join transportadres t\n" +
"            on k.transportadresid = t.transportid\n" +
"            inner join adres a\n" +
"            on a.adresid = t.adresid\n" +
"            inner join postcode p\n" +
"            on p.postcode = a.postcode\n" +
"            inner join contact c\n" +
"            on t.contactid = c.contactid\n" +
"            inner join taal ta\n" +
"            on ta.taalid = taal\n" +
"            inner join land l\n" +
"            on l.landid = a.land\n" +
"where k.klantid = :id";

    @Autowired
    private SessionFactory sessionFactory;
    /**
     * zorgt ervoor dat sessionFactory wordt ge�nitialiseerd
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    /**
     * Voeg een nieuw transport adres toe.
     * @param transportadres 
     */
    @Override
    public void addTransportadres(KlantView klant) {
        Adres adres = new Adres(klant.getPostcode(), klant.getStraat(), klant.getNummer(), klant.getBus(), klant.getLandid());//land!!!
        Contact contact = new Contact(klant.getEmail(), klant.getTelefoon(), klant.getGsm(), klant.getFax());
        sessionFactory.getCurrentSession().save(adres);
        sessionFactory.getCurrentSession().save(contact);
        
        System.out.println(klant.getTaalid());
        Transportadres transportAdres = new Transportadres(adres.getAdresid(), 
                contact.getContactid(), klant.getTaalid(), klant.isActief(), klant.getSoortadres(),
                klant.getVensteruren(), klant.getVrachtbeperking(), klant.getChauffeursbeperking(),
                klant.getVrijveld());
        sessionFactory.getCurrentSession().save(transportAdres);
       
        System.out.println(transportAdres.getTaal());
        Klant klnt = new Klant(transportAdres.getTransportid(), klant.getKlantnaam(),
                klant.getVoornaam(), klant.getBedrijf(), klant.getWebsite(), klant.getBetalingscondities(), 
                klant.getMunt(), klant.getBtwregime(), klant.getBtwnummer(), klant.getOndernemingsnummer(), klant.getIban(), klant.getBic());
        sessionFactory.getCurrentSession().save(klnt); 
       
    }
    /**
     * Geeft een lijst met transportadressen
     * @param id
     * @return List
     */
    @Override
    public List getTransportadres(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryKlanten);   
        //return mapJson(query.list());
        return mapJson(query.list());
    }
    /**
     * Geef een transport adres terug aan de hand van zijn index.
     * @param id
     * @return Transportadres
     */
    @Override
    public KlantObjectView getTransportadres(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryKlant);
        query.setParameter("id", id);    
        return mapJson(query.list()).get(0);
    }
    /**
     * Verwijder een transport adres aan de hand zijn index.
     * @param id 
     */
    @Override
    public void deleteTransportadres(int id) {
        Klant klant = (Klant)sessionFactory.getCurrentSession().load(Klant.class, id);
        int transportid = klant.getTransportadresid();
        System.out.println("id" + transportid);
        sessionFactory.getCurrentSession().delete(klant);
        Transportadres transportAdres = (Transportadres)sessionFactory.getCurrentSession().load(Transportadres.class, transportid);
        int contactid = transportAdres.getAdresid(), adresid = transportAdres.getAdresid();
        sessionFactory.getCurrentSession().delete(transportAdres);
        System.out.println(transportAdres.getTaal() + transportAdres.getChauffeursbeperking());
        System.out.println("ids: " +contactid +" " + adresid +" " +transportid);
        Contact contact = (Contact)sessionFactory.getCurrentSession().load(Contact.class, contactid);
        Adres adres = (Adres)sessionFactory.getCurrentSession().load(Adres.class, adresid);
        sessionFactory.getCurrentSession().delete(contact);
        sessionFactory.getCurrentSession().delete(adres);
    }
    /**
     * Bewerk een transport adres aan de hand van een Transportadres object.
     * @param transportadres 
     */
    @Override
    public void updateTransportadres(KlantView klant) {
        System.out.println(klant.getLandid() + " " + klant.getPostcode() + " " + klant.getTaalid() + " " + klant.getTaalNaam() + " " + klant.getContactid() + " " + klant.getTransportid());
        
        Adres adres = new Adres(klant.getAdresid(),klant.getPostcode(), klant.getStraat(), klant.getNummer(), klant.getBus(), klant.getLandid());
        Contact contact = new Contact(klant.getContactid(),klant.getEmail(), klant.getTelefoon(), klant.getGsm(), klant.getFax());
        
        sessionFactory.getCurrentSession().update(adres);
        sessionFactory.getCurrentSession().update(contact);
        
        Transportadres transportAdres = new Transportadres(klant.getTransportid(), klant.getAdresid(),
                klant.getContactid(), klant.getTaalid(), klant.isActief(), klant.getSoortadres(),
                klant.getVensteruren(), klant.getVrachtbeperking(), klant.getChauffeursbeperking(),
                klant.getVrijveld());

        sessionFactory.getCurrentSession().update(transportAdres);
        Klant klnt = new Klant(klant.getKlantid(), 
            klant.getTransportid(), klant.getKlantnaam(), 
            klant.getVoornaam(), klant.getBedrijf(), 
            klant.getWebsite(), klant.getBetalingscondities(), 
            klant.getMunt(), klant.getBtwregime(), klant.getBtwnummer(), 
            klant.getOndernemingsnummer(), klant.getIban(), klant.getBic()); 
        sessionFactory.getCurrentSession().update(klnt);
    }
    /**
     * Mapped een hibernate query naar een objecten klasse
     * @param list
     * @return List<TransportView>
     */
    public List<KlantObjectView> mapJson(List list){
        List<KlantObjectView> transportViews = new ArrayList<KlantObjectView>();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            Object[] row = (Object[]) iter.next();
            KlantObjectView transportView = 
                    new KlantObjectView(row[0],
                    row[1],row[2],row[3], row[4], row[5],row[6], row[7], row[8], 
                    row[9], row[10], row[11], row[12], row[13], 
                    row[14], row[15],row[16], row[17], row[18], row[19], row[20], row[21], 
                    row[22], row[23], row[24],row[25], row[26], row[27], row[28], row[29], row[30], row[31], row[32], row[33]);
            transportViews.add(transportView);
        }
        return transportViews;
    }
}
