/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Taal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van TaalDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Stijn Ceunen
 */
@Repository
public class TaalDAOImpl implements TaalDAO{
    
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
     * Voeg een nieuwe taal toe.
     * @param taal 
     */
    @Override
    public void addTaal(Taal taal) {
        sessionFactory.getCurrentSession().save(taal);
    }
    /**
     * Geeft een lijst met talen terug
     * @return List<Taal>
     */
    @Override
    public List<Taal> getTaal(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Taal");
        return query.list(); 
    }
    /**
     * Geef een taal terug aan de hand van zijn index.
     * @param id
     * @return Taal
     */
    @Override
    public Taal getTaal(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Taal where TaalId = :id");
        query.setParameter("id", id);
        return (Taal)query.list().get(0);
    }
    /**
     * Verwijder een taal aan de hand van zijn index.
     * @param id 
     */
    @Override
    public void deleteTaal(int id) {
        Taal taal = (Taal)sessionFactory.getCurrentSession().load(Taal.class, id);
        if(null != taal){
            sessionFactory.getCurrentSession().delete(taal);
        }
    }
    /**
     * Bewerk een taal aan de hand van een Taal object.
     * @param taal 
     */
    @Override
    public void updateTaal(Taal taal) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Taal where TaalNaam = :naam");
        query.setParameter("naam", taal.getTaalnaam());
        //Taal zoekTaal = (Taal)query.list().get(0);
        if(query.list().size() != 1){
            sessionFactory.getCurrentSession().save(taal);
            sessionFactory.getCurrentSession().update(taal);
        }else{
            sessionFactory.getCurrentSession().update(taal);
        }
    }
}
