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
