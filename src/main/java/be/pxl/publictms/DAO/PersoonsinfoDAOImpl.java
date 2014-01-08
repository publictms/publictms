/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Persoonsinfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van PersoonsinfoDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Stijn Ceunen
 */
@Repository
public class PersoonsinfoDAOImpl implements PersoonsinfoDAO{

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
     * Voeg persoonelijke informatie toe aan de hand van een Persoonsinfo object.
     * @param persoonsinfo 
     */
    @Override
    public void addPersoonsinfo(Persoonsinfo persoonsinfo) {
        sessionFactory.getCurrentSession().save(persoonsinfo);
    }
    /**
     * Geeft de persoonelijke informatie terug aan de hand van een index.
     * @param id
     * @return persooninfo
     */
    @Override
    public Persoonsinfo getPersoonsinfo(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Persoonsinfo where InfoId = :id");
        query.setParameter("id", id);
        return (Persoonsinfo)query.list().get(0);
    }
    /**
     * Delete de persoonelijke informatie aan de hand een index.
     * @param id 
     */
    @Override
    public void deletePersoonsinfo(int id) {
        Persoonsinfo persoonsinfo = (Persoonsinfo)sessionFactory.getCurrentSession().load(Persoonsinfo.class, id);
        if(null != persoonsinfo){
            sessionFactory.getCurrentSession().delete(persoonsinfo);
        }
    }
    /**
     * Bewerk de persoonelijke informatie van iemand aan de hand van een persoonsinfo object.
     * @param persoonsinfo 
     */
    @Override
    public void updatePersoonsinfo(Persoonsinfo persoonsinfo) {
        sessionFactory.getCurrentSession().update(persoonsinfo);
    }

}
