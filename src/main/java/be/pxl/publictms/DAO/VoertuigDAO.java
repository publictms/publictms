/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Voertuig;
import java.util.List;

/**
 * interface die methoden voorziet om voertuigen toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Stijn Ceunen
 */
public interface VoertuigDAO {
    /**
     * Voeg een nieuw voertuig toe.
     * @param voertuig 
     */
    public void addVoertuig(Voertuig voertuig);
    /**
     * Geeft een lijst met voertuigen terug.
     * @return List Voertuig
     */
    public List<Voertuig> getVoertuigen();
    /**
     * Geeft een voertuig terug aan de hand van zijn index.
     * @param id
     * @return Voertuig
     */
    public Voertuig getVoertuig(int id);
    /**
     * Verwijder een voertuig aan de hand van zijn index.
     * @param id 
     */
    public void deleteVoertuig(int id);
    /**
     * Bewerk een voertuig aan de hand van een Voertuig object.
     * @param voertuig 
     */
    public void updateVoertuig(Voertuig voertuig);
}
