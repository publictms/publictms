/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Taal;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Taal".
 * 
 * @author Stijn
 */
public interface TaalService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Taal.
     * 
     * @param taal     POJO representatie van de data die toegevoegd wordt.
     */
    public void addTaal(Taal taal);
    
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Taal met een bepaald id.
     * 
     * @param id    Het taalid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    public Taal getTaal(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Taal.
     * 
     * @param id    Het taalid van het record dat verwijderd moet worden.
     */
    public void deleteTaal(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Taal.
     * 
     * @param taal     POJO van de geüpdate data.
     */
    public void updateTaal(Taal taal);
}
