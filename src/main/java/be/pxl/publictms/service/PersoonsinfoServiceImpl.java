/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.PersoonsinfoDAO;
import be.pxl.publictms.pojo.Persoonsinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het PersoonsinfoService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Persoonsinfo"
 * worden hier uitgewerkt. De methodes maken gebruik van WerknemerDAO waar
 * de query's, acties worden gedefiniëerd.
 * @Service een autowire voor de service class, de class waar de businesslogica 
 * komt. Men moet dus geen bean definities schrijven in de context xml.
 * @Autowired annotatie wordt gebruikt om een automatische link te leggen met
 * een bean.
 * @Transactional staat toe een overdracht te doen met de databank.
 * 
 * @author Stijn
 */
@Service
public class PersoonsinfoServiceImpl implements PersoonsinfoService{

    @Autowired
    private PersoonsinfoDAO persoonsinfoDAO;

    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Persoonsinfo.
     * 
     * @param persoonsinfo     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addPersoonsinfo(Persoonsinfo persoonsinfo) {
        persoonsinfoDAO.addPersoonsinfo(persoonsinfo);
    }

    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Persoonsinfo met een bepaald id.
     * 
     * @param id    Het persoonsinfoid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    @Transactional
    public Persoonsinfo getPersoonsinfo(int id) {
        return persoonsinfoDAO.getPersoonsinfo(id);
    }

    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Persoonsinfo.
     * 
     * @param id    Het persoonsinfoid van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deletePersoonsinfo(int id) {
        persoonsinfoDAO.deletePersoonsinfo(id);
    }

    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Persoonsinfo.
     * 
     * @param persoonsinfo     POJO van de geüpdate data.
     */
    @Transactional
    public void updatePersoonsinfo(Persoonsinfo persoonsinfo) {
        persoonsinfoDAO.updatePersoonsinfo(persoonsinfo);
    }
    
}
