/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Gebruiker;
import be.pxl.publictms.service.GebruikerService;
import java.io.IOException;
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
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller voor het verwerken van gebruikers alsook het inloggen.
 * @author Laurens Putseys
 */

@Controller
@RequestMapping("gebruiker")
public class GebruikerController {
    
    private static final Logger logger = LoggerFactory.getLogger(GebruikerController.class);
    
    @Autowired
    private GebruikerService gebruikerService;
    /**
     * Bekijk een gebruiker in detail
     * @param id
     * @return Gebruiker
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody Gebruiker getUser(@PathVariable("id") int id){
        return gebruikerService.getGebruikers().get(id);
    }
    /**
     * Geeft een lijst van gebruikers terug.
     * @return List Gebruiker
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List> getUsers(HttpServletRequest request, HttpServletResponse response){
        List<Gebruiker> json = gebruikerService.getGebruikers();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<List>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Voeg een nieuwe gebruiker toe.
     * @param gebruiker 
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public @ResponseBody void addUser(@RequestBody Gebruiker gebruiker){
        if(!gebruikerService.getGebruikers().contains(gebruiker)){
            String salt = BCrypt.gensalt();
            gebruiker.setPaswoord(BCrypt.hashpw(gebruiker.getPaswoord(), salt));
            gebruiker.setSalt(salt);
            gebruikerService.addGebruiker(gebruiker);
        }
    }
    /**
     * Verwijder een gebruiker.
     * @param id 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteUser(@PathVariable("id") int id){
        if(gebruikerService.getGebruikers().contains(gebruikerService.getGebruikers().get(id)))
        gebruikerService.deleteGebruiker(id);
    }
    /**
     * Bewerk een bestaande gebruiker.
     * @param gebruiker 
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody void updateUser(@RequestBody Gebruiker gebruiker){
        if(gebruikerService.getGebruikers().contains(gebruiker))
        gebruikerService.updateGebruiker(gebruiker);
    }
    @RequestMapping(value = "/{gebruikersnaam}/{paswoord}", method = RequestMethod.POST)
    public @ResponseBody Gebruiker checkGebruiker(@PathVariable("gebruikersnaam") String gebruikersnaam, @PathVariable("paswoord") String paswoord ) throws Exception {
        return gebruikerService.checkUser(gebruikersnaam, paswoord);
    }
    /**
     * Geeft foutmeldingen terug
     * @param ex
     * @return String
     */
    @ExceptionHandler(Exception.class)
    public @ResponseBody String handleUncaughtException(Exception ex, HttpServletResponse response) throws IOException{
        System.out.println(ex.toString());
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        return null;
    }
}
