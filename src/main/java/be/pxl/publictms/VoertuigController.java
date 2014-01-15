/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Voertuig;
import be.pxl.publictms.service.VoertuigService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private VoertuigService voertuigService;

    /**
     * Geeft een lijst van voertuigen terug
     * @return List<Voertuig>
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Voertuig> getVoertuigen() {
        return voertuigService.getVoertuigen();
    }

    /**
     * geef een detail overzicht van een voertuig
     * @param id
     * @return Voertuig
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Voertuig getVoertuig(@PathVariable("id") int id) {
        return voertuigService.getVoertuig(id);
    }

    /**
     * Voegt een nieuw voertuig toe aan de databank
     * @param voertuig 
     */
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = {"application/json"})
    public @ResponseBody void addVoertuig(@RequestBody Voertuig voertuig) {
        voertuigService.addVoertuig(voertuig);
    }

    /**
     * Verwijderd een bestaand voertuig uit de databank
     * @param id 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteVoertuig(@PathVariable("id") int id) {
        voertuigService.deleteVoertuig(id);
    }

    /**
     * Bewerkt een bestaand voertuig
     * @param voertuig 
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody void updateVoertuig(@RequestBody Voertuig voertuig) {
        voertuigService.updateVoertuig(voertuig);
    }
    /**
     * Geeft foutmeldingen terug
     * @param ex
     * @return String
     */
    @ExceptionHandler(Exception.class)
    public @ResponseBody
    String handleUncaughtException(Exception ex) {
        System.out.println(ex.toString());
        return ex.toString();
    }
}
