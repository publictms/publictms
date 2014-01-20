/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Adres;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van AdresDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Laurens Putseys
 */
@Repository
public class AdresDAOImpl implements AdresDAO{
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
     * Als paramaeter wordt er een adres object verwacht en deze zal hij opslaan in de database.
     * @param adres 
     */
    @Override
    public void addAdres(Adres adres) {
        sessionFactory.getCurrentSession().save(adres);
    }
    /**
     * Aan de hand van een id zal deze het bijhorend adres zoeken en terug geven als een object.
     * @param id
     * @return adres
     */
    @Override
    public Adres getAdres(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Adres where AdresId = :id");
        query.setParameter("id", id);
        return (Adres)query.list().get(0);
    }
    /**
     * Aan de hand van een id zal deze het bijhorend adres verwijderen uit de databank
     * @param id 
     */
    @Override
    public void deleteAdres(int id) {
        Adres adres = (Adres)sessionFactory.getCurrentSession().load(Adres.class, id);
        if(null != adres){
            sessionFactory.getCurrentSession().delete(adres);
        }
    }
    /**
     * Parameter is een adres object, het object zal worden bijgewerkt in de databank.
     * @param adres 
     */
    @Override
    public void updateAdres(Adres adres) {
        sessionFactory.getCurrentSession().update(adres);
    }
    
}
