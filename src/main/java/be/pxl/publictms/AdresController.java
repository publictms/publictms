/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Adres;
import be.pxl.publictms.service.AdresService;
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
 * Controller voor adressen CRUD
 * @author Laurens Putseys
 */
@Controller
@RequestMapping("adres")
public class AdresController {
    
    private static final Logger logger = LoggerFactory.getLogger(AdresController.class);
    
    @Autowired
    private AdresService adresService;
    /**
     * Voegt een adres toe aan de database
     * @param adres 
     */
    @RequestMapping(value = "add",method = RequestMethod.PUT)
    public @ResponseBody void add(Adres adres){
        adresService.addAdres(adres);
    }
    /**
     * Geef een adres terug aan de hand van zijn id.
     * @param id
     * @return Adres
     */
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public @ResponseBody Adres get(@PathVariable("id") int id){
        return adresService.getAdres(id);
    }
    /**
     * Delete een adres uit de databank aan de hand van zijn index.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public @ResponseBody void delete(@PathVariable("id") int id){
        adresService.deleteAdres(id);
    }
    /**
     * Bewerkt een adres uit de databank.
     * @param adres 
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public @ResponseBody void update(Adres adres){
        adresService.updateAdres(adres);
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
