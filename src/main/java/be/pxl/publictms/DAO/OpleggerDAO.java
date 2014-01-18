/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Oplegger;
import be.pxl.publictms.view.OpleggerView;
import java.util.List;

/**
 * interface die methoden voorziet om oplegger toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Laurens Putseys
 */
public interface OpleggerDAO {
    /**
     * Voegt een oplegger toe.
     * @param oplegger 
     */
    public void addOplegger(Oplegger oplegger);
    /**
     * Geeft een lijst terug met alle opleggers 
     * @return List Oplegger
     */
    public List getOpleggers();
    /**
     * Geeft een specifieke oplegger terug aan de hand van zijn index.
     * @param id
     * @return Oplegger
     */
    public OpleggerView getOplegger(int id);
    /**
     * Delete een oplegger aan de hand van zijn index.
     * @param id 
     */
    public void deleteOpleggers(int id);
    /**
     * Bewerkt een oplegger aan der hand zijn oplegger object.
     * @param oplegger 
     */
    public void updateOplegger(OpleggerView opleggerView);
}
