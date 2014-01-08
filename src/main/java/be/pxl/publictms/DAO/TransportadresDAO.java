/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Transportadres;

/**
 * interface die methoden voorziet om Transportadressen toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Stijn Ceunen
 */
public interface TransportadresDAO {
    /**
     * Voeg een nieuw transport adres toe.
     * @param transportadres 
     */
    public void addTransportadres(Transportadres transportadres);
    /**
     * Geef een transport adres terug aan de hand van zijn index.
     * @param id
     * @return Transportadres
     */
    public Transportadres getTransportadres(int id);
    /**
     * Verwijder een transport adres aan de hand zijn index.
     * @param id 
     */
    public void deleteTransportadres(int id);
    /**
     * Bewerk een transport adres aan de hand van een Transportadres object.
     * @param transportadres 
     */
    public void updateTransportadres(Transportadres transportadres);
}
