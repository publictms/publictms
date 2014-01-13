/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Klant;
import be.pxl.publictms.service.KlantService;
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
    @RequestMapping(value = "detail/{id}",method = RequestMethod.GET)
    public @ResponseBody Klant getKlant(@PathVariable("id") int id){
        return klantService.getKlant(id);
    }
    /**
     * Geeft een lijst met klanten terug.
     * @return List Klant
     */
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List> getKlanten(HttpServletRequest request, HttpServletResponse response){
        List<Klant> json = klantService.getKlanten();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<List>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Voeg een nieuwe klant toe.
     * @param klant 
     */
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public @ResponseBody void addKlant(Klant klant){
        if(!klantService.getKlanten().contains(klant))
        klantService.addKlant(klant);
    }
    /**
     * Verwijder een bestaande klant.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody void deleteKlant(@PathVariable("id") int id){
        if(klantService.getKlanten().contains(klantService.getKlant(id)))
        klantService.deleteKlant(id);
    }
    /**
     * Bewerk een bestaande klant.
     * @param klant 
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody void updateKlant(Klant klant){
        if(klantService.getKlanten().contains(klant))
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
