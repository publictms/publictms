/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Werknemer;
import be.pxl.publictms.service.WerknemerService;
import be.pxl.publictms.view.WerknemerView;
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
 * Controller om werknemers te verwerken.
 * @author Laurens Putseys
 */

@Controller
@RequestMapping("werknemer")
public class WerknemerController {
    
    private static final Logger logger = LoggerFactory.getLogger(WerknemerController.class);
    
    @Autowired
    private WerknemerService werknemerService;

    /**
     * Geeft een lijst met werknemers terug.
     * @return List Werknemer
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public @ResponseBody List<Werknemer> getWerknemers(){
        return werknemerService.getWerknemers();
    }
    /**
     * Geeft een werknemers met werknemerid id.
     * @return List Werknemer
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody WerknemerView getWerknemer(@PathVariable("id") int id){
        return werknemerService.getWerknemer(id);
    }
    /**
     * Voeg een nieuwe werknemer toe aan de databank.
     * @param werknemer 
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody void addWerknemer(@RequestBody WerknemerView werknemerView){
        werknemerService.addWerknemer(werknemerView);
    }
    /**
     * Delete een werknemer uit de databank.
     * @param id 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteWerknemer(@PathVariable("id") int id){
        werknemerService.deleteWerknemer(id);
    }
    /**
     * Bewerk een bestaande werknemer uit de databank.
     * @param werknemer 
     */
    /*@RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody void updateWerknemer(@RequestBody Werknemer werknemer){
        if(werknemerService.getWerknemers().contains(werknemer))
        werknemerService.updateWerknemer(werknemer);
    }*/
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody void updateWerknemer(@RequestBody WerknemerView werknemerView){
        werknemerService.updateWerknemer(werknemerView);
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
