/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Bericht;
import be.pxl.publictms.service.BerichtService;
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
 * Controller die berichten verwerkt.
 * @author Laurens Putseys
 */
@Controller
@RequestMapping("bericht")
public class BerichtController {
    
    private static final Logger logger = LoggerFactory.getLogger(BerichtController.class);
    
    @Autowired
    private BerichtService berichtService;
    /**
     * Verstuur berichten naar de server.
     * @param bericht 
     */
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public @ResponseBody void send(@RequestBody Bericht bericht){
        berichtService.send(bericht);
    }
    /**
     * Geeft een list terug met alle berichten voor een specifieke ontvanger. 
     * De parameter is de index van deze ontvanger (werknemer).
     * @param id
     * @return List Bericht
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody List getBerichten(@PathVariable("id") int id){
        return berichtService.getBerichten(id);
    }
    /**
     * Delete een bericht van de databank.
     * @param id 
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable("id") int id){
        berichtService.deleteBericht(id);
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
