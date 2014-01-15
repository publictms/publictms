/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Contact;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van ContactDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Laurens Putseys
 */
@Repository
public class ContactDAOImpl implements ContactDAO{
    
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
     * Voeg een contact toe aan de databank.
     * @param contact 
     */
    @Override
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }
    /**
     * Geeft een contact terug aan de hand van de bijhorende parameter.
     * @param id
     * @return contact
     */
    @Override
    public Contact getContact(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Contact where ContactId = :id");
        query.setParameter("id", id);
        return (Contact)query.list().get(0);
    }
    /**
     * delete contact aan de hand van een bijhorend id.
     * @param id 
     */
    @Override
    public void deleteContact(int id) {
        Contact contact = (Contact)sessionFactory.getCurrentSession().load(Contact.class, id);
        if(null != contact){
            sessionFactory.getCurrentSession().delete(contact);
        }
    }
    /**
     * Update een contact object.
     * @param contact 
     */
    @Override
    public void updateContact(Contact contact) {
        sessionFactory.getCurrentSession().update(contact);
    }
    
    
    
}
