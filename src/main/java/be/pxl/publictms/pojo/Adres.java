package be.pxl.publictms.pojo;
// Generated 19-dec-2013 20:16:01 by Hibernate Tools 3.2.1.GA

/**
 * Adres generated by hbm2java
 * Beschikt over adres gegevens
 */
public class Adres  implements java.io.Serializable {


     private int adresid;
     private String postcode;
     private String straat;
     private short nummer;
     private String bus;
     private String land;

    public Adres() {
    }

    public Adres(String postcode, String straat, short nummer, String bus, String land) {
       this.postcode = postcode;
       this.straat = straat;
       this.nummer = nummer;
       this.bus = bus;
       this.land = land;
    }

    public Adres(int adresid, String postcode, String straat, short nummer, String bus, String land) {
       this.adresid = adresid;
       this.postcode = postcode;
       this.straat = straat;
       this.nummer = nummer;
       this.bus = bus;
       this.land = land;
    }
   public Adres(String postcode, String straat, short nummer, String bus, String land) {
       this.postcode = postcode;
       this.straat = straat;
       this.nummer = nummer;
       this.bus = bus;
       this.land = land;
    }
    public int getAdresid() {
        return this.adresid;
    }
    
    public void setAdresid(int adresid) {
        this.adresid = adresid;
    }
    public String getPostcode() {
        return this.postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String getStraat() {
        return this.straat;
    }
    
    public void setStraat(String straat) {
        this.straat = straat;
    }
    public short getNummer() {
        return this.nummer;
    }
    
    public void setNummer(short nummer) {
        this.nummer = nummer;
    }
    public String getBus() {
        return this.bus;
    }
    
    public void setBus(String bus) {
        this.bus = bus;
    }
    public String getLand() {
        return this.land;
    }
    
    public void setLand(String land) {
        this.land = land;
    }
}


