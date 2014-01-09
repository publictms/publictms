/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Klant;
import java.util.List;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Klant".
 * 
 * @author Laurens
 */
public interface KlantService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Klant.
     * 
     * @param klant     POJO representatie van de data die toegevoegd wordt.
     */
    public void addKlant(Klant klant);
    
    /**
     * Declaratie van de methode voor het ophalen van alle records uit de tabel
     * Klant
     * 
     * @return      Lijst van data van de tabel Klant. Elk record wordt
     *              voorgesteld met POJO Klant.
     */
    public List<Klant> getKlanten();
    
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Klant met een bepaald id.
     * 
     * @param id    Het klantid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    public Klant getKlant(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Klant.
     * 
     * @param id    Het klantid van het record dat verwijderd moet worden.
     */
    public void deleteKlant(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Klant.
     * 
     * @param klant     POJO van de geüpdate data.
     */
    public void updateKlant(Klant klant); 
}
