/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Adres;
import be.pxl.publictms.service.AdresService;
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
 * Controller voor adressen CRUD
 * @author Laurens Putseys
 */
@Controller
@RequestMapping("adres")
public class AdresController {
    
    private static final Logger logger = LoggerFactory.getLogger(AdresController.class);
    
    @Autowired
    private AdresService adresService;
    /**
     * Voegt een adres toe aan de database
     * @param adres 
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public @ResponseBody void add(@RequestBody Adres adres){
        adresService.addAdres(adres);
    }
    /**
     * Geef een adres terug aan de hand van zijn id.
     * @param id
     * @return Adres
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Adres> getAdres(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        Adres json = adresService.getAdres(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Adres>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Delete een adres uit de databank aan de hand van zijn index.
     * @param id 
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable("id") int id){
        adresService.deleteAdres(id);
    }
    /**
     * Bewerkt een adres uit de databank.
     * @param adres 
     */
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public @ResponseBody void update(@RequestBody Adres adres){
        adresService.updateAdres(adres);
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
