/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Bericht;
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
        sessionFactory.getCurrentSession().save(bericht);
    }
    /**
     * Geeft alle berichten voor één ontvanger, id is de index van deze persoon.
     * @param id
     * @return List berichten
     */
    @Override
    public List<Bericht> getBerichten(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Bericht where OntvangerId = :id");
        query.setParameter("id", id);
        return query.list();
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
}
