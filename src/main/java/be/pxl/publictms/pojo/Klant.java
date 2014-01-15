package be.pxl.publictms.pojo;
// Generated 19-dec-2013 20:16:01 by Hibernate Tools 3.2.1.GA

/**
 * Klant generated by hbm2java
 * Klant gegevens
 */
public class Klant  implements java.io.Serializable {


     private int klantid;
     private int taal;
     private String naam;
     private String voornaam;
     private String bedrijf;
     private int adresid;
     private String website;
     private int contactid;
     private Boolean actief;

    public Klant() {
    }

	
    public Klant(int klantid, int taal, String naam, String voornaam, String bedrijf, int adresid, int contactid) {
        this.klantid = klantid;
        this.taal = taal;
        this.naam = naam;
        this.voornaam = voornaam;
        this.bedrijf = bedrijf;
        this.adresid = adresid;
        this.contactid = contactid;
    }
    public Klant(int klantid, int taal, String naam, String voornaam, String bedrijf, int adresid, String website, int contactid, Boolean actief) {
       this.klantid = klantid;
       this.taal = taal;
       this.naam = naam;
       this.voornaam = voornaam;
       this.bedrijf = bedrijf;
       this.adresid = adresid;
       this.website = website;
       this.contactid = contactid;
       this.actief = actief;
    }
   
    public int getKlantid() {
        return this.klantid;
    }
    
    public void setKlantid(int klantid) {
        this.klantid = klantid;
    }
    public int getTaal() {
        return this.taal;
    }
    
    public void setTaal(int taal) {
        this.taal = taal;
    }
    public String getNaam() {
        return this.naam;
    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public String getVoornaam() {
        return this.voornaam;
    }
    
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }
    public String getBedrijf() {
        return this.bedrijf;
    }
    
    public void setBedrijf(String bedrijf) {
        this.bedrijf = bedrijf;
    }
    public int getAdresid() {
        return this.adresid;
    }
    
    public void setAdresid(int adresid) {
        this.adresid = adresid;
    }
    public String getWebsite() {
        return this.website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    public int getContactid() {
        return this.contactid;
    }
    
    public void setContactid(int contactid) {
        this.contactid = contactid;
    }
    public Boolean getActief() {
        return this.actief;
    }
    
    public void setActief(Boolean actief) {
        this.actief = actief;
    }
}


