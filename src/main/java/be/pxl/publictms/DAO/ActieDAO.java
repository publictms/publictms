/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Actie;
import be.pxl.publictms.view.ActieObjectView;
import be.pxl.publictms.view.ActieView;
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
    public void addActie(ActieView actieView);
    /**
     * Geeft één actie terug.
     * @param id
     * @return Actie
     */
    public ActieObjectView getActie(int id);
    /**
     * Aan de hand van de index zal deze alle acties ophalen die bij de 
     * bijhorende opdracht horen. Deze id is de index van een opdracht.
     * @param id 
     * @return List<Actie>
     */
    public List<ActieObjectView> getActiesWerknemer(int id);
    /**
     * Aan de hand van de index zal deze alle acties ophalen die bij de 
     * bijhorende opdracht horen. Deze id is de index van een opdracht.
     * @param id 
     * @return List<Actie>
     */
    public List<ActieObjectView> getActiesOpdracht(int id);
    /**
     * Aan de hand van de index kan men een actie verwijderen
     * @param id 
     */
    public void deleteActie(int id);
    /**
     * Update een actie
     * @param actie 
     */
    public void updateActie(ActieView actieView);
    /**
     * Zet de actie status op actief of niet actief
     * @param klaar
     * @param id 
     */
    public void setKlaar(boolean klaar, int id);
    public List<ActieObjectView> getActies();
}
