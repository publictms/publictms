/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Voertuig;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stijn
 */
@Repository
public class VoertuigDAOImpl implements VoertuigDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void addVoertuig(Voertuig voertuig) {
        sessionFactory.getCurrentSession().save(voertuig);
    }

    @Override
    public void deleteVoertuig(int id) {
        Voertuig voertuig = (Voertuig)sessionFactory.getCurrentSession().load(Voertuig.class, id);
        if(null != voertuig){
            sessionFactory.getCurrentSession().delete(voertuig);
        }
    }

    @Override
    public void updateVoertuig(Voertuig voertuig) {
        sessionFactory.getCurrentSession().update(voertuig);
    }

    @Override
    public List<Voertuig> getVoertuigen() {
        return sessionFactory.getCurrentSession().createQuery("from Voertuig").list();
    }

    @Override
    public Voertuig getVoertuig(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Voertuig where VoertuigId = :id");
        query.setParameter("id", id);
        return (Voertuig)query.list().get(0);
    }
}
