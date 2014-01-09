/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.TransportadresDAO;
import be.pxl.publictms.pojo.Transportadres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het TransportadresService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Transportadres"
 * worden hier uitgewerkt.
 * 
 * @author Stijn
 */
@Service
public class TransportadresServiceImpl implements TransportadresService{

    @Autowired
    private TransportadresDAO transportadresDAO;
     
    @Transactional
    public void addTransportadres(Transportadres transportadres) {
        transportadresDAO.addTransportadres(transportadres);
    }

    @Transactional
    public Transportadres getTransportadres(int id) {
        return transportadresDAO.getTransportadres(id);
    }

    @Transactional
    public void deleteTransportadres(int id) {
        transportadresDAO.deleteTransportadres(id);
    }

    @Transactional
    public void updateTransportadres(Transportadres transportadres) {
        transportadresDAO.updateTransportadres(transportadres);
    }
    
}
