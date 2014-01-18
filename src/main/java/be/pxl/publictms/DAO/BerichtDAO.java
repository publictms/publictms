/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Bericht;
import java.util.List;

/**
 * interface die methoden voorziet om berichten te sturen, 
 * verwijderen of op te vragen.
 * @author Laurens 
 */
public interface BerichtDAO {
    /**
     * Zal een bericht naar de databank versturen.
     * @param bericht 
     */
    public void send(Bericht bericht);
    /**
     * Geeft alle berichten voor één ontvanger, id is de index van deze persoon.
     * @param id
     * @return List berichten
     */
    public List getBerichten(int id);
    /**
     * 
     * Verwijdert een bericht waarvan de id overeenkomt.
     * @param id 
     */
    public void deleteBericht(int id);
}
