/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Taal;
import be.pxl.publictms.pojo.Transportadres;
import be.pxl.publictms.service.TransportadresService;
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
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Transportadres> getTransportadres(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        Transportadres json = transportadresService.getTransportadres(id);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Transportadres>(json, responseHeaders, HttpStatus.CREATED);
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
