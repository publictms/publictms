/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Oplegger;
import be.pxl.publictms.view.OpleggerView;
import java.util.List;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Oplegger".
 * 
 * @author Laurens
 */
public interface OpleggerService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Oplegger.
     * 
     * @param oplegger     POJO representatie van de data die toegevoegd wordt.
     */
    public void addOplegger(Oplegger oplegger);
    
    /**
     * Declaratie van de methode voor het ophalen van alle records uit de tabel
     * Oplegger.
     * 
     * @return      Lijst van data van de tabel Oplegger. Elk record wordt
     *              voorgesteld met POJO Oplegger.
     */
    public List getOpleggers();
    
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Oplegger met een bepaald id.
     * 
     * @param id    Het opleggerid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    public OpleggerView getOplegger(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Oplegger.
     * 
     * @param id    Het opleggerid van het record dat verwijderd moet worden.
     */
    public void deleteOpleggers(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Oplegger.
     * 
     * @param oplegger     POJO van de geüpdate data.
     */
    public void updateOplegger(OpleggerView opleggerView);
}
