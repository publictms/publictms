/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Laadgegevens;
import be.pxl.publictms.service.LaadGegevensService;
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
 * Controller om laadgegevens te verwerken CRUD
 * @author Laurens Putseys
 */
@Controller
@RequestMapping("laadgegevens")
public class LaadGegevensController {
    
    private static final Logger logger = LoggerFactory.getLogger(LaadGegevensController.class);
    
    @Autowired
    private LaadGegevensService laadGegevensService;
    /**
     * Geef laadgegevens terug aan de hand van zijn index.
     * @param id
     * @return 
     */
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Laadgegevens> getLaadGegevens(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        Laadgegevens json = laadGegevensService.getLaadgegevens(id);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Laadgegevens>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Voeg nieuwe laadgegevens toe aan de databank.
     * @param laadgegevens 
     */
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public @ResponseBody void addLaadgegevens(Laadgegevens laadgegevens){
        laadGegevensService.addLaadgegevens(laadgegevens);
    }
    /**
     * Verwijder laadgegevens uit de databank.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    public @ResponseBody void deleteLaadGegevens(@PathVariable("id") int id){
        laadGegevensService.deleteLaadgegeven(id);
    }
    /**
     * Bewerk bestaande laadgegevens.
     * @param laadgegevens 
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody void updateLaadgegevens(Laadgegevens laadgegevens){
        laadGegevensService.updateLaadgegeven(laadgegevens);
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
