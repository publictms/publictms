/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Land;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laurens Putseys
 */
@Repository
public class LandDAOImpl implements LandDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    /**
     * zorgt ervoor dat sessionFactory wordt geïnitialiseerd
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public Land getLand(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Land where landid = :id");
        query.setParameter("id", id);
        return (Land)query.list().get(0);
    }
    
    @Override
    public List<Land> getLanden() {
        return sessionFactory.getCurrentSession().createQuery("from Land").list();
    }

    @Override
    public void addLand(Land Land) {
        sessionFactory.getCurrentSession().save(Land);
    }

    @Override
    public void updateLand(Land land) {
        sessionFactory.getCurrentSession().update(land);
    }

    @Override
    public void deleteLand(int id) {
        Land land = (Land)sessionFactory.getCurrentSession().load(Land.class, id);
        if(null != land){
            sessionFactory.getCurrentSession().delete(land);
        }
    }
    
}
