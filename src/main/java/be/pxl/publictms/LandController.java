/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Land;
import be.pxl.publictms.service.LandService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Laurens Putseys
 */
@Controller
@RequestMapping("land")
public class LandController {
    
    private static final Logger logger = LoggerFactory.getLogger(PostcodeController.class);
    
    @Autowired
    private LandService landService;
    
    /**
     * Geeft postcode terug aan de hand van een id.
     * @param id
     * @return Postcode
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Land> getLand(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        Land json = landService.getLand(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Land>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Geeft een lijst terug van alle gemeentes en bijhorende postcodes.
     * @return List Postcode
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List> getLanden(HttpServletRequest request, HttpServletResponse response){
        List<Land> json = landService.getLanden();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<List>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Voeg een nieuwe gemeente en postcode toe aan de databank.
     * @param postcode 
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public @ResponseBody void addLand(@RequestBody Land land){
        landService.addLand(land);
    }
    /**
     * Verwijder een bestaande postcode.
     * @param id 
     */
    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    public @ResponseBody void deleteGemeente(@PathVariable("id") int id){
        landService.deleteLand(id);
    }
    /**
     * Bewerk een bestaand postcode. 
     * @param postcode 
     */
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public @ResponseBody void updateGemeente(@RequestBody Land land){
        landService.updateLand(land);
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
