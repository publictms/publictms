/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Bericht;
import java.util.List;

/**
 * Interface dat de methodes voor BerichtServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Bericht".
 * 
 * @author Laurens
 */
public interface BerichtService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel 
     * Bericht.
     * 
     * @param bericht     POJO representatie van de data die toegevoegd wordt.
     */
    public void send(Bericht bericht);
    
    /**
     * Declaratie van de methode voor het ophalen van een aantal record 
     * uit de tabel Bericht voor een bepaald ontvangerid.
     * 
     * @param id    Het ontvangerid van de records die opgehaald moet worden.
     * @return      Lijst van data van de tabel Bericht. Elk record wordt
     *              voorgesteld met POJO Bericht.
     */
    public List<Bericht> getBerichten(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Bericht.
     * 
     * @param id    Het berichtid van het record dat verwijderd moet worden.
     */
    public void deleteBericht(int id);
}
