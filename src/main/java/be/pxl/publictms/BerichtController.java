/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Bericht;
import be.pxl.publictms.service.BerichtService;
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
    @RequestMapping(value = "send",method = RequestMethod.PUT)
    public @ResponseBody void send(Bericht bericht){
        berichtService.send(bericht);
    }
    /**
     * Geeft een list terug met alle berichten voor een specifieke ontvanger. 
     * De parameter is de index van deze ontvanger (werknemer).
     * @param id
     * @return List Bericht
     */
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List> getBericht(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        List<Bericht> json = berichtService.getBerichten(id);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<List>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Delete een bericht van de databank.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
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
