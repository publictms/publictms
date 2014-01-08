/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms;

import be.pxl.publictms.pojo.Rijbewijsgegevens;
import be.pxl.publictms.service.RijbewijsgegevensService;
import be.pxl.publictms.service.TransportadresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Stijn
 */
@Controller
@RequestMapping("rijbewijsgegevens")
public class RijbewijsgegevensController {
    
    @Autowired
    private RijbewijsgegevensService rijbewijsgegevensService;
    
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public @ResponseBody Rijbewijsgegevens getRijbewijsgegevens(@PathVariable("id") int id){
        return rijbewijsgegevensService.getRijbewijsgegevens(id);
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public @ResponseBody void addRijbewijsgegevens(Rijbewijsgegevens rijbewijsgegevens){
        rijbewijsgegevensService.addRijbewijsgegevens(rijbewijsgegevens);
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public @ResponseBody void deleteRijbewijsgegevens(@PathVariable("id") int id){
        rijbewijsgegevensService.deleteRijbewijsgegevens(id);
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody void updateRijbewijsgegevens(Rijbewijsgegevens rijbewijsgegevens){
        rijbewijsgegevensService.updateRijbewijsgegevens(rijbewijsgegevens);
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody String handleUncaughtException(Exception ex){
        System.out.println(ex.toString());
        return ex.toString();
    }
}
