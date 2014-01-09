/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.pojo.Gebruiker;

import java.util.List;

/**
 * Interface dat de methodes voor AdresServiceImpl declareert.
 * Deze zijn voor het toevoegen, verwijderen, updates en ophalen
 * van data uit de tabel "Gebruiker".
 * 
 * @author Laurens
 */
public interface GebruikerService {
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Gebruiker.
     * 
     * @param gebruiker     POJO representatie van de data die toegevoegd wordt.
     */
    public void addGebruiker(Gebruiker gebruiker);
    
    /**
     * Declaratie van de methode voor het ophalen van alle records uit de tabel
     * Gebruiker
     * 
     * @return      Lijst van data van de tabel Gebruiker. Elk record wordt
     *              voorgesteld met POJO Gebruiker.
     */
    public List<Gebruiker> getGebruikers();
    
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Gebruiker.
     * 
     * @param id    Het gebruikerid van het record dat verwijderd moet worden.
     */
    public void deleteGebruiker(int id);
    
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Gebruiker.
     * 
     * @param gebruiker     POJO van de geüpdate data.
     */
    public void updateGebruiker(Gebruiker gebruiker);
    /**
     * Kijk als de user in de databank voorkomt en als het paswoord matched of 
     * niet. Matched deze dan zal deze true terug geven anders false.
     * @param gebruikersnaam
     * @param paswoord
     * @return boolean
     */
    public boolean checkUser(String gebruikersnaam, String paswoord);
}
