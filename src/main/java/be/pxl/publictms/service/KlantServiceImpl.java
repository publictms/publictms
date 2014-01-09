/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.KlantDAO;
import be.pxl.publictms.pojo.Klant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het KlantService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Klant"
 * worden hier uitgewerkt. De methodes maken gebruik van KlantDAO waar
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
public class KlantServiceImpl implements KlantService{
    
    @Autowired
    private KlantDAO klantDAO;

    /**
     * Methode voor het toevoegen van data aan de tabel Klant.
     * 
     * @param klant     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addKlant(Klant klant) {
        klantDAO.addKlant(klant);
    }

    /**
     * Methode voor het ophalen van alle records uit de tabel Klant
     * 
     * @return      Lijst van data van de tabel Klant. Elk record wordt
     *              voorgesteld met POJO Klant.
     */
    @Transactional
    public List<Klant> getKlanten() {
        return klantDAO.getKlanten();
    }

    /**
     * Methode voor het ophalen van een record uit de tabel Klant met een 
     * bepaald id.
     * 
     * @param id    Het klantid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    @Transactional
    public Klant getKlant(int id) {
        return klantDAO.getKlant(id);
    }

    /**
     * Methode voor het verwijderen van een record uit de tabel Klant.
     * 
     * @param id    Het klantid van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deleteKlant(int id) {
        klantDAO.deleteKlant(id);
    }

    /**
     * Methode voor het updaten van een record uit de tabel Klant.
     * 
     * @param klant     POJO van de geüpdate data.
     */
    @Transactional
    public void updateKlant(Klant klant) {
        klantDAO.updateKlant(klant);
    } 
}
