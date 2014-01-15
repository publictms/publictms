/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Transportadres;
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
    public void addTransportadres(Transportadres transportadres) {
        sessionFactory.getCurrentSession().save(transportadres);
    }
    /**
     * Geef een transport adres terug aan de hand van zijn index.
     * @param id
     * @return Transportadres
     */
    @Override
    public Transportadres getTransportadres(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Transportadres where transportid = :id");
        query.setParameter("id", id);
        return (Transportadres)query.list().get(0);
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
        }
    }
    /**
     * Bewerk een transport adres aan de hand van een Transportadres object.
     * @param transportadres 
     */
    @Override
    public void updateTransportadres(Transportadres transportadres) {
        sessionFactory.getCurrentSession().update(transportadres);
    }
    
}
