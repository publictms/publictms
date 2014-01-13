/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Opdracht;
import be.pxl.publictms.service.OpdrachtService;
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
 * Controller voor het verwerken van een opdracht. 
 * @author Stijn Ceunen, Laurens Putseys
 */
@Controller
@RequestMapping("opdracht")
public class OpdrachtController {
    
    private static final Logger logger = LoggerFactory.getLogger(OpdrachtController.class);
    
    @Autowired
    private OpdrachtService opdrachtService;
    
    /**
     * Geeft een lijst terug met opdrachten.
     * @return 
     */
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List> getOpdrachten(HttpServletRequest request, HttpServletResponse response){
        List<Opdracht> json = opdrachtService.getOpdrachten();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<List>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Geeft een lijst met opdrachten terug, in deze methoden zijn de indexen 
     * veranderd met de werkelijke waarde. 
     * @return List
     */
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List> getOpdrachtenWerkenemer(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        List<Opdracht> json = opdrachtService.getOpdrachtenWerknemer(id);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<List>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Voeg een nieuwe opdracht aan de databank.
     * @param opdracht 
     */
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public @ResponseBody void addOpdracht(Opdracht opdracht){
        opdrachtService.addOpdracht(opdracht);
    }
    /**
     * Verwijder een opdracht aan de hand van zijn index.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    public @ResponseBody void deleteOpdracht(@PathVariable("id") int id){
        opdrachtService.deleteOpdracht(id);
    }
    /**
     * Bewerk een bestaande opdracht.
     * @param opdracht 
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody void updateOpdracht(Opdracht opdracht){
        opdrachtService.updateOpdracht(opdracht);
    }
    
    /**
     * Verander de status van een opdracht
     * @param opdracht 
     */
    @RequestMapping(value = "updateStatus/{id}/{klaar}", method = RequestMethod.GET)
    public @ResponseBody void updateStatus(@PathVariable("klaar") int klaar,@PathVariable("id") int id){
        if(klaar == 1){
            opdrachtService.setKlaar(true, id);
        }else if(klaar == 0){
            opdrachtService.setKlaar(false, id);
        }
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
