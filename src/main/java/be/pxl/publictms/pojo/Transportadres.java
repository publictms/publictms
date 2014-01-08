package be.pxl.publictms.pojo;
// Generated 19-dec-2013 20:16:01 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Transportadres generated by hbm2java
 */
public class Transportadres  implements java.io.Serializable {


     private int transportid;
     private int adresid;
     private int contactid;
     private int taal;
     private String naam;
     private Boolean actief;
     private String soortadres;
     private String vensteruren;
     private String vrachtbeperking;
     private String chauffeursbeperking;
     private String vrijveld;

    public Transportadres() {
    }

	
    public Transportadres(int transportid, int adresid, int contactid) {
        this.transportid = transportid;
        this.adresid = adresid;
        this.contactid = contactid;
    }
    public Transportadres(int transportid, int adresid, int contactid, int taal, String naam, Boolean actief, String soortadres, String vensteruren, String vrachtbeperking, String chauffeursbeperking, String vrijveld) {
       this.transportid = transportid;
       this.adresid = adresid;
       this.contactid = contactid;
       this.taal = taal;
       this.naam = naam;
       this.actief = actief;
       this.soortadres = soortadres;
       this.vensteruren = vensteruren;
       this.vrachtbeperking = vrachtbeperking;
       this.chauffeursbeperking = chauffeursbeperking;
       this.vrijveld = vrijveld;
    }
   
    public int getTransportid() {
        return this.transportid;
    }
    
    public void setTransportid(int transportid) {
        this.transportid = transportid;
    }
    public int getAdresid() {
        return this.adresid;
    }
    
    public void setAdresid(int adresid) {
        this.adresid = adresid;
    }
    public int getContactid() {
        return this.contactid;
    }
    
    public void setContactid(int contactid) {
        this.contactid = contactid;
    }
    public int getTaal() {
        return this.taal;
    }
    
    public void setTaal(int taalid) {
        this.taal = taal;
    }
    public String getNaam() {
        return this.naam;
    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public Boolean getActief() {
        return this.actief;
    }
    
    public void setActief(Boolean actief) {
        this.actief = actief;
    }
    public String getSoortadres() {
        return this.soortadres;
    }
    
    public void setSoortadres(String soortadres) {
        this.soortadres = soortadres;
    }
    public String getVensteruren() {
        return this.vensteruren;
    }
    
    public void setVensteruren(String vensteruren) {
        this.vensteruren = vensteruren;
    }
    public String getVrachtbeperking() {
        return this.vrachtbeperking;
    }
    
    public void setVrachtbeperking(String vrachtbeperking) {
        this.vrachtbeperking = vrachtbeperking;
    }
    public String getChauffeursbeperking() {
        return this.chauffeursbeperking;
    }
    
    public void setChauffeursbeperking(String chauffeursbeperking) {
        this.chauffeursbeperking = chauffeursbeperking;
    }
    public String getVrijveld() {
        return this.vrijveld;
    }
    
    public void setVrijveld(String vrijveld) {
        this.vrijveld = vrijveld;
    }
}


