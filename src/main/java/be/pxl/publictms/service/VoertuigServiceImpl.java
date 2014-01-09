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
 * worden hier uitgewerkt.
 * 
 * @author Stijn
 */
@Service
public class VoertuigServiceImpl implements VoertuigService{

    @Autowired
    private VoertuigDAO voertuigDAO;
    
    @Transactional
    public void addVoertuig(Voertuig voertuig) {
        voertuigDAO.addVoertuig(voertuig);
    }

    @Transactional
    public List<Voertuig> getVoertuigen() {
        return voertuigDAO.getVoertuigen();
    }

    @Transactional
    public Voertuig getVoertuig(int id) {
        return voertuigDAO.getVoertuig(id);
    }

    @Transactional
    public void deleteVoertuig(int id) {
        voertuigDAO.deleteVoertuig(id);
    }

    @Transactional
    public void updateVoertuig(Voertuig voertuig) {
        voertuigDAO.updateVoertuig(voertuig);
    }
    
}
