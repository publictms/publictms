/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.OpleggerDAO;
import be.pxl.publictms.pojo.Oplegger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het OpleggerService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Oplegger"
 * worden hier uitgewerkt.
 * 
 * @author Laurens
 */
@Service
public class OpleggerServiceImpl implements OpleggerService{
    
    @Autowired
    private OpleggerDAO opleggerDAO;

    @Transactional
    public void addOplegger(Oplegger oplegger) {
        opleggerDAO.addOplegger(oplegger);
    }

    @Transactional
    public List<Oplegger> getOpleggers() {
        return opleggerDAO.getOpleggers();
    }

    @Transactional
    public Oplegger getOplegger(int id) {
        return opleggerDAO.getOplegger(id);
    }

    @Transactional
    public void deleteOpleggers(int id) {
        opleggerDAO.deleteOpleggers(id);
    }

    @Transactional
    public void updateOplegger(Oplegger oplegger) {
        opleggerDAO.updateOplegger(oplegger);
    }
    
    
    
}
