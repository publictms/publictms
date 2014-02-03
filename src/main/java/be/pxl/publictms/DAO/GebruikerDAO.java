/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.pojo.Gebruiker;

import java.util.List;

/**
 * interface die methoden voorziet om gebruikers toe te voegen, bewerken, 
 * verwijderen of op te vragen.
 * @author Laurens Putseys
 */
public interface GebruikerDAO {
    /**
     * Voeg een gebruiker toe aan de hand van een Gebruiker object.
     * @param gebruiker 
     */
    public void addGebruiker(Gebruiker gebruiker);
    /**
     * Geeft een lijst van gebruikers terug.
     * @return List Gebruiker
     */
    public List<Gebruiker> getGebruikers();
    /**
     * Delete een gebruiker aan de hand van zijn index.
     * @param id 
     */
    public void deleteGebruiker(int id);
    /**
     * Bewerkt een gebruiker aan de hand van een Gebruiker object.
     * @param gebruiker 
     */
    public void updateGebruiker(Gebruiker gebruiker);
    /**
     * Kijk als de user in de databank voorkomt en als het paswoord matched of 
     * niet. Matched deze dan zal deze true terug geven anders false.
     * @param gebruikersnaam
     * @param paswoord
     * @return boolean
     */
    public Gebruiker checkUser(String gebruikersnaam, String paswoord) throws Exception;
}
