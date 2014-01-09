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
 * de query's, acties worden gedefiniŽerd.
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

    @Transactional
    public Postcode getGemeente(String id) {
        return postcodeDAO.getGemeente(id);
    }
    
    @Transactional
    public List<Postcode> getGemeente(){
        return postcodeDAO.getGemeente();
    }

    @Transactional
    public void addGemeente(Postcode postcode) {
        postcodeDAO.addGemeente(postcode);
    }

    @Transactional
    public void updateGemeente(Postcode postcode) {
        postcodeDAO.updateGemeente(postcode);
    }

    @Transactional
    public void deleteGemeente(String id) {
        postcodeDAO.deleteGemeente(id);
    }
    
    
    
}
