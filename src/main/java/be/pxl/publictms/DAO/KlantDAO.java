/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Klant;
import java.util.List;

/**
 * interface die methoden voorziet om Klanten toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Laurens Putseys
 */
public interface KlantDAO {
    /**
     * Voegt een klant toe.
     * @param klant 
     */
    public void addKlant(Klant klant);
    /**
     * Geeft een lijst van klanten terug
     * @return List Klanten
     */
    public List getKlanten();
    /**
     * Geeft een specifieke klant terug aan de hand van zijn index.
     * @param id
     * @return klant
     */
    public Klant getKlant(int id);
    /**
     * Delete een klant aan de hand van zijn id.
     * @param id 
     */
    public void deleteKlant(int id);
    /**
     * Bewerkt een klant aan de hand een klant object
     * @param klant 
     */
    public void updateKlant(Klant klant);
}
