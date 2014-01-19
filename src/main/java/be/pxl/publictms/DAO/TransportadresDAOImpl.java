/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Adres;
import be.pxl.publictms.pojo.Contact;
import be.pxl.publictms.pojo.Postcode;
import be.pxl.publictms.pojo.Taal;
import be.pxl.publictms.pojo.Transportadres;
import be.pxl.publictms.view.TransportView;
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

    private final String qryContacten = "select t.transportid,t.adresid,t.contactid,t.taal, t.naam, t.soortadres,t.actief, t.vensteruren, t.vrachtbeperking, t.chauffeursbeperking, t.vrijveld,\n" +
"      a.straat, a.nummer, a.bus, a.land, a.postcode, p.gemeente,c.email, c.telefoon, c.gsm, c.fax, ta.taalnaam\n" +
"        from transportadres t\n" +
"           inner join adres a\n" +
"            on a.adresid = t.adresid\n" +
"            inner join contact c\n" +
"            on t.contactid = c.contactid\n" +
"            inner join taal ta\n" +
"            on t.taal = ta.taalid\n" +
"            inner join postcode p\n" +
"            on p.postcode = a.postcode";
    
    private final String qryContact = "select t.transportid,t.adresid,t.contactid,t.taal, t.naam, t.soortadres,t.actief, t.vensteruren, t.vrachtbeperking, t.chauffeursbeperking, t.vrijveld,\n" +
"      a.straat, a.nummer, a.bus, a.land, a.postcode, p.gemeente,c.email, c.telefoon, c.gsm, c.fax, ta.taalnaam\n" +
"        from transportadres t\n" +
"           inner join adres a\n" +
"            on a.adresid = t.adresid\n" +
"            inner join contact c\n" +
"            on t.contactid = c.contactid\n" +
"            inner join taal ta\n" +
"            on t.taal = ta.taalid\n" +
"            inner join postcode p\n" +
"            on p.postcode = a.postcode\n" +
"            where t.transportid =:id";

    @Autowired
    private SessionFactory sessionFactory;
    /**
     * zorgt ervoor dat sessionFactory wordt geïnitialiseerd
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
    public void addTransportadres(TransportView transportView) {
        Postcode postcode = new Postcode(transportView.getPostcode().toString(), transportView.getGemeente().toString());
        Adres adres  = mapNaarAdres(transportView);
        Contact contact = mapNaarContact(transportView);
        Taal taal = mapNaarTaal(transportView);
        sessionFactory.getCurrentSession().saveOrUpdate(taal);
        sessionFactory.getCurrentSession().save(adres);
        sessionFactory.getCurrentSession().save(contact);
        sessionFactory.getCurrentSession().saveOrUpdate(postcode);
        System.out.println(adres.getAdresid()+" "+ contact.getContactid()+" "+ taal.getTaalid());
        Transportadres transportadres = mapNaarTransportadres(transportView, adres.getAdresid(), contact.getContactid(), taal.getTaalid());
        //Transportadres transportadres = mapNaarTransportadres(transportView, 2, 2, 2);
        sessionFactory.getCurrentSession().saveOrUpdate(taal);
        sessionFactory.getCurrentSession().save(adres);
        sessionFactory.getCurrentSession().save(contact);
        sessionFactory.getCurrentSession().saveOrUpdate(postcode);
        sessionFactory.getCurrentSession().save(transportadres);
    }
    /**
     * Geeft een lijst met transportadressen
     * @param id
     * @return List
     */
    @Override
    public List getTransportadres(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryContacten);   
        return mapJson(query.list());
    }
    /**
     * Geef een transport adres terug aan de hand van zijn index.
     * @param id
     * @return Transportadres
     */
    @Override
    public TransportView getTransportadres(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryContact);
        query.setParameter("id", id);    
        return mapJson(query.list()).get(0);
    }
    /**
     * Verwijder een transport adres aan de hand zijn index.
     * @param id 
     */
    @Override
    public void deleteTransportadres(int id) {
        Transportadres transportadres = (Transportadres)sessionFactory.getCurrentSession().load(Transportadres.class, id);
        if(null != transportadres){
            sessionFactory.getCurrentSession().delete(transportadres);
            Contact contact = (Contact)sessionFactory.getCurrentSession().load(Contact.class, transportadres.getContactid());
            Adres adres = (Adres)sessionFactory.getCurrentSession().load(Adres.class, transportadres.getAdresid());
            sessionFactory.getCurrentSession().delete(contact);
            sessionFactory.getCurrentSession().delete(adres);
        }
    }
    /**
     * Bewerk een transport adres aan de hand van een Transportadres object.
     * @param transportadres 
     */
    @Override
    public void updateTransportadres(TransportView transportView) {
            Postcode postcode = (Postcode)sessionFactory.getCurrentSession().load(Postcode.class, transportView.getPostcode().toString());
            postcode.setGemeente(transportView.getGemeente().toString());
            Adres adres  = mapNaarAdres(transportView);
            Contact contact = mapNaarContact(transportView);
            Taal taal = mapNaarTaal(transportView);
            Transportadres transportadres = mapNaarTransportadres(transportView, adres.getAdresid(), contact.getContactid(), taal.getTaalid());
            sessionFactory.getCurrentSession().update(taal);
            sessionFactory.getCurrentSession().update(adres);
            sessionFactory.getCurrentSession().update(contact);
            sessionFactory.getCurrentSession().update(postcode);
            sessionFactory.getCurrentSession().update(transportadres);
    }
    
    public List<TransportView> mapJson(List list){
        List<TransportView> transportViews = new ArrayList<TransportView>();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            Object[] row = (Object[]) iter.next();
            TransportView transportView = 
                    new TransportView(row[0],
                    row[1],row[2],row[3], row[4], row[5],row[6], row[7], row[8], 
                    row[9], row[10], row[11], row[12], row[13], 
                    row[14], row[15],row[16], row[17], row[18], row[19], row[20], row[21]);
            transportViews.add(transportView);
        }
        return transportViews;
    }
    public Adres mapNaarAdres(TransportView transportView){
        int adresid = 0;
        try{
            adresid = Integer.parseInt(transportView.getAdresid().toString());
        }catch(Exception ex){
            ex.toString();
        }
        return new Adres(adresid, 
        transportView.getPostcode().toString(), 
        transportView.getStraat().toString(), 
        Short.parseShort(transportView.getNummer().toString()), 
        transportView.getBus().toString(), 
        transportView.getLand().toString());
    }
    public Contact mapNaarContact(TransportView transportView){
        int contactId = 0;
        try{
            contactId = Integer.parseInt(transportView.getContactid().toString());
        }catch(Exception ex){
            ex.toString();
        }
        return new Contact(contactId, 
        transportView.getEmail().toString(), 
        transportView.getTelefoon().toString(), 
        transportView.getGsm().toString(), 
        transportView.getFax().toString());
    }
    public Taal mapNaarTaal(TransportView transportView){
        int taalId = 0;
        try{
            taalId = Integer.parseInt(transportView.getTaalid().toString());
        }catch(Exception ex){
            ex.toString();
        }
        return new Taal(taalId, 
                transportView.getTaalNaam().toString());
    }
    public Transportadres mapNaarTransportadres(TransportView transportView, int adresid, int contactid, int taalid){
        return new Transportadres(adresid, contactid, taalid, 
        transportView.getNaam().toString(), 
        Boolean.parseBoolean(transportView.getActief().toString()),
        transportView.getSoortadres().toString(), 
        transportView.getVensteruren().toString(), 
        transportView.getVrachtbeperking().toString(), 
        transportView.getChauffeursbeperking().toString(), 
        transportView.getVrijveld().toString());
    }
    public Transportadres mapNaarTransportadres(TransportView transportView){
        return new Transportadres(Integer.parseInt(transportView.getTransportid().toString()), 
        Integer.parseInt(transportView.getAdresid().toString()), 
        Integer.parseInt(transportView.getContactid().toString()), 
        Integer.parseInt(transportView.getTaalid().toString()), 
        transportView.getNaam().toString(), 
        Boolean.parseBoolean(transportView.getActief().toString()),
        transportView.getSoortadres().toString(), 
        transportView.getVensteruren().toString(), 
        transportView.getVrachtbeperking().toString(), 
        transportView.getChauffeursbeperking().toString(), 
        transportView.getVrijveld().toString());
    }
}
