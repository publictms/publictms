/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.TaalDAO;
import be.pxl.publictms.pojo.Taal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het TaalService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Taal"
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
public class TaalServiceImpl implements TaalService{

    @Autowired
    private TaalDAO taalDAO;
    
    @Transactional
    public void addTaal(Taal taal) {
        taalDAO.addTaal(taal);
    }

    @Transactional
    public Taal getTaal(int id) {
        return taalDAO.getTaal(id);
    }

    @Transactional
    public void deleteTaal(int id) {
        taalDAO.deleteTaal(id);
    }

    @Transactional
    public void updateTaal(Taal taal) {
        taalDAO.updateTaal(taal);
    }
    
}
