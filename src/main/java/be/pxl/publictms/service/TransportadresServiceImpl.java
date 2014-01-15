/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.TransportadresDAO;
import be.pxl.publictms.pojo.Transportadres;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het TransportadresService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Transportadres"
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
public class TransportadresServiceImpl implements TransportadresService{

    @Autowired
    private TransportadresDAO transportadresDAO;
     
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Transportadres.
     * 
     * @param transportadres     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addTransportadres(Transportadres transportadres) {
        transportadresDAO.addTransportadres(transportadres);
    }
    /**
     * Geeft een lijst met transportadressen
     * @param id
     * @return List<Transportadres>
     */
    @Transactional
    public List<Transportadres> getTransportadres(){
        return transportadresDAO.getTransportadres();
    }
    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Transportadres met een bepaald id.
     * 
     * @param id    Het transportadresid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    @Transactional
    public Transportadres getTransportadres(int id) {
        return transportadresDAO.getTransportadres(id);
    }

    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Transportadres.
     * 
     * @param id    Het transportadresid van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deleteTransportadres(int id) {
        transportadresDAO.deleteTransportadres(id);
    }

    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Transportadres.
     * 
     * @param transportadres     POJO van de geüpdate data.
     */
    @Transactional
    public void updateTransportadres(Transportadres transportadres) {
        transportadresDAO.updateTransportadres(transportadres);
    }
    
}
