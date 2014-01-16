/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Persoonsinfo;
import java.util.List;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Persoonsinfo".
 * 
 * @author Stijn
 */
public interface PersoonsinfoService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Persoonsinfo.
     * 
     * @param persoonsinfo     POJO representatie van de data die toegevoegd wordt.
     */
    public void addPersoonsinfo(Persoonsinfo persoonsinfo);
    /**
     * Geeft een lijst terug met persoonsinfo van iedereen.
     * @return List<persooninfo>
     */
    public List getPersoonsinfo();
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Persoonsinfo met een bepaald id.
     * 
     * @param id    Het persoonsinfoid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    public Persoonsinfo getPersoonsinfo(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Persoonsinfo.
     * 
     * @param id    Het persoonsinfoid van het record dat verwijderd moet worden.
     */
    public void deletePersoonsinfo(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Persoonsinfo.
     * 
     * @param persoonsinfo     POJO van de geüpdate data.
     */
    public void updatePersoonsinfo(Persoonsinfo persoonsinfo);
}
