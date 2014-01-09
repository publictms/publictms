/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.KlantDAO;
import be.pxl.publictms.pojo.Klant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het KlantService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Klant"
 * worden hier uitgewerkt.
 * 
 * @author Laurens
 */
@Service
public class KlantServiceImpl implements KlantService{
    
    @Autowired
    private KlantDAO klantDAO;

    @Transactional
    public void addKlant(Klant klant) {
        klantDAO.addKlant(klant);
    }

    @Transactional
    public List<Klant> getKlanten() {
        return klantDAO.getKlanten();
    }

    @Transactional
    public Klant getKlant(int id) {
        return klantDAO.getKlant(id);
    }

    @Transactional
    public void deleteKlant(int id) {
        klantDAO.deleteKlant(id);
    }

    @Transactional
    public void updateKlant(Klant klant) {
        klantDAO.updateKlant(klant);
    }
    
    
    
}
