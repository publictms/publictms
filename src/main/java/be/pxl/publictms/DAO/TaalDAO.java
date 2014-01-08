/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Taal;

/**
 * interface die methoden voorziet om talen toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Stijn Ceunen
 */
public interface TaalDAO {
    /**
     * Voeg een nieuwe taal toe.
     * @param taal 
     */
    public void addTaal(Taal taal);
    /**
     * Geef een taal terug aan de hand van zijn index.
     * @param id
     * @return Taal
     */
    public Taal getTaal(int id);
    /**
     * Verwijder een taal aan de hand van zijn index.
     * @param id 
     */
    public void deleteTaal(int id);
    /**
     * Bewerk een taal aan de hand van een Taal object.
     * @param taal 
     */
    public void updateTaal(Taal taal);
}
