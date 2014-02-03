/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Werknemer;
import be.pxl.publictms.view.WerknemerView;
import be.pxl.publictms.view.WerknemerObjectView;
import java.util.List;

/**
 * interface die methoden voorziet om werknemers toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Laurens Putseys
 */
public interface WerknemerDAO {
    /**
     * Voeg een werknemer toe aan de hand van een werknemer object.
     * @param werknemer 
     */
    public void addWerknemer(WerknemerView werknemerCompleet);
    /**
     * Geef een lijst terug met alle werknemers.
     * @return List Werknemer
     */
    public List<WerknemerObjectView> getWerknemers();
    /**
     * Declaratie van de methode voor het ophalen 1 row van de tabel Werknemer.
     * 
     * @return      Het record met werknemerid id.
     */
    public WerknemerObjectView getWerknemer(int id);
    /**
     * Verwijder een werknemer aan de hand van zijn index.
     * @param id 
     */
    public void deleteWerknemer(int id);
    /**
     * Bewerk een werknemer aan de hand van een werknmer object.
     * @param werknemer 
     */
    public void updateWerknemer(WerknemerView werknemerCompleet);
}
