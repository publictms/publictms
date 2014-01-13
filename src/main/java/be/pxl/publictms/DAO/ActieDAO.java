/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Actie;
import java.util.List;

/**
 *  Actie interface zorgt ervoor dat men een actie kan toevoegen aan bepaalde 
 *  opdrachten
 * @author Stijn
 */
public interface ActieDAO {
    /**
     * een actie toevoegen
     * @param actie 
     */
    public void addActie(Actie actie);
    /**
     * Aan de hand van de index zal deze alle acties ophalen die bij de 
     * bijhorende opdracht horen. Deze id is de index van een opdracht.
     * @param id 
     * @return List<Actie>
     */
    public List<Actie> getActiesVanOpdracht(int id);
    /**
     * Geeft alle acties per opdracht zonder indexen maar als bruikbaar gegeven.
     * @param id
     * @return List
     */
    public List getActiesPerOpdracht(int id);
    /**
     * Aan de hand van de index kan men een actie verwijderen
     * @param id 
     */
    public void deleteActie(int id);
    /**
     * Update een actie
     * @param actie 
     */
    public void updateActie(Actie actie);
    /**
     * Zet de actie status op actief of niet actief
     * @param klaar
     * @param id 
     */
    public void setKlaar(boolean klaar, int id);
}
