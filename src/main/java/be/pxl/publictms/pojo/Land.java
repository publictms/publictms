/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.pojo;


/**
 *
 * @author Laurens Putseys
 */
public class Land implements java.io.Serializable{
    
     private int landid;
     private String landnaam;

    public Land() {
    }

    public Land(int landid, String landnaam) {
       this.landid = landid;
       this.landnaam = landnaam;
    }
   
    public int getLandid() {
        return this.landid;
    }
    
    public void setLandid(int landid) {
        this.landid = landid;
    }
    public String getLandnaam() {
        return this.landnaam;
    }
    
    public void setLandnaam(String landnaam) {
        this.landnaam = landnaam;
    }
}
