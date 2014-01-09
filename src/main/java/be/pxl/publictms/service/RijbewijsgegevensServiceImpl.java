/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.RijbewijsgegevensDAO;
import be.pxl.publictms.pojo.Rijbewijsgegevens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het RijbewijsgegevensService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Rijbewijsgegevens"
 * worden hier uitgewerkt.
 * 
 * @author Stijn
 */
@Service
public class RijbewijsgegevensServiceImpl implements RijbewijsgegevensService{

    @Autowired
    private RijbewijsgegevensDAO rijbewijsgegevensDAO;
    
    @Transactional
    public void addRijbewijsgegevens(Rijbewijsgegevens rijbewijsgegevens) {
        rijbewijsgegevensDAO.addRijbewijsgegevens(rijbewijsgegevens);
    }

    @Transactional
    public Rijbewijsgegevens getRijbewijsgegevens(int id) {
        return rijbewijsgegevensDAO.getRijbewijsgegevens(id);
    }

    @Transactional
    public void deleteRijbewijsgegevens(int id) {
        rijbewijsgegevensDAO.deleteRijbewijsgegevens(id);
    }

    @Transactional
    public void updateRijbewijsgegevens(Rijbewijsgegevens rijbewijsgegevens) {
        rijbewijsgegevensDAO.updateRijbewijsgegevens(rijbewijsgegevens);
    }
    
}
