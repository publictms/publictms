/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.ActieDAO;
import be.pxl.publictms.pojo.Actie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het ActieService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Actie"
 * worden hier uitgewerkt.
 * 
 * @author Stijn
 */
@Service
public class ActieServiceImpl implements ActieService{

    @Autowired
    private ActieDAO actieDAO;
    
    @Transactional
    public void addActie(Actie actie) {
        actieDAO.addActie(actie);
    }

    @Transactional
    public List<Actie> getActiesVanOpdracht(int id) {
        return actieDAO.getActiesVanOpdracht(id);
    }

    @Transactional
    public void deleteActie(int id) {
        actieDAO.deleteActie(id);
    }

    @Transactional
    public void updateActie(Actie actie) {
        actieDAO.updateActie(actie);
    }
    
}
