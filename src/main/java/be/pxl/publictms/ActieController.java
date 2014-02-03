/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Actie;
import be.pxl.publictms.service.ActieService;
import be.pxl.publictms.view.ActieObjectView;
import be.pxl.publictms.view.ActieView;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    private static final Logger logger = LoggerFactory.getLogger(ActieController.class);
    
    @Autowired
    private ActieService actieService;
    
    /**
     * Voegt een actie toe aan de database
     * @param actie 
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public @ResponseBody void add(@RequestBody ActieView actieView){
        actieService.addActie(actieView);
    }
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public @ResponseBody List<ActieObjectView> getActies(){
        return actieService.getActies();
    }
    
    /**
     * Geeft alle acties per opdracht zonder indexen maar als bruikbaar gegeven.
     * @param id
     * @return List<Actie>
     */
    @RequestMapping(value = "/actie/{id}",method = RequestMethod.GET)
    public @ResponseBody ActieObjectView getActie(@PathVariable("id") int id){
        return actieService.getActie(id);
    }
    /**
     * Geeft alle acties per opdracht zonder indexen maar als bruikbaar gegeven.
     * @param id
     * @return List<Actie>
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody List<ActieObjectView> getActiesWerknemer(@PathVariable("id") int id){
        return actieService.getActiesWerknemer(id);
    }
     /**
     * Geeft alle acties per opdracht zonder indexen maar als bruikbaar gegeven.
     * @param id
     * @return List<Actie>
     */
    @RequestMapping(value = "/opdracht/{id}",method = RequestMethod.GET)
    public @ResponseBody List<ActieObjectView> getActiesOpdracht(@PathVariable("id") int id){
        return actieService.getActiesOpdracht(id);
    }
    /**
     * Delete een actie in de database aan de hand van zijn index.
     * @param id 
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable("id") int id){
        actieService.deleteActie(id);
    }
    /**
     * Bewerkt een actie in de database.
     * @param actie 
     */
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public @ResponseBody void update(@RequestBody ActieView actieView){
        actieService.updateActie(actieView);
    }
    /**
     * Verander de status van een actie
     * @param opdracht 
     */
    @RequestMapping(value = "/{id}/{klaar}", method = RequestMethod.GET)
    public @ResponseBody void updateStatus(@PathVariable("klaar") int klaar,@PathVariable("id") int id){
        if(klaar == 1){
            actieService.setKlaar(true, id);
        }else if(klaar == 0){
            actieService.setKlaar(false, id);
        }
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
