/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Laadgegevens;

/**
 * interface die methoden voorziet om laadgegevens toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Laurens Putseys
 */
public interface LaadGegevensDAO {
    /**
     * Om laadgegevens toe te voegen.
     * @param laadgegevens 
     */
    public void addLaadgegevens(Laadgegevens laadgegevens);
    /**
     * Geeft de laadgegevens terug aan de hand van zijn index.
     * @param id
     * @return 
     */
    public Laadgegevens getLaadgegevens(int id);
    /**
     * Verwijder laadgegevens aan de hand van zijn index.
     * @param id 
     */
    public void deleteLaadgegeven(int id);
    /**
     * Bewerk bestaand laadgegevens.
     * @param laadgegevens 
     */
    public void updateLaadgegeven(Laadgegevens laadgegevens);
}
