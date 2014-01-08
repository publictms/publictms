/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Actie;
import be.pxl.publictms.service.ActieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller actie CRUD
 * @author Stijn Ceunen
 */
@Controller
@RequestMapping("actie")
public class ActieController {
    
    @Autowired
    private ActieService actieService;
    /**
     * Voegt een actie toe aan de database
     * @param actie 
     */
    @RequestMapping(value = "add",method = RequestMethod.PUT)
    public @ResponseBody void add(Actie actie){
        actieService.addActie(actie);
    }
    /**
     * Geeft een actie terug aan de hand van zijn index.
     * @param id
     * @return List Actie
     */
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public @ResponseBody List<Actie> get(@PathVariable("id") int id){
        return actieService.getActiesVanOpdracht(id);
    }
    /**
     * Delete een actie in de database aan de hand van zijn index.
     * @param id 
     */
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public @ResponseBody void delete(@PathVariable("id") int id){
        actieService.deleteActie(id);
    }
    /**
     * Bewerkt een actie in de database.
     * @param actie 
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public @ResponseBody void update(Actie actie){
        actieService.updateActie(actie);
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
