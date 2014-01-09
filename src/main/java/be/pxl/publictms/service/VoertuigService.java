/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Voertuig;
import java.util.List;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Voertuig".
 * 
 * @author Stijn
 */
public interface VoertuigService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Voertuig.
     * 
     * @param voertuig     POJO representatie van de data die toegevoegd wordt.
     */
    public void addVoertuig(Voertuig voertuig);
    
    /**
     * Declaratie van de methode voor het ophalen van alle records uit de tabel
     * Voertuig
     * 
     * @return      Lijst van data van de tabel Voertuig. Elk record wordt
     *              voorgesteld met POJO Voertuig.
     */
    public List<Voertuig> getVoertuigen();
    
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Voertuig met een bepaald id.
     * 
     * @param id    Het voertuigid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    public Voertuig getVoertuig(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Voertuig.
     * 
     * @param id    Het voertuigid van het record dat verwijderd moet worden.
     */
    public void deleteVoertuig(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Voertuig.
     * 
     * @param voertuig     POJO van de geüpdate data.
     */
    public void updateVoertuig(Voertuig voertuig);
}
