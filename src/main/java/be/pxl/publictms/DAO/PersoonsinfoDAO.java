/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Persoonsinfo;
import java.util.List;

/**
 * interface die methoden voorziet om persoons info toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Stijn Ceunen
 */
public interface PersoonsinfoDAO {
    /**
     * Voeg persoonelijke informatie toe aan de hand van een Persoonsinfo object.
     * @param persoonsinfo 
     */
    public void addPersoonsinfo(Persoonsinfo persoonsinfo);
    /**
     * Geeft een lijst terug met persoonsinfo van iedereen.
     * @return List<persooninfo>
     */
    public List getPersoonsinfo();
    /**
     * Geeft de persoonelijke informatie terug aan de hand van een index.
     * @param id
     * @return persooninfo
     */
    public Persoonsinfo getPersoonsinfo(int id);
    /**
     * Delete de persoonelijke informatie aan de hand een index.
     * @param id 
     */
    public void deletePersoonsinfo(int id);
    /**
     * Bewerk de persoonelijke informatie van iemand aan de hand van een persoonsinfo object.
     * @param persoonsinfo 
     */
    public void updatePersoonsinfo(Persoonsinfo persoonsinfo);
}
