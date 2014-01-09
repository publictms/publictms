/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Rijbewijsgegevens;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Rijbewijsgegevens".
 * 
 * @author Stijn
 */
public interface RijbewijsgegevensService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel 
     * Rijbewijsgegevens.
     * 
     * @param rijbewijsgegevens     POJO representatie van de data die 
     *                              toegevoegd wordt.
     */
    public void addRijbewijsgegevens(Rijbewijsgegevens rijbewijsgegevens);
    
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Rijbewijsgegevens met een bepaald id.
     * 
     * @param id    Het rijbewijsgegevensid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    public Rijbewijsgegevens getRijbewijsgegevens(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Rijbewijsgegevens.
     * 
     * @param id    Het rijbewijsgegevensid van het record dat verwijderd moet worden.
     */
    public void deleteRijbewijsgegevens(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Rijbewijsgegevens.
     * 
     * @param rijbewijsgegevens     POJO van de geüpdate data.
     */
    public void updateRijbewijsgegevens(Rijbewijsgegevens rijbewijsgegevens);
}
