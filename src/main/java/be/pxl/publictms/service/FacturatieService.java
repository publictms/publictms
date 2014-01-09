/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Facturatie;
import java.util.List;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Facturatie".
 * 
 * @author Laurens
 */
public interface FacturatieService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Facturatie.
     * 
     * @param factuur     POJO representatie van de data die toegevoegd wordt.
     */
    public void addFacturatie(Facturatie factuur);
    
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Facturatie met een bepaald id.
     * 
     * @param id    Het factuurid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    public Facturatie getFacturatie(int id);
    
    /**
     * Declaratie van de methode voor het ophalen van een aantal record 
     * uit de tabel Facturatie voor een bepaald klantid.
     * 
     * @param id    Het klantid van de records die opgehaald moet worden.
     * @return      Lijst van data van de tabel Facturatie. Elk record wordt
     *              voorgesteld met POJO Facturatie.
     */
    public List<Facturatie> getFacturen(int klantId);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Facturatie.
     * 
     * @param id    Het factuurid van het record dat verwijderd moet worden.
     */
    public void deleteFactuur(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Facturatie.
     * 
     * @param factuur     POJO van de geüpdate data.
     */
    public void updateFactuur(Facturatie factuur);
}
