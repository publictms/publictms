/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.AdresDAO;
import be.pxl.publictms.pojo.Adres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het AdresService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Actie"
 * worden hier uitgewerkt.
 * 
 * @author Laurens
 */
@Service
public class AdresServiceImpl implements AdresService{
    
    @Autowired
    private AdresDAO adresDAO;

    @Transactional
    public void addAdres(Adres adres) {
        adresDAO.addAdres(adres);
    }

    @Transactional
    public Adres getAdres(int id) {
        return adresDAO.getAdres(id);
    }

    @Transactional
    public void deleteAdres(int id) {
        adresDAO.deleteAdres(id);
    }

    @Transactional
    public void updateAdres(Adres adres) {
        adresDAO.updateAdres(adres);
    } 
}
