/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Contact;

/**
 * interface die methoden voorziet om adressen toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Laurens Putseys
 */
public interface ContactDAO {
    /**
     * Voeg een contact toe aan de databank.
     * @param contact 
     */
    public void addContact(Contact contact);
    /**
     * Geeft een contact terug aan de hand van de bijhorende parameter.
     * @param id
     * @return contact
     */
    public Contact getContact(int id);
    /**
     * delete contact aan de hand van een bijhorend id.
     * @param id 
     */
    public void deleteContact(int id);
    /**
     * Update een contact object.
     * @param contact 
     */
    public void updateContact(Contact contact);
}
