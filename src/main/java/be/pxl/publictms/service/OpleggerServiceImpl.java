/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.OpleggerDAO;
import be.pxl.publictms.pojo.Oplegger;
import be.pxl.publictms.view.OpleggerView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het OpleggerService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Oplegger"
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
public class OpleggerServiceImpl implements OpleggerService{
    
    @Autowired
    private OpleggerDAO opleggerDAO;

    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Oplegger.
     * 
     * @param oplegger     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addOplegger(OpleggerView opleggerView) {
        opleggerDAO.addOplegger(opleggerView);
    }

    /**
     * Declaratie van de methode voor het ophalen van alle records uit de tabel
     * Oplegger.
     * 
     * @return      Lijst van data van de tabel Oplegger. Elk record wordt
     *              voorgesteld met POJO Oplegger.
     */
    @Transactional
    public List getOpleggers() {
        return opleggerDAO.getOpleggers();
    }

    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Oplegger met een bepaald id.
     * 
     * @param id    Het opleggerid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    @Transactional
    public OpleggerView getOplegger(int id) {
        return opleggerDAO.getOplegger(id);
    }

    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Oplegger.
     * 
     * @param id    Het opleggerid van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deleteOpleggers(int id) {
        opleggerDAO.deleteOpleggers(id);
    }

    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Oplegger.
     * 
     * @param oplegger     POJO van de geüpdate data.
     */
    @Transactional
    public void updateOplegger(OpleggerView opleggerView) {
        opleggerDAO.updateOplegger(opleggerView);
    }
    
    
    
}
