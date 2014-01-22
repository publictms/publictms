/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.service;

import be.pxl.publictms.DAO.LandDAO;
import be.pxl.publictms.pojo.Land;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Laurens Putsey
 */
@Service
public class LandServiceImpl implements LandService{
    
    @Autowired
    private LandDAO landDAO;
    
    @Transactional
    public Land getLand(int id) {
        return landDAO.getLand(id);
    }

    @Transactional
    public List<Land> getLanden() {
        return landDAO.getLanden();
    }

    @Transactional
    public void addLand(Land Land) {
        landDAO.addLand(Land);
    }

    @Transactional
    public void updateLand(Land land) {
        landDAO.updateLand(land);
    }

    @Transactional
    public void deleteLand(int id) {
        landDAO.deleteLand(id);
    }
    
}
