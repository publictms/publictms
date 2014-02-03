/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Actie;
import be.pxl.publictms.view.ActieObjectView;
import be.pxl.publictms.view.ActieView;
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
    public void addActie(ActieView actieView);
    
    
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
    public void updateActie(ActieView actieView);
    /**
     * Geeft één actie terug.
     * @param id
     * @return Actie
     */
    public ActieObjectView getActie(int id);
    /**
     * Geeft alle acties per opdracht zonder indexen maar als bruikbaar gegeven.
     * @param id
     * @return List
     */
    public List<ActieObjectView> getActiesWerknemer(int id);
    /**
     * Geeft alle acties per opdracht zonder indexen maar als bruikbaar gegeven.
     * @param id
     * @return List
     */
    public List<ActieObjectView> getActiesOpdracht(int id);
    /**
     * Zet de actie status op actief of niet actief
     * @param klaar
     * @param id 
     */
    public void setKlaar(boolean klaar, int id);
    public List<ActieObjectView> getActies();
}
