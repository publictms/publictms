/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.WerknemerDAO;
import be.pxl.publictms.pojo.Werknemer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het WerknemerService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Werknemer"
 * worden hier uitgewerkt.De methodes maken gebruik van WerknemerDAO waar
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
public class WerknemerServiceImpl implements WerknemerService{

    @Autowired
    private WerknemerDAO werknemerDAO;
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Werknemer.
     * 
     * @param werknemer     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addWerknemer(Werknemer werknemer) {
        werknemerDAO.addWerknemer(werknemer);
    }

    /**
     * Declaratie van de methode voor het ophalen van alle records uit de tabel
     * Werknemer.
     * 
     * @return      Lijst van data van de tabel Werknemer. Elk record wordt
     *              voorgesteld met POJO Werknemer.
     */
    @Transactional
    public List<Werknemer> getWerknemers() {
        return werknemerDAO.getWerknemers();
    }

    @Transactional
    public Werknemer getWerknemer(int id) {
        return werknemerDAO.getWerknemer(id);
    }
        
    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Werknemer.
     * 
     * @param id    Het werkenemerid van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deleteWerknemer(int id) {
        werknemerDAO.deleteWerknemer(id);
    }

    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Werknemer.
     * 
     * @param werknemer     POJO van de geüpdate data.
     */
    @Transactional
    public void updateWerknemer(Werknemer werknemer) {
        werknemerDAO.updateWerknemer(werknemer);
    }
    
}
