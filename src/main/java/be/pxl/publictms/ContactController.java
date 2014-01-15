/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Contact;
import be.pxl.publictms.service.ContactService;
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
 * Contact controller om contacten te verwerken.
 * @author Laurens Putseys
 */
@Controller
@RequestMapping("contact")
public class ContactController {
    
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
    
    @Autowired
    private ContactService contactService;
    /**
     * Voeg een contact toe aan de databank.
     * @param contact 
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public @ResponseBody void add(@RequestBody Contact contact){
        contactService.addContact(contact);
    }
    /**
     * Bewerk een contact uit de databank.
     * @param contact 
     */
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public @ResponseBody void update(@RequestBody Contact contact){
        contactService.updateContact(contact);
    }
    /**
     * Geeft contact terug van een specifieke werknemer.
     * @param id
     * @return Contact
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Contact> getContact(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response){
        Contact json = contactService.getContact(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Contact>(json, responseHeaders, HttpStatus.CREATED);
    }
    /**
     * Delete een contact op de databank.
     * @param id 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
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
