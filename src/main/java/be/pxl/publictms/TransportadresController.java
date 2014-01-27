/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.service.TransportadresService;
import be.pxl.publictms.view.KlantObjectView;
import be.pxl.publictms.view.KlantView;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller om transportadressen te verwerken
 * @author Stijn Ceunen
 */
@Controller
@RequestMapping("transport")
public class TransportadresController {
    
    private static final Logger logger = LoggerFactory.getLogger(TransportadresController.class);
    
    @Autowired
    private TransportadresService transportadresService;
    
    /**
     * Geeft een transport adres terug aan de hand van zijn index.
     * @param id
     * @return Transportadres
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public @ResponseBody List<KlantView> getTransportadressen(){
        return transportadresService.getTransportadres();
    }
    
    /**
     * Geeft een transport adres terug aan de hand van zijn index.
     * @param id
     * @return Transportadres
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody KlantObjectView getTransportadres(@PathVariable("id") int id){
        return transportadresService.getTransportadres(id);
    }
    /**
     * Voeg een nieuw transport adres toe aan de databank.
     * @param transportadres 
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody void addTransportadres(@RequestBody KlantView klant){
        transportadresService.addTransportadres(klant);
    }
    /**
     * Verwijder een bestaand transport adres uit de databank.
     * @param id 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteTransportadres(@PathVariable("id") int id){
        transportadresService.deleteTransportadres(id);
    }
    /**
     * Bewerk een bestaand transport adres uit de databank.
     * @param transportadres 
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody void updateTransportadres(@RequestBody KlantView klant){
        transportadresService.updateTransportadres(klant);
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
