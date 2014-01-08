/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Opdracht;
import be.pxl.publictms.service.OpdrachtService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller voor het verwerken van een opdracht. 
 * @author Stijn Ceunen
 */
@Controller
@RequestMapping("opdracht")
public class OpdrachtController {
    
    @Autowired
    private OpdrachtService opdrachtService;
    /**
     * Geeft een lijst terug met opdrachten.
     * @return 
     */
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public @ResponseBody List<Opdracht> getOpdracht(){
        return opdrachtService.getOpdracht();
    }
    /**
     * Voeg een nieuwe opdracht aan de databank.
     * @param opdracht 
     */
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public @ResponseBody void addOpdracht(Opdracht opdracht){
        opdrachtService.addOpdracht(opdracht);
    }
    /**
     * Verwijder een opdracht aan de hand van zijn index.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.PUT)
    public @ResponseBody void deleteOpdracht(@PathVariable("id") int id){
        opdrachtService.deleteOpdracht(id);
    }
    /**
     * Bewerk een bestaande opdracht.
     * @param opdracht 
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public @ResponseBody void updateOpdracht(Opdracht opdracht){
        opdrachtService.updateOpdracht(opdracht);
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
