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
 * Implementatie van VoertuigDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Stijn Ceunen
 */
@Repository
public class VoertuigDAOImpl implements VoertuigDAO{
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
     * Voeg een nieuw voertuig toe.
     * @param voertuig 
     */
    @Override
    public void addVoertuig(Voertuig voertuig) {
        sessionFactory.getCurrentSession().save(voertuig);
    }
    /**
     * Verwijder een voertuig aan de hand van zijn index.
     * @param id 
     */
    @Override
    public void deleteVoertuig(int id) {
        Voertuig voertuig = (Voertuig)sessionFactory.getCurrentSession().load(Voertuig.class, id);
        if(null != voertuig){
            sessionFactory.getCurrentSession().delete(voertuig);
        }
    }
    /**
     * Bewerk een voertuig aan de hand van een Voertuig object.
     * @param voertuig 
     */
    @Override
    public void updateVoertuig(Voertuig voertuig) {
        sessionFactory.getCurrentSession().update(voertuig);  
    }
    /**
     * Geeft een lijst met voertuigen terug.
     * @return List Voertuig
     */
    @Override
    public List<Voertuig> getVoertuigen() {
        return sessionFactory.getCurrentSession().createQuery("from Voertuig").list();
    }
    /**
     * Geeft een voertuig terug aan de hand van zijn index.
     * @param id
     * @return Voertuig
     */
    @Override
    public Voertuig getVoertuig(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Voertuig where VoertuigId = :id");
        query.setParameter("id", id);
        return (Voertuig)query.list().get(0);
    }
}
