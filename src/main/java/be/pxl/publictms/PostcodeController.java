/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Postcode;
import be.pxl.publictms.service.PostcodeService;
import java.util.List;
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
 * Controller om postcodes en gemeentes te verwerken.
 * @author Laurens Putseys
 */
@Controller
@RequestMapping("postcode")
public class PostcodeController {
    
    private static final Logger logger = LoggerFactory.getLogger(PostcodeController.class);
    
    @Autowired
    private PostcodeService postcodeService;
    /**
     * Geeft postcode terug aan de hand van een id.
     * @param id
     * @return Postcode
     */
    @RequestMapping(value = "gemeente/{id}",method = RequestMethod.GET)
    public @ResponseBody Postcode getGemeente(@PathVariable("id") String id){
        return postcodeService.getGemeente(id);
    }
    /**
     * Geeft een lijst terug van alle gemeentes en bijhorende postcodes.
     * @return List Postcode
     */
    @RequestMapping(value = "gemeente",method = RequestMethod.GET)
    public @ResponseBody List<Postcode> getGemeente(){
        return postcodeService.getGemeente();
    }
    /**
     * Voeg een nieuwe gemeente en postcode toe aan de databank.
     * @param postcode 
     */
    @RequestMapping(value = "add",method = RequestMethod.PUT)
    public @ResponseBody void addGemeente(Postcode postcode){
        postcodeService.addGemeente(postcode);
    }
    /**
     * Verwijder een bestaande postcode.
     * @param id 
     */
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public @ResponseBody void deleteGemeente(@PathVariable("id") String id){
        postcodeService.deleteGemeente(id);
    }
    /**
     * Bewerk een bestaand postcode. 
     * @param postcode 
     */
    @RequestMapping(value = "update",method = RequestMethod.GET)
    public @ResponseBody void updateGemeente(Postcode postcode){
        postcodeService.updateGemeente(postcode);
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
