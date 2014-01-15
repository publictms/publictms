/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Contact;

/**
 * Interface dat de methodes voor ContactServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Contact".
 * 
 * @author Laurens
 */
public interface ContactService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel 
     * Contact.
     * 
     * @param contact   POJO representatie van de data die toegevoegd wordt.
     */
    public void addContact(Contact contact);
    
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Contact met een bepaald id.
     * 
     * @param id    Het contactid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    public Contact getContact(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Contact.
     * 
     * @param id    Het contactid van het record dat verwijderd moet worden.
     */
    public void deleteContact(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Contact.
     * 
     * @param contact   POJO van de geüpdate data.
     */
    public void updateContact(Contact contact);
}
