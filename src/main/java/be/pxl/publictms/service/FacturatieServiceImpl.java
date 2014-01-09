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
 * worden hier uitgewerkt. De methodes maken gebruik van FacturatieDAO waar
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
public class FacturatieServiceImpl implements FacturatieService{
    
    @Autowired
    private FacturatieDAO facturatieDAO;

    /**
     * Methode voor het toevoegen van data aan de tabel Facturatie.
     * 
     * @param factuur     POJO representatie van de data die toegevoegd wordt.
     */
    @Transactional
    public void addFacturatie(Facturatie factuur) {
        facturatieDAO.addFacturatie(factuur);
    }

    /**
     * Methode voor het ophalen van een record uit de tabel Facturatie met 
     * een bepaald id.
     * 
     * @param id    Het factuurid van het record dat opgehaald moet worden.
     * @return      POJO van het opgehaalde data.
     */
    @Transactional
    public Facturatie getFacturatie(int id) {
        return facturatieDAO.getFacturatie(id);
    }

    /**
     * Methode voor het ophalen van een aantal record uit de tabel Facturatie 
     * voor een bepaald klantid.
     * 
     * @param id    Het klantid van de records die opgehaald moet worden.
     * @return      Lijst van data van de tabel Facturatie. Elk record wordt
     *              voorgesteld met POJO Facturatie.
     */
    @Transactional
    public List<Facturatie> getFacturen(int klantId) {
        return facturatieDAO.getFacturen(klantId);
    }

    /**
     * Methode voor het verwijderen van een record uit de tabel Facturatie.
     * 
     * @param id    Het factuurid van het record dat verwijderd moet worden.
     */
    @Transactional
    public void deleteFactuur(int id) {
        facturatieDAO.deleteFactuur(id);
    }

    /**
     * Methode voor het updaten van een record uit de tabel Facturatie.
     * 
     * @param factuur     POJO van de geüpdate data.
     */
    @Transactional
    public void updateFactuur(Facturatie factuur) {
        facturatieDAO.updateFactuur(factuur);
    }       
}
