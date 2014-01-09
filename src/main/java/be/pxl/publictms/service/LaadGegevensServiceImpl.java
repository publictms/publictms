/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.LaadGegevensDAO;
import be.pxl.publictms.pojo.Laadgegevens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het LaadgegevensService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Laadgegevens"
 * worden hier uitgewerkt. De methodes maken gebruik van LaadgegevensDAO waar
 * de query's, acties worden gedefiniëerd.
 * @Service een autowire voor de service class, de class waar de businesslogica 
 * komt. Men moet dus geen bean definities schrijven in de context xml.
 * @Autowired annotatie wordt gebruikt om een automatische link te leggen met
 * een bean.
 * @Transactional staat toe een overdracht te doen met de databank.
 * 
 * @author Laurens
 */
@Service
public class LaadGegevensServiceImpl implements LaadGegevensService{
    
    @Autowired
    private LaadGegevensDAO laadGegevensDAO;

    /**
     * Methode voor het toevoegen van data aan de tabel Laadgegevens.
     * 
     * @param laadgegevens     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addLaadgegevens(Laadgegevens laadgegevens) {
        laadGegevensDAO.addLaadgegevens(laadgegevens);
    }

    /**
     * Methode voor het ophalen van een record uit de tabel Laadgegevens met 
     * een bepaald id.
     * 
     * @param id    Het laadgegevensid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    @Transactional
    public Laadgegevens getLaadgegevens(int id) {
        return laadGegevensDAO.getLaadgegevens(id);
    }

    /**
     * Methode voor het verwijderen van een record uit de tabel Laadgegevens.
     * 
     * @param id    Het laadgegevensid van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deleteLaadgegeven(int id) {
        laadGegevensDAO.deleteLaadgegeven(id);
    }

    /**
     * Methode voor het updaten van een record uit de tabel Laadgegevens.
     * 
     * @param laadgegevens     POJO van de geüpdate data.
     */
    @Transactional
    public void updateLaadgegeven(Laadgegevens laadgegevens) {
        laadGegevensDAO.updateLaadgegeven(laadgegevens);
    }  
}
