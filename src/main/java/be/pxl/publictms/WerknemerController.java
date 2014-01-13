/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Transportadres;
import be.pxl.publictms.pojo.Werknemer;
import be.pxl.publictms.service.WerknemerService;
import java.util.List;
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
 * Controller om werknemers te verwerkene.
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
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List> getTransportadres(HttpServletRequest request, HttpServletResponse response){
        List<Werknemer> json = werknemerService.getWerknemers();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<List>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Voeg een nieuwe werknemer toe aan de databank.
     * @param werknemer 
     */
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public @ResponseBody void addWerknemer(Werknemer werknemer){
        if(!werknemerService.getWerknemers().contains(werknemer))
        werknemerService.addWerknemer(werknemer);
    }
    /**
     * Delete een werknemer uit de databank.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    public @ResponseBody void deleteWerknemer(@PathVariable("id") int id){
        if(werknemerService.getWerknemers().contains(werknemerService.getWerknemers().get(id)))
        werknemerService.deleteWerknemer(id);
    }
    /**
     * Bewerk een bestaande werknemer uit de databank.
     * @param werknemer 
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody void updateWerknemer(Werknemer werknemer){
        if(werknemerService.getWerknemers().contains(werknemer))
        werknemerService.updateWerknemer(werknemer);
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
