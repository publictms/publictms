/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Adres;

/**
 * interface die methoden voorziet om adressen toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Laurens Putseys
 */
public interface AdresDAO {
    /**
     * Voeg een adres object toe
     * @param adres 
     */
    public void addAdres(Adres adres);
    /**
     * Geeft een adres terug aan de hand van een id.
     * @param id
     * @return Adres 
     */
    public Adres getAdres(int id);
    /**
     * Verwijdert een adres aan de database aan de hand van zijn id
     * @param id 
     */
    public void deleteAdres(int id);
    /**
     * Bewerkt een bestaand adres aan de hand van zijn id.
     * @param adres 
     */
    public void updateAdres(Adres adres);
}
