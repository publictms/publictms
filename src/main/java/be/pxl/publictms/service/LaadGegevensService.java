/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Laadgegevens;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Laadgegevens".
 * 
 * @author Laurens
 */
public interface LaadGegevensService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Laadgegevens.
     * 
     * @param laadgegevens     POJO representatie van de data die toegevoegd wordt.
     */
    public void addLaadgegevens(Laadgegevens laadgegevens);
    
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Laadgegevens met een bepaald id.
     * 
     * @param id    Het laadgegevensid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    public Laadgegevens getLaadgegevens(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Laadgegevens.
     * 
     * @param id    Het laadgegevensid van het record dat verwijderd moet worden.
     */
    public void deleteLaadgegeven(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Laadgegevens.
     * 
     * @param laadgegevens     POJO van de geüpdate data.
     */
    public void updateLaadgegeven(Laadgegevens laadgegevens);
}
