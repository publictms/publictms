/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Oplegger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van OpleggerDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Laurens Putseys
 */
@Repository
public class OpleggerDAOImpl implements OpleggerDAO{
    
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
     * Voegt een oplegger toe.
     * @param oplegger 
     */
    @Override
    public void addOplegger(Oplegger oplegger) {
        sessionFactory.getCurrentSession().save(oplegger);
    }
    /**
     * Geeft een lijst terug met alle opleggers 
     * @return List Oplegger
     */
    @Override
    public List<Oplegger> getOpleggers() {
        return sessionFactory.getCurrentSession().createQuery("from Oplegger").list();
    }
    /**
     * Geeft een specifieke oplegger terug aan de hand van zijn index.
     * @param id
     * @return Oplegger
     */
    @Override
    public Oplegger getOplegger(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Oplegger where OpleggerId = :id");
        query.setParameter("id", id);
        return (Oplegger)query.list().get(0);
    }
    /**
     * Delete een oplegger aan de hand van zijn index.
     * @param id 
     */
    @Override
    public void deleteOpleggers(int id) {
        Oplegger oplegger = (Oplegger)sessionFactory.getCurrentSession().load(Oplegger.class, id);
        if(null != oplegger){
            sessionFactory.getCurrentSession().delete(oplegger);
        }
    }
    /**
     * Bewerkt een oplegger aan der hand zijn oplegger object.
     * @param oplegger 
     */
    @Override
    public void updateOplegger(Oplegger oplegger) {
        sessionFactory.getCurrentSession().update(oplegger);
    }
}
