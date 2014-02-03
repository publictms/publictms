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
 * worden hier uitgewerkt. De methodes maken gebruik van GebruikerDAO waar
 * de query's, acties worden gedefiniëerd.
 * @Service een autowire voor de service class, de class waar de businesslogica 
 * komt. Men moet dus geen bean definities schrijven in de context xml.
 * @Autowired annotatie wordt gebruikt om een automatische link te leggen met
 * een bean.
 * @Transactional staat toe een overdracht te doen met de databank.
 * 
 * @author Laurens
 */
@Service
public class GebruikerServiceImpl implements GebruikerService{

    @Autowired
    private GebruikerDAO gebruikerDao;
    
    /**
     * Methode voor het toevoegen van data aan de tabel Gebruiker.
     * 
     * @param gebruiker     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addGebruiker(Gebruiker gebruiker) {
        gebruikerDao.addGebruiker(gebruiker);
    }

    /**
     * Methode voor het ophalen van alle records uit de tabel
     * Gebruiker
     * 
     * @return      Lijst van data van de tabel Gebruiker. Elk record wordt
     *              voorgesteld met POJO Gebruiker.
     */
    @Transactional
    public List<Gebruiker> getGebruikers() {
        return gebruikerDao.getGebruikers();
    }

    /**
     * Methode voor het verwijderen van een record uit de
     * tabel Gebruiker.
     * 
     * @param id    Het gebruikerid van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deleteGebruiker(int id) {
        gebruikerDao.deleteGebruiker(id);
    }

    /**
     * Methode voor het updaten van een record uit de 
     * tabel Gebruiker.
     * 
     * @param gebruiker     POJO van de geüpdate data.
     */
    @Transactional
    public void updateGebruiker(Gebruiker gebruiker) {
        gebruikerDao.updateGebruiker(gebruiker);
    }
    /**
     * Kijk als de user in de databank voorkomt en als het paswoord matched of 
     * niet. Matched deze dan zal deze true terug geven anders false.
     * @param gebruikersnaam
     * @param paswoord
     * @return boolean
     */
    @Transactional
    public Gebruiker checkUser(String gebruikersnaam, String paswoord) throws Exception{
        return gebruikerDao.checkUser(gebruikersnaam, paswoord);
    }
}
