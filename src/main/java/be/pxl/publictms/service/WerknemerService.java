/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Werknemer;
import be.pxl.publictms.view.WerknemerView;
import be.pxl.publictms.view.WerknemerObjectView;
import java.util.List;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Werknemer".
 * 
 * @author Laurens
 */
public interface WerknemerService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Werknemer.
     * 
     * @param werknemer     POJO representatie van de data die toegevoegd wordt.
     */
    public void addWerknemer(WerknemerView werknemerCompleet);
    
    /**
     * Declaratie van de methode voor het ophalen van alle records uit de tabel
     * Werknemer.
     * 
     * @return      Lijst van data van de tabel Werknemer. Elk record wordt
     *              voorgesteld met POJO Werknemer.
     */
    public List<WerknemerObjectView> getWerknemers();
    
    /**
     * Declaratie van de methode voor het ophalen 1 row van de tabel Werknemer.
     * 
     * @return      Het record met werknemerid id.
     */
    public WerknemerObjectView getWerknemer(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Werknemer.
     * 
     * @param id    Het werkenemerid van het record dat verwijderd moet worden.
     */
    public void deleteWerknemer(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Werknemer.
     * 
     * @param werknemer     POJO van de geüpdate data.
     */
    public void updateWerknemer(WerknemerView werknemerCompleet);
    
}
