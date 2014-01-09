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
 * worden hier uitgewerkt.
 * 
 * @author Stijn
 */
@Service
public class PersoonsinfoServiceImpl implements PersoonsinfoService{

    @Autowired
    private PersoonsinfoDAO persoonsinfoDAO;

    @Transactional
    public void addPersoonsinfo(Persoonsinfo persoonsinfo) {
        persoonsinfoDAO.addPersoonsinfo(persoonsinfo);
    }

    @Transactional
    public Persoonsinfo getPersoonsinfo(int id) {
        return persoonsinfoDAO.getPersoonsinfo(id);
    }

    @Transactional
    public void deletePersoonsinfo(int id) {
        persoonsinfoDAO.deletePersoonsinfo(id);
    }

    @Transactional
    public void updatePersoonsinfo(Persoonsinfo persoonsinfo) {
        persoonsinfoDAO.updatePersoonsinfo(persoonsinfo);
    }
    
}
