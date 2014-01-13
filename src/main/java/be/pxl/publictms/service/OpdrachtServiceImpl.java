/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.OpdrachtDAO;
import be.pxl.publictms.pojo.Opdracht;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het OpdrachtService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Opdracht"
 * worden hier uitgewerkt. De methodes maken gebruik van OpdrachtDAO waar
 * de query's, acties worden gedefiniëerd.
 * @Service een autowire voor de service class, de class waar de businesslogica 
 * komt. Men moet dus geen bean definities schrijven in de context xml.
 * @Autowired annotatie wordt gebruikt om een automatische link te leggen met
 * een bean.
 * @Transactional staat toe een overdracht te doen met de databank.
 * 
 * @author Stijn Ceunen, Laurens Putseys
 */
@Service
public class OpdrachtServiceImpl implements OpdrachtService{

    @Autowired
    private OpdrachtDAO opdrachtDAO;
        
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Opdracht.
     * 
     * @param opdracht     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addOpdracht(Opdracht opdracht) {
        opdrachtDAO.addOpdracht(opdracht);
    }

    /**
     * Declaratie van de methode voor het ophalen van alle records uit de tabel
     * Opdracht
     * 
     * @return      Lijst van data van de tabel Opdracht. Elk record wordt
     *              voorgesteld met POJO Opdracht.
     */
    @Transactional
    public List getOpdrachten() {
        return opdrachtDAO.getOpdrachten();
    }

    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Opdracht.
     * 
     * @param id    Het opdrachtid van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deleteOpdracht(int id) {
        opdrachtDAO.deleteOpdracht(id);
    }
    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Opdracht.
     * 
     * @param opdracht     POJO van de geüpdate data.
     */
    @Transactional
    public void updateOpdracht(Opdracht opdracht) {
        opdrachtDAO.updateOpdracht(opdracht);
    }
    /**
     * Geeft een list met opdracht terug
     * @return List Opdracht
     */
    @Transactional
    public List getOpdrachtenWerknemer(int id){
        return opdrachtDAO.getOpdrachtenWerknemer(id);
    }
    /**
     * Is de levering afgeleverd op klaar zetten. True or false. Aan de hand van 
     * een index die verwijst naar de opdracht.
     * @param klaar
     * @param id 
     */
    @Transactional
    public void setKlaar(boolean klaar, int id){
        opdrachtDAO.setKlaar(klaar, id);
    }
    
}
