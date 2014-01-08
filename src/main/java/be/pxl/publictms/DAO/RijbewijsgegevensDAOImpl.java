/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Rijbewijsgegevens;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van RijbewijsgegevensDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Stijn Ceunen
 */
@Repository
public class RijbewijsgegevensDAOImpl implements RijbewijsgegevensDAO{
    
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
     * Voeg rijbewijs gegevens toe aan de hand van een Rijbewijsgegevens object.
     * @param rijbewijsgegevens 
     */
    @Override
    public void addRijbewijsgegevens(Rijbewijsgegevens rijbewijsgegevens) {
        sessionFactory.getCurrentSession().save(rijbewijsgegevens);
    }
    /**
     * Geeft de rijbewijs gegevens terug aan de hand van zijn index.
     * @param id
     * @return Rijbewijsgegevens
     */
    @Override
    public Rijbewijsgegevens getRijbewijsgegevens(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Rijbewijsgegevens where RijbewijsId = :id");
        query.setParameter("id", id);
        return (Rijbewijsgegevens)query.list().get(0);
    }
    /**
     * Verwijder rijbewijs gegevens aan de hand van zijn index.
     * @param id 
     */
    @Override
    public void deleteRijbewijsgegevens(int id) {
        Rijbewijsgegevens rijbewijsgegevens = (Rijbewijsgegevens)sessionFactory.getCurrentSession().load(Rijbewijsgegevens.class, id);
        if(null != rijbewijsgegevens){
            sessionFactory.getCurrentSession().delete(rijbewijsgegevens);
        }
    }
    /**
     * Bewerk de rijbewijs gegevens aan de hand van een Rijbewijsgegevens object.
     * @param rijbewijsgegevens 
     */
    @Override
    public void updateRijbewijsgegevens(Rijbewijsgegevens rijbewijsgegevens) {
        sessionFactory.getCurrentSession().update(rijbewijsgegevens);
    }
    
}
