/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Klant;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van KlantDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Laurens Putseys
 */
@Repository
public class KlantDAOImpl implements KlantDAO{
    
    
    
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
     * Voegt een klant toe.
     * @param klant 
     */
    @Override
    public void addKlant(Klant klant) {
        sessionFactory.getCurrentSession().save(klant);
    }
    /**
     * Geeft een lijst van klanten terug
     * @return List Klanten
     */
    @Override
    public List getKlanten() {
        return sessionFactory.getCurrentSession().createQuery("from Klant").list();
    }
    /**
     * Delete een klant aan de hand van zijn id.
     * @param id 
     */
    @Override
    public void deleteKlant(int id) {
        Klant klant = (Klant)sessionFactory.getCurrentSession().load(Klant.class, id);
        if(null != klant){
            sessionFactory.getCurrentSession().delete(klant);
        }
    }
    /**
     * Bewerkt een klant aan de hand een klant object
     * @param klant 
     */
    @Override
    public void updateKlant(Klant klant) {
        sessionFactory.getCurrentSession().update(klant);
    }
    /**
     * Geeft een specifieke klant terug aan de hand van zijn index.
     * @param id
     * @return klant
     */
    @Override
    public Klant getKlant(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Klant where KlantId = :id");
        query.setParameter("id", id);
        return (Klant)query.list().get(0);
    }
    
    
    
}
