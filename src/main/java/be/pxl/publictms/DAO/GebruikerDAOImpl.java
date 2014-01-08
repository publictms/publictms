/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Gebruiker;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van GebruikerDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Laurens Putseys
 */
@Repository
public class GebruikerDAOImpl implements GebruikerDAO{

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
     * Voeg een gebruiker toe aan de hand van een Gebruiker object.
     * @param gebruiker 
     */
    @Override
    public void addGebruiker(Gebruiker gebruiker) {
        sessionFactory.getCurrentSession().save(gebruiker);
    }
    /**
     * Geeft een lijst van gebruikers terug.
     * @return List Gebruiker
     */
    @Override
    public List<Gebruiker> getGebruikers() {
        return sessionFactory.getCurrentSession().createQuery("from Gebruiker").list();
    }
    /**
     * Delete een gebruiker aan de hand van zijn index.
     * @param id 
     */
    @Override
    public void deleteGebruiker(int id) {
        Gebruiker gebruiker = (Gebruiker)sessionFactory.getCurrentSession().load(Gebruiker.class, id);
        if(null != gebruiker){
            sessionFactory.getCurrentSession().delete(gebruiker);
        }
    }
    /**
     * Bewerkt een gebruiker aan de hand van een Gebruiker object.
     * @param gebruiker 
     */
    @Override
    public void updateGebruiker(Gebruiker gebruiker) {
        sessionFactory.getCurrentSession().update(gebruiker);
    }  
}
