/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Opdracht;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van OpdrachtDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Stijn Ceunen
 */
@Repository
public class OpdrachtDAOImpl implements OpdrachtDAO{

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
     * Voeg een opdracht toe.
     * @param opdracht 
     */
    @Override
    public void addOpdracht(Opdracht opdracht) {
        sessionFactory.getCurrentSession().save(opdracht);
    }
    /**
     * Geeft een list met opdracht terug
     * @return List Opdracht
     */
    @Override
    public List<Opdracht> getOpdracht() {
        return sessionFactory.getCurrentSession().createQuery("from Opdracht").list();
    }
    /**
     * Delete een opdracht aan de hand van zijn index.
     * @param id 
     */
    @Override
    public void deleteOpdracht(int id) {
        Opdracht opdracht = (Opdracht)sessionFactory.getCurrentSession().load(Opdracht.class, id);
        if(null != opdracht){
            sessionFactory.getCurrentSession().delete(opdracht);
        }
    }
    /**
     * Bewerkt een opdracht aan de hand een opdracht object
     * @param opdracht 
     */
    @Override
    public void updateOpdracht(Opdracht opdracht) {
        sessionFactory.getCurrentSession().update(opdracht);
    }
    
}
