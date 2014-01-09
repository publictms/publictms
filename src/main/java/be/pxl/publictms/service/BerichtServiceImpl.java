/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.BerichtDAO;
import be.pxl.publictms.pojo.Bericht;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het BerichtService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Bericht"
 * worden hier uitgewerkt.
 * 
 * @author Laurens
 */
@Service
public class BerichtServiceImpl implements BerichtService{
    
    @Autowired
    private BerichtDAO berichtDAO;

    @Transactional
    public void send(Bericht bericht) {
        berichtDAO.send(bericht);
    }

    @Transactional
    public List<Bericht> getBerichten(int id) {
        return berichtDAO.getBerichten(id);
    }

    @Transactional
    public void deleteBericht(int id) {
        berichtDAO.deleteBericht(id);
    }
    
    
}
