package be.pxl.publictms.pojo;
// Generated 19-dec-2013 20:16:01 by Hibernate Tools 3.2.1.GA


/**
 * Laadgegevens generated by hbm2java
 * Laadgegevens van vrachtwagens, opleggers
 */
public class Laadgegevens  implements java.io.Serializable {


     private int laadid;
     private Double tarragewicht;
     private Double laadvermogen;
     private Double laadvolume;
     private Double laadmeters;
     private Double lengte;
     private Double breedte;
     private Double hoogte;
     private Integer aantalassen;
     private String motornorm;

    public Laadgegevens() {
    }

	
    public Laadgegevens(int laadid) {
        this.laadid = laadid;
    }
    public Laadgegevens(int laadid, Double tarragewicht, Double laadvermogen, Double laadvolume, Double laadmeters, Double lengte, Double breedte, Double hoogte, Integer aantalassen, String motornorm) {
       this.laadid = laadid;
       this.tarragewicht = tarragewicht;
       this.laadvermogen = laadvermogen;
       this.laadvolume = laadvolume;
       this.laadmeters = laadmeters;
       this.lengte = lengte;
       this.breedte = breedte;
       this.hoogte = hoogte;
       this.aantalassen = aantalassen;
       this.motornorm = motornorm;
    }
   
    public int getLaadid() {
        return this.laadid;
    }
    
    public void setLaadid(int laadid) {
        this.laadid = laadid;
    }
    public Double getTarragewicht() {
        return this.tarragewicht;
    }
    
    public void setTarragewicht(Double tarragewicht) {
        this.tarragewicht = tarragewicht;
    }
    public Double getLaadvermogen() {
        return this.laadvermogen;
    }
    
    public void setLaadvermogen(Double laadvermogen) {
        this.laadvermogen = laadvermogen;
    }
    public Double getLaadvolume() {
        return this.laadvolume;
    }
    
    public void setLaadvolume(Double laadvolume) {
        this.laadvolume = laadvolume;
    }
    public Double getLaadmeters() {
        return this.laadmeters;
    }
    
    public void setLaadmeters(Double laadmeters) {
        this.laadmeters = laadmeters;
    }
    public Double getLengte() {
        return this.lengte;
    }
    
    public void setLengte(Double lengte) {
        this.lengte = lengte;
    }
    public Double getBreedte() {
        return this.breedte;
    }
    
    public void setBreedte(Double breedte) {
        this.breedte = breedte;
    }
    public Double getHoogte() {
        return this.hoogte;
    }
    
    public void setHoogte(Double hoogte) {
        this.hoogte = hoogte;
    }
    public Integer getAantalassen() {
        return this.aantalassen;
    }
    
    public void setAantalassen(Integer aantalassen) {
        this.aantalassen = aantalassen;
    }
    public String getMotornorm() {
        return this.motornorm;
    }
    
    public void setMotornorm(String motornorm) {
        this.motornorm = motornorm;
    }
}


