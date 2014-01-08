/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Facturatie;
import java.util.List;

/**
 * interface die methoden voorziet om facturen toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Laurens Putseys
 */
public interface FacturatieDAO {
    /**
     * Voegt een factuur toe.
     * @param factuur 
     */
    public void addFacturatie(Facturatie factuur);
    /**
     * Aan de hand van een id geeft deze een facturatie object terug
     * @param id
     * @return facturatie
     */
    public Facturatie getFacturatie(int id);
    /**
     * Geef een list van facturatie objecten terug aan de hand van een id. Deze index is de klant id.
     * @param klantId
     * @return List facturatie 
     */
    public List<Facturatie> getFacturen(int klantId);
    /**
     * Delete een facturatie object aan de hand van zijn index.
     * @param id 
     */
    public void deleteFactuur(int id);
    /**
     * Bewerkt een factuur aan de hand van een Facturatie object.
     * @param factuur 
     */
    public void updateFactuur(Facturatie factuur);
}
