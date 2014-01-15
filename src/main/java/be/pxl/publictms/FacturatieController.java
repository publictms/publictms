/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Facturatie;
import be.pxl.publictms.service.FacturatieService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    private static final Logger logger = LoggerFactory.getLogger(FacturatieController.class);
    
    @Autowired
    private FacturatieService facturatieService;
    /**
     * Voeg een nieuw factuur toe aan de databank.
     * @param factuur 
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public @ResponseBody void add(@RequestBody Facturatie factuur){
        facturatieService.addFacturatie(factuur);
    }
    /**
     * Bewerk een bestaand factuur op de databank.
     * @param factuur 
     */
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public @ResponseBody void update(@RequestBody Facturatie factuur){
        facturatieService.updateFactuur(factuur);
    }
    /**
     * Geef een specifiek factuur terug aan de hand van zijn index.
     * @param id
     * @return Facturatie
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Facturatie> getFacturatie(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        Facturatie json = facturatieService.getFacturatie(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Facturatie>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Geeft een lijst facturen terug aan de hand van een klant index.
     * @param id
     * @return List Facturatie 
     */
    @RequestMapping(value = "factuur/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Facturatie> getFacturen(@PathVariable("id") int id){
        return facturatieService.getFacturen(id);
    }
    /**
     * Verwijder een factuur op de databank.
     * @param id 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
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
