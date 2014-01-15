/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.PostcodeDAO;
import be.pxl.publictms.pojo.Postcode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het PostcodeService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Postcode"
 * worden hier uitgewerkt. De methodes maken gebruik van WerknemerDAO waar
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
public class PostcodeServiceImpl implements PostcodeService{
    
    @Autowired
    private PostcodeDAO postcodeDAO;

    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Postcode met een bepaald id.
     * 
     * @param id    De postcode van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    @Transactional
    public Postcode getGemeente(String id) {
        return postcodeDAO.getGemeente(id);
    }
    
    /**
     * Declaratie van de methode voor het ophalen van alle records uit de tabel
     * Postcode
     * 
     * @return      Lijst van data van de tabel Postcode. Elk record wordt
     *              voorgesteld met POJO Postcode.
     */
    @Transactional
    public List<Postcode> getGemeente(){
        return postcodeDAO.getGemeente();
    }

    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Postcode.
     * 
     * @param postcode     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addGemeente(Postcode postcode) {
        postcodeDAO.addGemeente(postcode);
    }

    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Postcode.
     * 
     * @param postcode     POJO van de geüpdate data.
     */
    @Transactional
    public void updateGemeente(Postcode postcode) {
        postcodeDAO.updateGemeente(postcode);
    }

    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Postcode.
     * 
     * @param id    Het postcode van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deleteGemeente(String id) {
        postcodeDAO.deleteGemeente(id);
    }
    
    
    
}
