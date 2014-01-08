/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Voertuig;
import be.pxl.publictms.service.VoertuigService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller om voertuigen te verwerken
 * @author Stijn Ceunen
 */
@Controller
@RequestMapping("voertuig")
public class VoertuigController {
    
    private static final Logger logger = LoggerFactory.getLogger(VoertuigController.class);
    
    @Autowired
    private VoertuigService voertuigService;
    /**
     * Geeft een lijst met voertuigen terug.
     * @return List Voertuig
     */
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public @ResponseBody List<Voertuig> getVoertuigen(){
        return voertuigService.getVoertuigen();
    }
    /**
     * Geeft een voertuig terug aan de hand van zijn index.
     * @param id
     * @return Voertuig
     */
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public @ResponseBody Voertuig getVoertuig(@PathVariable("id") int id){
        return voertuigService.getVoertuig(id);
    }
    /**
     * Voeg een nieuw voertuig toe aan de databank.
     * @param voertuig 
     */
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public @ResponseBody void addVoertuig(Voertuig voertuig){
        voertuigService.addVoertuig(voertuig);
    }
    /**
     * Verwijder een bestaan voertuig uit de databank.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    public @ResponseBody void deleteVoertuig(@PathVariable("id") int id){
        voertuigService.deleteVoertuig(id);
    }
    /**
     * Bewerk een bestaand voertuig uit de databank.
     * @param voertuig 
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody void updateVoertuig(Voertuig voertuig){
        voertuigService.updateVoertuig(voertuig);
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
