/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.BerichtDAO;
import be.pxl.publictms.pojo.Bericht;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het BerichtService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Bericht"
 * worden hier uitgewerkt. De methodes maken gebruik van BerichtDAO waar
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
public class BerichtServiceImpl implements BerichtService{
    
    @Autowired
    private BerichtDAO berichtDAO;

    /**
     * Methode voor het toevoegen van data aan de tabel Bericht.
     * 
     * @param bericht     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void send(Bericht bericht) {
        berichtDAO.send(bericht);
    }

    /**
     * Methode voor het ophalen van een aantal record uit de tabel Bericht voor 
     * een bepaald ontvangerid.
     * 
     * @param id    Het ontvangerid van de records die opgehaald moet worden.
     * @return      Lijst van data van de tabel Bericht. Elk record wordt
     *              voorgesteld met POJO Bericht.
     */
    @Transactional
    public List<Bericht> getBerichten(int id) {
        return berichtDAO.getBerichten(id);
    }

    /**
     * Methode voor het verwijderen van een record uit de tabel Bericht.
     * 
     * @param id    Het berichtid van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deleteBericht(int id) {
        berichtDAO.deleteBericht(id);
    }
}
