package be.pxl.publictms.pojo;
// Generated 19-dec-2013 20:16:01 by Hibernate Tools 3.2.1.GA



/**
 * Facturatie generated by hbm2java
 * Facturatie gegevens.
 */
public class Facturatie  implements java.io.Serializable {


     private int facturatieid;
     private int klant;
     private Double eenheidsprijs;
     private Double korting;
     private Double aantalkilometer;
     

    public Facturatie() {
    }

    public Facturatie(int facturatieid, int klant, Double eenheidsprijs, double korting, Double aantalkilometer) {
       this.facturatieid = facturatieid;
       this.klant = klant;
       this.eenheidsprijs = eenheidsprijs;
       this.korting = korting;
       this.aantalkilometer = aantalkilometer;
    }
   
    public int getFacturatieid() {
        return this.facturatieid;
    }
    
    public void setFacturatieid(int facturatieid) {
        this.facturatieid = facturatieid;
    }
    
    public int getKlant() {
        return this.klant;
    }
    
    public void setKlant(int klant) {
        this.klant = klant;
    }
    public Double getAantalkilometer() {
        return this.aantalkilometer;
    }
    
    public void setAantalkilometer(Double aantalkilometer) {
        this.aantalkilometer = aantalkilometer;
    }

    public Double getKorting() {
        return korting;
    }

    public void setKorting(Double korting) {
        this.korting = korting;
    }
    
    public Double getEenheidsprijs() {
        return eenheidsprijs;
    }

    public void setEenheidsprijs(Double eenheidsprijs) {
        this.eenheidsprijs = eenheidsprijs;
    }
    
    
}


