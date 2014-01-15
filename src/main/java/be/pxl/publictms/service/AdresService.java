/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Adres;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Adres".
 * 
 * @author Laurens
 */
public interface AdresService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Adres.
     * 
     * @param adres     POJO representatie van de data die toegevoegd wordt.
     */
    public void addAdres(Adres adres);
    
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Adres met een bepaald id.
     * 
     * @param id    Het adresid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    public Adres getAdres(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Adres.
     * 
     * @param id    Het adresid van het record dat verwijderd moet worden.
     */
    public void deleteAdres(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Adres.
     * 
     * @param adres     POJO van de geüpdate data.
     */
    public void updateAdres(Adres adres);
}
