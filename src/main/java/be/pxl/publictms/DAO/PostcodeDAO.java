/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Postcode;
import java.util.List;


/**
 * interface die methoden voorziet om postcodes (gemeentes) toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Laurens Putseys
 */
public interface PostcodeDAO {
    /**
     * Geeft een Postcode object terug met bijhorende index, index hier is in dit geval een postcode.
     * @param id
     * @return postcode
     */
    public Postcode getGemeente(String id);
    /**
     * Geeft een lijst met Postcode objecten terug
     * @return List Postcode
     */
    public List<Postcode> getGemeente();
    /**
     * Voeg een nieuwe gemeente met postcode terug aan de hand van Postcode object.
     * @param postcode 
     */
    public void addGemeente(Postcode postcode);
    /**
     * Bewerk een geemente of postcode
     * @param postcode 
     */
    public void updateGemeente(Postcode postcode);
    /**
     * Verwijder een gemeente/postcode aan de hand van zijn postcode.
     * @param id 
     */
    public void deleteGemeente(String id);
}
