/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Rijbewijsgegevens;
import be.pxl.publictms.pojo.Taal;
import be.pxl.publictms.service.TaalService;
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
 * Controller om talen te verwerken.
 * @author Stijn Ceunen
 */
@Controller
@RequestMapping("taal")
public class TaalController {
    
    private static final Logger logger = LoggerFactory.getLogger(TaalController.class);
    
    @Autowired
    private TaalService taalService;
    /**
     * Geef een taal object terug die een taal bevat.
     * @param id
     * @return Taal
     */
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Taal> getTaal(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        Taal json = taalService.getTaal(id);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Taal>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Voeg een nieuwe taal toe aan de databank.
     * @param taal 
     */
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public @ResponseBody void addTaal(Taal taal){
        taalService.addTaal(taal);
    }
    /**
     * Verwijder een bestaande taal uit de databank.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    public @ResponseBody void deleteTaal(@PathVariable("id") int id){
        taalService.deleteTaal(id);
    }
    /**
     * Bewerk een bestaande taal uit de databank.
     * @param taal 
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody void updateTaal(Taal taal){
        taalService.updateTaal(taal);
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
