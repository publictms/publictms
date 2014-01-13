/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Oplegger;
import be.pxl.publictms.service.OpleggerService;
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
 * Controller op oplegger data te verwerken.
 * @author Laurens Putseys
 */
@Controller
@RequestMapping("oplegger")
public class OpleggerController {
    
    private static final Logger logger = LoggerFactory.getLogger(OpleggerController.class);
    
    @Autowired
    private OpleggerService opleggerService;
    /**
     * Geeft de informatie terug van een specifieke oplegger.
     * @param id
     * @return Oplegger
     */
    @RequestMapping(value = "detail/{id}",method = RequestMethod.GET)
    public @ResponseBody Oplegger getOplegger(@PathVariable("id") int id){
        return opleggerService.getOplegger(id);
    }
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Oplegger> getOplegger(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        Oplegger json = opleggerService.getOplegger(id);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Oplegger>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Geeft een lijst terug met alle opleggers
     * @return Oplegger
     */
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List> getOpleggers(HttpServletRequest request, HttpServletResponse response){
        List<Oplegger> json = opleggerService.getOpleggers();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<List>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Voeg een nieuw oplegger toe aan de databank.
     * @param oplegger 
     */
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public @ResponseBody void addOplegger(Oplegger oplegger){
        if(!opleggerService.getOpleggers().contains(oplegger))
        opleggerService.addOplegger(oplegger);
    }
    /**
     * Verwijder een bestaande oplegger.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody void deleteOplegger(@PathVariable("id") int id){
        if(opleggerService.getOpleggers().contains(opleggerService.getOplegger(id)))
        opleggerService.deleteOpleggers(id);
    }
    /**
     * Bewerk een bestaande oplegger.
     * @param oplegger 
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody void updateOplegger(Oplegger oplegger){
        if(opleggerService.getOpleggers().contains(oplegger))
        opleggerService.updateOplegger(oplegger);
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
