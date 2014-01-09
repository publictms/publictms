/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Actie;
import java.util.List;

/**
 * Interface dat de methodes voor ActieServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Actie".
 * 
 * @author Stijn
 */
public interface ActieService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Actie.
     * 
     * @param actie     POJO representatie van de data die toegevoegd wordt.
     */
    public void addActie(Actie actie);
    
    /**
     * Declaratie van de methode voor het ophalen van een lijst van data die 
     * zich in de tabel Actie bevindt.
     * 
     * @param id    Id van de opdracht waarvan de acties gezien willen worden.
     * @return      List met data van de tabel Actie. Elke record wordt 
     *              voorgesteld met POJO Actie.
     */
    public List<Actie> getActiesVanOpdracht(int id);
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Actie.
     * 
     * @param id    id van de actie die verwijderd moet worden
     */
    public void deleteActie(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Actie
     * 
     * @param actie     POJO van de geüpdate data
     */
    public void updateActie(Actie actie);
}
