/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Transportadres;
import be.pxl.publictms.service.TransportadresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    private TransportadresService transportadresService;
    /**
     * Geeft een transport adres terug aan de hand van zijn index.
     * @param id
     * @return Transportadres
     */
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public @ResponseBody Transportadres getTransportadres(@PathVariable("id") int id){
        return transportadresService.getTransportadres(id);
    }
    /**
     * Voeg een nieuw transport adres toe aan de databank.
     * @param transportadres 
     */
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public @ResponseBody void addTransportadres(Transportadres transportadres){
        transportadresService.addTransportadres(transportadres);
    }
    /**
     * Verwijder een bestaand transport adres uit de databank.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    public @ResponseBody void deleteTransportadres(@PathVariable("id") int id){
        transportadresService.deleteTransportadres(id);
    }
    /**
     * Bewerk een bestaand transport adres uit de databank.
     * @param transportadres 
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody void updateTransportadres(Transportadres transportadres){
        transportadresService.updateTransportadres(transportadres);
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
