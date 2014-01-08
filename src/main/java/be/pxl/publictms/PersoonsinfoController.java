/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Persoonsinfo;
import be.pxl.publictms.service.PersoonsinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public @ResponseBody Persoonsinfo getPersoonsinfo(@PathVariable("id") int id){
        return persoonsinfoService.getPersoonsinfo(id);
    }
    /**
     * Voeg nieuwe persoonelijke informatie toe aan de databank.
     * @param persoonsinfo 
     */
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public @ResponseBody void addPersoonsinfo(Persoonsinfo persoonsinfo){
        persoonsinfoService.addPersoonsinfo(persoonsinfo);
    }
    /**
     * Verwijder persoonelijke informatie van een werknemer
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    public @ResponseBody void deletePersoonsinfo(@PathVariable("id") int id){
        persoonsinfoService.deletePersoonsinfo(id);
    }
    /**
     * Bewerk de persoonelijke informatie van een werknemer.
     * @param persoonsinfo 
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody void updatePersoonsinfo(Persoonsinfo persoonsinfo){
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
