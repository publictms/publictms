/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.WerknemerDAO;
import be.pxl.publictms.pojo.Werknemer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het WerknemerService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Werknemer"
 * worden hier uitgewerkt.
 * 
 * 
 * @author Laurens
 */
@Service
public class WerknemerServiceImpl implements WerknemerService{

    @Autowired
    private WerknemerDAO werknemerDAO;
    
    @Transactional
    public void addWerknemer(Werknemer werknemer) {
        werknemerDAO.addWerknemer(werknemer);
    }

    @Transactional
    public List<Werknemer> getWerknemers() {
        return werknemerDAO.getWerknemers();
    }

    @Transactional
    public void deleteWerknemer(int id) {
        werknemerDAO.deleteWerknemer(id);
    }

    @Transactional
    public void updateWerknemer(Werknemer werknemer) {
        werknemerDAO.updateWerknemer(werknemer);
    }
    
}
