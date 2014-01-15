/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Persoonsinfo;
import be.pxl.publictms.service.PersoonsinfoService;
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
 * Controller die persoonelijke informatie verwerkt.
 * @author Stijn Ceunen
 */
@Controller
@RequestMapping("persoonsinfo")
public class PersoonsinfoController {
    
    private static final Logger logger = LoggerFactory.getLogger(PersoonsinfoController.class);
    
    @Autowired
    private PersoonsinfoService persoonsinfoService;
    /**
     * Geeft de persoonelijk informatie terug aan de hand van een index van een werknemer.
     * @param id
     * @return Persoonsinfo
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Persoonsinfo> getPersoonsinfo(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        Persoonsinfo json = persoonsinfoService.getPersoonsinfo(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Persoonsinfo>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Voeg nieuwe persoonelijke informatie toe aan de databank.
     * @param persoonsinfo 
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody void addPersoonsinfo(@RequestBody Persoonsinfo persoonsinfo){
        persoonsinfoService.addPersoonsinfo(persoonsinfo);
    }
    /**
     * Verwijder persoonelijke informatie van een werknemer
     * @param id 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deletePersoonsinfo(@PathVariable("id") int id){
        persoonsinfoService.deletePersoonsinfo(id);
    }
    /**
     * Bewerk de persoonelijke informatie van een werknemer.
     * @param persoonsinfo 
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody void updatePersoonsinfo(@RequestBody Persoonsinfo persoonsinfo){
        persoonsinfoService.updatePersoonsinfo(persoonsinfo);
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
