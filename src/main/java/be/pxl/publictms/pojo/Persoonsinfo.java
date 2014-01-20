package be.pxl.publictms.pojo;
// Generated 16-jan-2014 9:58:36 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Persoonsinfo generated by hbm2java
 */
public class Persoonsinfo  implements java.io.Serializable {


     private int infoid;
     private String rijksregisternr;
     private String siskaart;
     private String identiteitsnr;
     private String pensioennr;
     private String geboorteplaats;
     private Date geboortedatum;
     private String iban;
     private String bic;
     private String burgerstand;
     private Integer aantalkinderen;

    public Persoonsinfo() {
    }

	
    public Persoonsinfo(int infoid, String rijksregisternr, String siskaart, String identiteitsnr, String pensioennr, String geboorteplaats, Date geboortedatum, String iban, String bic) {
        this.infoid = infoid;
        this.rijksregisternr = rijksregisternr;
        this.siskaart = siskaart;
        this.identiteitsnr = identiteitsnr;
        this.pensioennr = pensioennr;
        this.geboorteplaats = geboorteplaats;
        this.geboortedatum = geboortedatum;
        this.iban = iban;
        this.bic = bic;
    }
    public Persoonsinfo(int infoid, String rijksregisternr, String siskaart, String identiteitsnr, String pensioennr, String geboorteplaats, Date geboortedatum, String iban, String bic, String burgerstand, Integer aantalkinderen) {
       this.infoid = infoid;
       this.rijksregisternr = rijksregisternr;
       this.siskaart = siskaart;
       this.identiteitsnr = identiteitsnr;
       this.pensioennr = pensioennr;
       this.geboorteplaats = geboorteplaats;
       this.geboortedatum = geboortedatum;
       this.iban = iban;
       this.bic = bic;
       this.burgerstand = burgerstand;
       this.aantalkinderen = aantalkinderen;
    }
    
    public Persoonsinfo(String rijksregisternr, String siskaart, String identiteitsnr, String pensioennr, String geboorteplaats, Date geboortedatum, String iban, String bic, String burgerstand, int aantalkinderen) {
       this.rijksregisternr = rijksregisternr;
       this.siskaart = siskaart;
       this.identiteitsnr = identiteitsnr;
       this.pensioennr = pensioennr;
       this.geboorteplaats = geboorteplaats;
       this.geboortedatum = geboortedatum;
       this.iban = iban;
       this.bic = bic;
       this.burgerstand = burgerstand;
       this.aantalkinderen = aantalkinderen;
    }
   
    public int getInfoid() {
        return this.infoid;
    }
    
    public void setInfoid(int infoid) {
        this.infoid = infoid;
    }
    public String getRijksregisternr() {
        return this.rijksregisternr;
    }
    
    public void setRijksregisternr(String rijksregisternr) {
        this.rijksregisternr = rijksregisternr;
    }
    public String getSiskaart() {
        return this.siskaart;
    }
    
    public void setSiskaart(String siskaart) {
        this.siskaart = siskaart;
    }
    public String getIdentiteitsnr() {
        return this.identiteitsnr;
    }
    
    public void setIdentiteitsnr(String identiteitsnr) {
        this.identiteitsnr = identiteitsnr;
    }
    public String getPensioennr() {
        return this.pensioennr;
    }
    
    public void setPensioennr(String pensioennr) {
        this.pensioennr = pensioennr;
    }
    public String getGeboorteplaats() {
        return this.geboorteplaats;
    }
    
    public void setGeboorteplaats(String geboorteplaats) {
        this.geboorteplaats = geboorteplaats;
    }
    public Date getGeboortedatum() {
        return this.geboortedatum;
    }
    
    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }
    public String getIban() {
        return this.iban;
    }
    
    public void setIban(String iban) {
        this.iban = iban;
    }
    public String getBic() {
        return this.bic;
    }
    
    public void setBic(String bic) {
        this.bic = bic;
    }
    public String getBurgerstand() {
        return this.burgerstand;
    }
    
    public void setBurgerstand(String burgerstand) {
        this.burgerstand = burgerstand;
    }
    public Integer getAantalkinderen() {
        return this.aantalkinderen;
    } 
     public void setAantalkinderen(Integer aantalkinderen) {
        this.aantalkinderen = aantalkinderen;
    }
}


