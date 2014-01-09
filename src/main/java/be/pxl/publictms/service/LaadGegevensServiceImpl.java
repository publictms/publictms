/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.LaadGegevensDAO;
import be.pxl.publictms.pojo.Laadgegevens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het LaadgegevensService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Laadgegevens"
 * worden hier uitgewerkt.
 * 
 * @author Laurens
 */
@Service
public class LaadGegevensServiceImpl implements LaadGegevensService{
    
    @Autowired
    private LaadGegevensDAO laadGegevensDAO;

    @Transactional
    public void addLaadgegevens(Laadgegevens laadgegevens) {
        laadGegevensDAO.addLaadgegevens(laadgegevens);
    }

    @Transactional
    public Laadgegevens getLaadgegevens(int id) {
        return laadGegevensDAO.getLaadgegevens(id);
    }

    @Transactional
    public void deleteLaadgegeven(int id) {
        laadGegevensDAO.deleteLaadgegeven(id);
    }

    @Transactional
    public void updateLaadgegeven(Laadgegevens laadgegevens) {
        laadGegevensDAO.updateLaadgegeven(laadgegevens);
    }
    
    
    
}
