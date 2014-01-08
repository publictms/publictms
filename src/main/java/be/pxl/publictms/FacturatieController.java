/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Facturatie;
import be.pxl.publictms.service.FacturatieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Facturatie controller die alle facturen verwerkt.
 * @author Laurens Putseys
 */
@Controller
@RequestMapping("factuur")
public class FacturatieController {
    
    @Autowired
    private FacturatieService facturatieService;
    /**
     * Voeg een nieuw factuur toe aan de databank.
     * @param factuur 
     */
    @RequestMapping(value = "add",method = RequestMethod.PUT)
    public @ResponseBody void add(Facturatie factuur){
        facturatieService.addFacturatie(factuur);
    }
    /**
     * Bewerk een bestaand factuur op de databank.
     * @param factuur 
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public @ResponseBody void update(Facturatie factuur){
        facturatieService.updateFactuur(factuur);
    }
    /**
     * Geef een specifiek factuur terug aan de hand van zijn index.
     * @param id
     * @return Facturatie
     */
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public @ResponseBody Facturatie get(@PathVariable("id") int id){
        return facturatieService.getFacturatie(id);
    }
    /**
     * Geeft een lijst facturen terug aan de hand van een klant index.
     * @param id
     * @return List Facturatie 
     */
    @RequestMapping(value = "getfacturen/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Facturatie> getFacturen(@PathVariable("id") int id){
        return facturatieService.getFacturen(id);
    }
    /**
     * Verwijder een factuur op de databank.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody void delete(@PathVariable("id") int id){
        facturatieService.deleteFactuur(id);
    }
    /**
     * Geeft foutmeldingen terug
     * @param ex
     * @return String
     */
    @ExceptionHandler(Exception.class)
    public @ResponseBody String handleUncaughtException(Exception ex){
        System.out.println(ex.toString());
        return ex.toString();
    }
    
}
