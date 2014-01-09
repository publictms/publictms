/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Opdracht;
import java.util.List;

/**
 * interface die methoden voorziet om opdrachten toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Stijn Ceunen, Laurens Putseys
 */
public interface OpdrachtDAO {
    /**
     * Voeg een opdracht toe.
     * @param opdracht 
     */
    public void addOpdracht(Opdracht opdracht);
    /**
     * Delete een opdracht aan de hand van zijn index.
     * @param id 
     */
    public void deleteOpdracht(int id);
    /**
     * Bewerkt een opdracht aan de hand een opdracht object
     * @param opdracht 
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
