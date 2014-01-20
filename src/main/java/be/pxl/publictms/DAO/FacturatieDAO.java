/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.view.FacturatieObjectView;
import be.pxl.publictms.view.FacturatieView;
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
    public void addFacturatie(FacturatieView factuur);
    /**
     * Aan de hand van een id geeft deze een facturatie object terug
     * @param id
     * @return facturatie
     */
    public FacturatieObjectView getFacturatie(int id);
    /**
     * Geef een list van facturatie objecten terug aan de hand van een id. Deze index is de klant id.
     * @param klantId
     * @return List facturatie 
     */
    public List getFacturen();
    /**
     * Delete een facturatie object aan de hand van zijn index.
     * @param id 
     */
    public void deleteFactuur(int id);
    /**
     * Bewerkt een factuur aan de hand van een Facturatie object.
     * @param factuur 
     */
    public void updateFactuur(FacturatieView factuur);
}
