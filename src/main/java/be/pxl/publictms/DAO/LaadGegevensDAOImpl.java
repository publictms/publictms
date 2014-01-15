/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Laadgegevens;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van LaadGegevensDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Laurens Putseys
 */
@Repository
public class LaadGegevensDAOImpl implements LaadGegevensDAO{
    
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
     * Om laadgegevens toe te voegen.
     * @param laadgegevens 
     */
    @Override
    public void addLaadgegevens(Laadgegevens laadgegevens) {
        sessionFactory.getCurrentSession().save(laadgegevens);
    }
    /**
     * Geeft de laadgegevens terug aan de hand van zijn index.
     * @param id
     * @return 
     */
    @Override
    public Laadgegevens getLaadgegevens(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Laadgegevens where laadid = :id");
        query.setParameter("id", id);
        return (Laadgegevens)query.list().get(0);
    }
    /**
     * Verwijder laadgegevens aan de hand van zijn index.
     * @param id 
     */
    @Override
    public void deleteLaadgegeven(int id) {
        Laadgegevens laadGegevens = (Laadgegevens)sessionFactory.getCurrentSession().load(Laadgegevens.class, id);
        if(null != laadGegevens){
            sessionFactory.getCurrentSession().delete(laadGegevens);
        }
    }
    /**
     * Bewerk bestaand laadgegevens.
     * @param laadgegevens 
     */
    @Override
    public void updateLaadgegeven(Laadgegevens laadgegevens) {
        sessionFactory.getCurrentSession().update(laadgegevens);
    }
}
