/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.AdresDAO;
import be.pxl.publictms.pojo.Adres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het AdresService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Adres"
 * worden hier uitgewerkt. De methodes maken gebruik van AdresDAO waar
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
public class AdresServiceImpl implements AdresService{
    
    @Autowired
    private AdresDAO adresDAO;

    /**
     * Methode voor het toevoegen van data aan de tabel Adres.
     * 
     * @param adres     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addAdres(Adres adres) {
        adresDAO.addAdres(adres);
    }

    /**
     * Methode voor het ophalen van een record uit de tabel Adres met een 
     * bepaald id.
     * 
     * @param id    Het adresid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    @Transactional
    public Adres getAdres(int id) {
        return adresDAO.getAdres(id);
    }

    /**
     * Methode voor het verwijderen van een record uit de tabel Adres.
     * 
     * @param id    Het adresid van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deleteAdres(int id) {
        adresDAO.deleteAdres(id);
    }

    /**
     * Methode voor het updaten van een record uit de tabel Adres.
     * 
     * @param adres     POJO van de geüpdate data.
     */
    @Transactional
    public void updateAdres(Adres adres) {
        adresDAO.updateAdres(adres);
    } 
}
