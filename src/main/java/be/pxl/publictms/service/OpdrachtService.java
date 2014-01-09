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
 * @author Stijn Ceunen
 */
public interface OpdrachtService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Opdracht.
     * 
     * @param opdracht     POJO representatie van de data die toegevoegd wordt.
     */
    public void addOpdracht(Opdracht opdracht); 
    
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
    /**
     * Geeft een list met opdracht terug
     * @return List Opdracht
     */
    public List getOpdrachten();
    /**
     * Geef een lijst terug met specifieke opdrachten per werknemer
     * @return list
     */
    public List getOpdrachtenWerknemer(int id);
    /**
     * Is de levering afgeleverd op klaar zetten. True or false. Aan de hand van 
     * een index die verwijst naar de opdracht.
     * @param klaar
     * @param id 
     */
    public void setKlaar(boolean klaar, int id);
}
