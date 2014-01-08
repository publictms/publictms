/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Taal;
import be.pxl.publictms.service.TaalService;
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
    public @ResponseBody Taal getTaal(@PathVariable("id") int id){
        return taalService.getTaal(id);
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
