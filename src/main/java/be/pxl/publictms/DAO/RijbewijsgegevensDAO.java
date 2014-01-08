/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Rijbewijsgegevens;

/**
 * interface die methoden voorziet om adressen toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Stijn Ceunen
 */
public interface RijbewijsgegevensDAO {
    /**
     * Voeg rijbewijs gegevens toe aan de hand van een Rijbewijsgegevens object.
     * @param rijbewijsgegevens 
     */
    public void addRijbewijsgegevens(Rijbewijsgegevens rijbewijsgegevens);
    /**
     * Geeft de rijbewijs gegevens terug aan de hand van zijn index.
     * @param id
     * @return Rijbewijsgegevens
     */
    public Rijbewijsgegevens getRijbewijsgegevens(int id);
    /**
     * Verwijder rijbewijs gegevens aan de hand van zijn index.
     * @param id 
     */
    public void deleteRijbewijsgegevens(int id);
    /**
     * Bewerk de rijbewijs gegevens aan de hand van een Rijbewijsgegevens object.
     * @param rijbewijsgegevens 
     */
    public void updateRijbewijsgegevens(Rijbewijsgegevens rijbewijsgegevens);
}
