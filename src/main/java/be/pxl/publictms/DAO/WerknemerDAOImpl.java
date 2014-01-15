/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Werknemer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van WerknemerDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Laurens Putseys
 */
@Repository
public class WerknemerDAOImpl implements WerknemerDAO{
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
     * Voeg een werknemer toe aan de hand van een werknemer object.
     * @param werknemer 
     */
    @Override
    public void addWerknemer(Werknemer werknemer) {
        sessionFactory.getCurrentSession().save(werknemer);
    }
    /**
     * Geef een lijst terug met alle werknemers.
     * @return List Werknemer
     */
    @Override
    public List<Werknemer> getWerknemers() {
        return sessionFactory.getCurrentSession().createQuery("from Werknemer").list();
    }
    /**
     * Geeft het record met werknemerid id.
     * @param id    waarde dat de kolom werknemerid moet hebben
     * @return      de data van de record met werknemerid id.
     */
    @Override
    public Werknemer getWerknemer(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Werknemer where werknemerid = :id");
        query.setParameter("id", id);
        return (Werknemer)query.list().get(0);
    }
    /**
     * Verwijder een werknemer aan de hand van zijn index.
     * @param id 
     */
    @Override
    public void deleteWerknemer(int id) {
        Werknemer werknemer = (Werknemer)sessionFactory.getCurrentSession().load(Werknemer.class, id);
        if(null != werknemer){
            sessionFactory.getCurrentSession().delete(werknemer);
        }
    }
    /**
     * Bewerk een werknemer aan de hand van een werknmer object.
     * @param werknemer 
     */
    @Override
    public void updateWerknemer(Werknemer werknemer) {
        sessionFactory.getCurrentSession().update(werknemer);
    }    
}
