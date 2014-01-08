/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Postcode;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van PostcodeDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Laurens Putseys
 */
@Repository
public class PostcodeDAOImpl implements PostcodeDAO{
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
     * Geeft een Postcode object terug met bijhorende index, index hier is in dit geval een postcode.
     * @param id
     * @return postcode
     */
    @Override
    public Postcode getGemeente(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Postcode where postcode = :id");
        query.setParameter("id", id);
        return (Postcode)query.list().get(0);
    }
    /**
     * Geeft een lijst met Postcode objecten terug
     * @return List Postcode
     */
    @Override
    public List<Postcode> getGemeente(){
        return sessionFactory.getCurrentSession().createQuery("from Postcode").list();
    }
    /**
     * Voeg een nieuwe gemeente met postcode terug aan de hand van Postcode object.
     * @param postcode 
     */
    @Override
    public void addGemeente(Postcode postcode) {
        sessionFactory.getCurrentSession().save(postcode);
    }
    /**
     * Bewerk een geemente of postcode
     * @param postcode 
     */
    @Override
    public void updateGemeente(Postcode postcode) {
        sessionFactory.getCurrentSession().update(postcode);
    }
    /**
     * Verwijder een gemeente/postcode aan de hand van zijn postcode.
     * @param id 
     */
    @Override
    public void deleteGemeente(String id) {
        Postcode postcode = (Postcode)sessionFactory.getCurrentSession().load(Postcode.class, id);
        if(null != postcode){
            sessionFactory.getCurrentSession().delete(postcode);
        }
    }
    
    
}
