/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Opdracht;
import java.util.List;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Opdracht".
 * 
 * @author Stijn
 */
public interface OpdrachtService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Opdracht.
     * 
     * @param opdracht     POJO representatie van de data die toegevoegd wordt.
     */
    public void addOpdracht(Opdracht opdracht);
    
    /**
     * Declaratie van de methode voor het ophalen van alle records uit de tabel
     * Opdracht
     * 
     * @return      Lijst van data van de tabel Opdracht. Elk record wordt
     *              voorgesteld met POJO Opdracht.
     */
    public List<Opdracht> getOpdracht();
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Opdracht.
     * 
     * @param id    Het opdrachtid van het record dat verwijderd moet worden.
     */
    public void deleteOpdracht(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Opdracht.
     * 
     * @param opdracht     POJO van de geüpdate data.
     */
    public void updateOpdracht(Opdracht opdracht);
}
