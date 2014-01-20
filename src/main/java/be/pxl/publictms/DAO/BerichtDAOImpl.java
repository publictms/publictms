/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Bericht;
import be.pxl.publictms.view.BerichtView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van BerichtDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Laurens Putseys
 */
@Repository
public class BerichtDAOImpl implements BerichtDAO{
    
    final String getBerichten ="select b.berichtid, b.berichttitel, b.bericht, b.datum, "
            + "g.gebruikersnaam as \"verzender\", b.ontvangerid, b.gelezen \n" +
        "from bericht b inner join gebruiker g on b.gebruikerid = g.gebruikerid where b.ontvangerid = :id";
    
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
     * Zal een bericht naar de databank versturen.
     * @param bericht 
     */
    @Override
    public void send(Bericht bericht) {
        Date date = new Date();
        bericht.setDatum(date);
        sessionFactory.getCurrentSession().save(bericht);
    }
    /**
     * Geeft alle berichten voor één ontvanger, id is de index van deze persoon.
     * @param id
     * @return List berichten
     */
    @Override
    public List getBerichten(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(getBerichten);
        query.setParameter("id", id);    
        return mapJson(query.list());
    }
    /**
     * 
     * Verwijdert een bericht waarvan de id overeenkomt.
     * @param id 
     */
    @Override
    public void deleteBericht(int id) {
        Bericht bericht = (Bericht)sessionFactory.getCurrentSession().load(Bericht.class, id);
        if(null != bericht){
            sessionFactory.getCurrentSession().delete(bericht);
        }
    }
    
    public List<BerichtView> mapJson(List list){
        List<BerichtView> berichten = new ArrayList<BerichtView>();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            Object[] row = (Object[]) iter.next();
            BerichtView berichtView;
            berichtView = new BerichtView(row[0], row[1], row[2], row[3], row[4], row[5], row[6]);
            berichten.add(berichtView);
        }
        return berichten;
    }
}
