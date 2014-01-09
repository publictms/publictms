/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.GebruikerDAO;
import be.pxl.publictms.pojo.Gebruiker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het GebruikerService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Gebruiker"
 * worden hier uitgewerkt.
 * 
 * @author Laurens
 */
@Service
public class GebruikerServiceImpl implements GebruikerService{

    @Autowired
    private GebruikerDAO gebruikerDao;
    
    @Transactional
    public void addGebruiker(Gebruiker gebruiker) {
        gebruikerDao.addGebruiker(gebruiker);
    }

    @Transactional
    public List<Gebruiker> getGebruikers() {
        return gebruikerDao.getGebruikers();
    }

    @Transactional
    public void deleteGebruiker(int id) {
        gebruikerDao.deleteGebruiker(id);
    }

    @Transactional
    public void updateGebruiker(Gebruiker gebruiker) {
        gebruikerDao.updateGebruiker(gebruiker);
    }
}
