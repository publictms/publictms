/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Postcode;
import java.util.List;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Postcode".
 * 
 * @author Laurens
 */
public interface PostcodeService {
    
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Postcode met een bepaald id.
     * 
     * @param id    De postcode van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    public Postcode getGemeente(String id);
    
    /**
     * Declaratie van de methode voor het ophalen van alle records uit de tabel
     * Postcode
     * 
     * @return      Lijst van data van de tabel Postcode. Elk record wordt
     *              voorgesteld met POJO Postcode.
     */
    public List<Postcode> getGemeente();
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Postcode.
     * 
     * @param postcode     POJO representatie van de data die toegevoegd wordt.
     */
    public void addGemeente(Postcode postcode);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Postcode.
     * 
     * @param postcode     POJO van de geüpdate data.
     */
    public void updateGemeente(Postcode postcode);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Postcode.
     * 
     * @param id    Het postcode van het record dat verwijderd moet worden.
     */
    public void deleteGemeente(String id);
}
