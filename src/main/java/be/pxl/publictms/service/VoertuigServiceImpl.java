/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.VoertuigDAO;
import be.pxl.publictms.pojo.Voertuig;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het VoertuigService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Voertuig"
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
public class VoertuigServiceImpl implements VoertuigService{

    @Autowired
    private VoertuigDAO voertuigDAO;
    
    /**
     * Declaratie van de methode voor het toevoegen van data aan de tabel Voertuig.
     * 
     * @param voertuig     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addVoertuig(Voertuig voertuig) {
        voertuigDAO.addVoertuig(voertuig);
    }

    /**
     * Declaratie van de methode voor het ophalen van alle records uit de tabel
     * Voertuig
     * 
     * @return      Lijst van data van de tabel Voertuig. Elk record wordt
     *              voorgesteld met POJO Voertuig.
     */
    @Transactional
    public List<Voertuig> getVoertuigen() {
        return voertuigDAO.getVoertuigen();
    }

    /**
     * Declaratie van de methode voor het ophalen van een record uit de tabel
     * Voertuig met een bepaald id.
     * 
     * @param id    Het voertuigid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    @Transactional
    public Voertuig getVoertuig(int id) {
        return voertuigDAO.getVoertuig(id);
    }

    /**
     * Declaratie van de methode voor het verwijderen van een record uit de
     * tabel Voertuig.
     * 
     * @param id    Het voertuigid van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deleteVoertuig(int id) {
        voertuigDAO.deleteVoertuig(id);
    }

    /**
     * Declaratie van de methode voor het updaten van een record uit de 
     * tabel Voertuig.
     * 
     * @param voertuig     POJO van de geüpdate data.
     */
    @Transactional
    public void updateVoertuig(Voertuig voertuig) {
        voertuigDAO.updateVoertuig(voertuig);
    }
    
}
