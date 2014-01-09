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
 * worden hier uitgewerkt.
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
