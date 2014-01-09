/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Gebruiker;
import be.pxl.publictms.service.GebruikerService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(value = "detail/{id}",method = RequestMethod.GET)
    public @ResponseBody Gebruiker getUser(@PathVariable("id") int id){
        return gebruikerService.getGebruikers().get(id);
    }
    /**
     * Geeft een lijst van gebruikers terug.
     * @return List Gebruiker
     */
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public @ResponseBody List<Gebruiker> getUsers(){
        /*if (BCrypt.checkpw("paswoord", gebruikerService.getGebruikers().get(0).getPaswoord()))
            System.out.println("It matches");
        else
            System.out.println("It does not match");*/
        return gebruikerService.getGebruikers();
    }
    /**
     * Voeg een nieuwe gebruiker toe.
     * @param gebruiker 
     */
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public @ResponseBody void addUser(Gebruiker gebruiker){
        if(!gebruikerService.getGebruikers().contains(gebruiker)){
            String salt = BCrypt.gensalt();
            gebruiker.setPaswoord(BCrypt.hashpw(gebruiker.getPaswoord(), BCrypt.gensalt()));
            gebruiker.setSalt(salt);
            gebruikerService.addGebruiker(gebruiker);
        }
    }
    /**
     * Verwijder een gebruiker.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody void deleteUser(@PathVariable("id") int id){
        if(gebruikerService.getGebruikers().contains(gebruikerService.getGebruikers().get(id)))
        gebruikerService.deleteGebruiker(id);
    }
    /**
     * Bewerk een bestaande gebruiker.
     * @param gebruiker 
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody void updateUser(Gebruiker gebruiker){
        if(gebruikerService.getGebruikers().contains(gebruiker))
        gebruikerService.updateGebruiker(gebruiker);
    }
    @RequestMapping(value = "check/{gebruikersnaam}/{paswoord}", method = RequestMethod.GET)
    public @ResponseBody boolean checkGebruiker(@PathVariable("gebruikersnaam") String gebruikersnaam, @PathVariable("paswoord") String paswoord ){
        return gebruikerService.checkUser(gebruikersnaam, paswoord);
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
