/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Contact;
import be.pxl.publictms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Contact controller om contacten te verwerken.
 * @author Laurens Putseys
 */
@Controller
@RequestMapping("contact")
public class ContactController {
    
    @Autowired
    private ContactService contactService;
    /**
     * Voeg een contact toe aan de databank.
     * @param contact 
     */
    @RequestMapping(value = "add",method = RequestMethod.PUT)
    public @ResponseBody void add(Contact contact){
        contactService.addContact(contact);
    }
    /**
     * Bewerk een contact uit de databank.
     * @param contact 
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public @ResponseBody void update(Contact contact){
        contactService.updateContact(contact);
    }
    /**
     * Geeft contact terug van een specifieke werknemer.
     * @param id
     * @return Contact
     */
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public @ResponseBody Contact get(@PathVariable("id") int id){
        return contactService.getContact(id);
    }
    /**
     * Delete een contact op de databank.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody void delete(@PathVariable("id") int id){
        contactService.deleteContact(id);
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
