/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Land;
import java.util.List;

/**
 *
 * @author 11302785
 */
public interface LandService {
    /**
     * Geeft een Postcode object terug met bijhorende index, index hier is in dit geval een postcode.
     * @param id
     * @return postcode
     */
    public Land getLand(int id);
    /**
     * Geeft een lijst met Postcode objecten terug
     * @return List Postcode
     */
    public List<Land> getLanden();
    /**
     * Voeg een nieuwe gemeente met postcode terug aan de hand van Postcode object.
     * @param postcode 
     */
    public void addLand(Land Land);
    /**
     * Bewerk een geemente of postcode
     * @param postcode 
     */
    public void updateLand(Land land);
    /**
     * Verwijder een gemeente/postcode aan de hand van zijn postcode.
     * @param id 
     */
    public void deleteLand(int id);
}
