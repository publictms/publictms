/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Postcode;
import be.pxl.publictms.pojo.Rijbewijsgegevens;
import be.pxl.publictms.service.RijbewijsgegevensService;
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
 * Controller om rijbewijsgegevens te bewerken.
 * @author Stijn Ceunen
 */
@Controller
@RequestMapping("rijbewijsgegevens")
public class RijbewijsgegevensController {
    
    private static final Logger logger = LoggerFactory.getLogger(RijbewijsgegevensController.class);
    
    @Autowired
    private RijbewijsgegevensService rijbewijsgegevensService;
    /**
     * Geef de rijbewijsgegevens terug aan de hand van een id.
     * @param id
     * @return Rijbewijsgegevens
     */
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Rijbewijsgegevens> getRijbewijsgegevens(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        Rijbewijsgegevens json = rijbewijsgegevensService.getRijbewijsgegevens(id);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Rijbewijsgegevens>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Voeg nieuwe rijbewijsgegevens toe aan de databank.
     * @param rijbewijsgegevens 
     */
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public @ResponseBody void addRijbewijsgegevens(Rijbewijsgegevens rijbewijsgegevens){
        rijbewijsgegevensService.addRijbewijsgegevens(rijbewijsgegevens);
    }
    /**
     * Verwijder bestaande rijbewijs gegevens uit de databank.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    public @ResponseBody void deleteRijbewijsgegevens(@PathVariable("id") int id){
        rijbewijsgegevensService.deleteRijbewijsgegevens(id);
    }
    /**
     * Bewerk bestaande rijbewijsgegevens uit de databank.
     * @param rijbewijsgegevens 
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody void updateRijbewijsgegevens(Rijbewijsgegevens rijbewijsgegevens){
        rijbewijsgegevensService.updateRijbewijsgegevens(rijbewijsgegevens);
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
