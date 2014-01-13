/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.ActieDAO;
import be.pxl.publictms.pojo.Actie;
import be.pxl.publictms.view.ActieView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het ActieService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Actie"
 * worden hier uitgewerkt. De methodes maken gebruik van ActieDAO waar
 * de query's, acties worden gedefiniëerd.
 * @Service een autowire voor de service class, de class waar de businesslogica 
 * komt. Men moet dus geen bean definities schrijven in de context xml.
 * @Autowired annotatie wordt gebruikt om een automatische link te leggen met
 * een bean.
 * @Transactional staat toe een overdracht te doen met de databank.
 * 
 * @author Stijn, laurens
 */
@Service
public class ActieServiceImpl implements ActieService{

    @Autowired
    private ActieDAO actieDAO;
    
    /**
     * Methode voor het toevoegen van data aan de tabel Actie.
     * 
     * @param actie POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addActie(Actie actie) {
        actieDAO.addActie(actie);
    }

    /**
     * Methode voor het ophalen van een lijst van data die zich in de tabel 
     * Actie bevindt.
     * 
     * @param id    Id van de opdracht waarvan de acties gezien willen worden.
     * @return      List met data van de tabel Actie. Elke record wordt 
     *              voorgesteld met POJO Actie.
     */
    @Transactional
    public List<Actie> getActiesVanOpdracht(int id) {
        return actieDAO.getActiesVanOpdracht(id);
    }
    
    /**
     * Methode voor het verwijderen van een record uit de tabel Actie.
     * 
     * @param id    id van de actie die verwijderd moet worden
     */
    @Transactional
    public void deleteActie(int id) {
        actieDAO.deleteActie(id);
    }
    
    /**
     * Methode voor het updaten van een record uit de tabel Actie.
     * 
     * @param actie     POJO van de geüpdate data
     */
    @Transactional
    public void updateActie(Actie actie) {
        actieDAO.updateActie(actie);
    }
    /**
     * Geeft alle acties per opdracht zonder indexen maar als bruikbaar gegeven.
     * @param id
     * @return List
     */
    @Transactional
    public List getActiesPerOpdracht(int id){
        return actieDAO.getActiesPerOpdracht(id);
    }
    /**
     * Zet de actie status op actief of niet actief
     * @param klaar
     * @param id 
     */
    @Transactional
    public void setKlaar(boolean klaar, int id){
        actieDAO.setKlaar(klaar, id);
    }
    
}
