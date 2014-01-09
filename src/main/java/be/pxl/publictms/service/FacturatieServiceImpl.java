/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.FacturatieDAO;
import be.pxl.publictms.pojo.Facturatie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasse die het FacturatieService interface implementeerd. De methodes voor
 * het toevoegen, verwijderen, updates en ophalen van data uit de tabel "Facturatie"
 * worden hier uitgewerkt.
 * 
 * @author Laurens
 */
@Service
public class FacturatieServiceImpl implements FacturatieService{
    
    @Autowired
    private FacturatieDAO facturatieDAO;

    @Transactional
    public void addFacturatie(Facturatie factuur) {
        facturatieDAO.addFacturatie(factuur);
    }

    @Transactional
    public Facturatie getFacturatie(int id) {
        return facturatieDAO.getFacturatie(id);
    }

    @Transactional
    public List<Facturatie> getFacturen(int klantId) {
        return facturatieDAO.getFacturen(klantId);
    }

    @Transactional
    public void deleteFactuur(int id) {
        facturatieDAO.deleteFactuur(id);
    }

    @Transactional
    public void updateFactuur(Facturatie factuur) {
        facturatieDAO.updateFactuur(factuur);
    }
    
    
    
            
}
