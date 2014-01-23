/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Klant;
import be.pxl.publictms.service.KlantService;
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
 * Controller om klanten te verwerken.
 * @author Laurens Putseys
 */
@Controller
@RequestMapping("klant")
public class KlantController {
    
    private static final Logger logger = LoggerFactory.getLogger(KlantController.class);
    
    @Autowired
    private KlantService klantService;
    /**
     * Bekijke een klant in detail aan de hand van zijn index.
     * @param id
     * @return Klant
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody Klant getKlant(@PathVariable("id") int id){
        return klantService.getKlant(id);
    }
    /**
     * Geeft een lijst met klanten terug.
     * @return List Klant
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public @ResponseBody List<Klant> getKlanten(){
        return klantService.getKlanten();
    }
    /**
     * Voeg een nieuwe klant toe.
     * @param klant 
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody void addKlant(@RequestBody Klant klant){
        klantService.addKlant(klant);
    }
    /**
     * Verwijder een bestaande klant.
     * @param id 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteKlant(@PathVariable("id") int id){
        klantService.deleteKlant(id);
    }
    /**
     * Bewerk een bestaande klant.
     * @param klant 
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody void updateKlant(@RequestBody Klant klant){
        klantService.updateKlant(klant);
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
