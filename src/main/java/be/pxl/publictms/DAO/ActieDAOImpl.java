/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Actie;
import be.pxl.publictms.view.ActieView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van ActieDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Stijn ceunen, laurens putseys
 */
@Repository
public class ActieDAOImpl implements ActieDAO{
    
    final String getActiesPerOpdracht ="select a.actieid, t.naam, ad.Straat, ad.nummer, ad.bus, ad.land, ad.postcode, \n" +
        "c.email, c.telefoon, c.gsm, c.fax, ta.Taalnaam,t.actief, t.soortadres, t.Vensteruren,\n" +
        "t.Vrachtbeperking, t.Chauffeursbeperking, t.VrijVeld as \"transport opmerking\",\n" +
        "a.actieklaar, a.lading, a.vrijveld as \"actie opmerking\", a.opdrachtid \n" +
        "from actie a\n" +
        "inner join TransportAdres t\n" +
        "on a.TransportId = t.TransportId\n" +
        "inner join Adres ad\n" +
        "on t.adresid = ad.adresid\n" +
        "inner join contact c\n" +
        "on t.contactid = c.contactid\n" +
        "inner join taal ta\n" +
        "on t.taal = ta.taalid\n" +
        "where opdrachtid = :id";
    
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
     * Een actie toevoegen.
     * @param actie 
     */
    @Override
    public void addActie(Actie actie) {
        sessionFactory.getCurrentSession().save(actie);
    }
    /**
     * Aan de hand van de index zal deze alle acties ophalen die bij de 
     * bijhorende opdracht horen. Deze id is de index van een opdracht.
     * @param id 
     * @return List met acties 
     */
    @Override
    public List<Actie> getActiesVanOpdracht(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Actie where OpdrachtId = :id");
        query.setParameter("id", id);
        return query.list();
    }
    /**
     * Aan de hand van de index kan men een actie verwijderen
     * @param id 
     */
    @Override
    public void deleteActie(int id) {
        Actie actie = (Actie)sessionFactory.getCurrentSession().load(Actie.class, id);
        if(null != actie){
            sessionFactory.getCurrentSession().delete(actie);
        }
    }
    /**
     * Update een actie
     * @param actie 
     */
    @Override
    public void updateActie(Actie actie) {
        sessionFactory.getCurrentSession().update(actie);
    }
    /**
     * Geeft alle acties per opdracht zonder indexen maar als bruikbaar gegeven.
     * @param id
     * @return List
     */
    @Override
    public List getActiesPerOpdracht(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(getActiesPerOpdracht);
        query.setParameter("id", id);    
        return mapJson(query.list());
        //return query.list();
    }
    /**
     * Zet de actie status op actief of niet actief
     * @param klaar
     * @param id 
     */
    public void setKlaar(boolean klaar, int id){
        Actie actie = (Actie)sessionFactory.getCurrentSession().load(Actie.class, id);
        if(null != actie){
            actie.setActieklaar(klaar);
            sessionFactory.getCurrentSession().update(actie);
        }
    }
    
    public List<ActieView> mapJson(List list){
        List<ActieView> acties = new ArrayList<ActieView>();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            Object[] row = (Object[]) iter.next();
            ActieView actieView = 
                    new ActieView(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], 
                    row[10], row[11], row[12], row[13], row[14], row[15], row[16], row[17], row[18], row[19], row[20], row[21]);
            acties.add(actieView);
        }
        return acties;
    }
    
}
