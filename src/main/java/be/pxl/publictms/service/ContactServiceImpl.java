/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.ContactDAO;
import be.pxl.publictms.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het ContactService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Contact"
 * worden hier uitgewerkt. De methodes maken gebruik van ContactDAO waar
 * de query's, acties worden gedefiniëerd.
 * @Service een autowire voor de service class, de class waar de businesslogica 
 * komt. Men moet dus geen bean definities schrijven in de context xml.
 * @Autowired annotatie wordt gebruikt om een automatische link te leggen met
 * een bean.
 * @Transactional staat toe een overdracht te doen met de databank.
 * 
 * @author Laurens
 */
@Service
public class ContactServiceImpl implements ContactService{
    
    @Autowired
    private ContactDAO contactDAO;

    /**
     * Methode voor het toevoegen van data aan de tabel Contact.
     * 
     * @param contact   POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    /**
     * Methode voor het ophalen van een record uit de tabel Contact met een 
     * bepaald id.
     * 
     * @param id    Het contactid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    @Transactional
    public Contact getContact(int id) {
        return contactDAO.getContact(id);
    }

    /**
     * Methode voor het verwijderen van een record uit de tabel Contact.
     * 
     * @param id    Het contactid van het record dat verwijderd moet worden.
     */
    @Override
    public void deleteContact(int id) {
        contactDAO.deleteContact(id);
    }

    /**
     * Methode voor het updaten van een record uit de tabel Contact.
     * 
     * @param contact   POJO van de geüpdate data.
     */
    @Transactional
    public void updateContact(Contact contact) {
        contactDAO.updateContact(contact);
    }  
}
