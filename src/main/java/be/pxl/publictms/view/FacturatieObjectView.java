/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.view;

/**
 *
 * @author 11302785
 */
public class FacturatieObjectView {
    private Object facturatieId;
    private Object klantid;
    private Object eenheidsprijs;
    private Object korting;
    private Object aantalkilometer;
    private Object naam;
    private Object voornaam;
    private Object bedrijf;
    private Object website;
    private Object munt;
    private Object btwregime;
    private Object btwnummer;
    private Object ondernemingsnummer;
    private Object iban;
    private Object bic;
    private Object adresid;
    private Object straat;
    private Object nummer;
    private Object bus;
    private Object land;
    private Object postcode;
    private Object gemeente;
    private Object email;
    private Object telefoon;
    private Object gsm;
    private Object fax;
    
    public FacturatieObjectView(){
        
    }

    public FacturatieObjectView(Object facturatieId, Object klantid, Object eenheidsprijs, Object korting, Object aantalkilometer, 
            Object naam, Object voornaam, Object bedrijf, Object website, Object munt, Object btwregime, 
            Object btwnummer, Object ondernemingsnummer, Object iban, Object bic, Object adresid, Object straat, 
            Object nummer, Object bus, Object land, Object postcode, Object gemeente,
            Object email, Object telefoon, Object gsm, Object fax) {
        this.facturatieId = facturatieId;
        this.klantid = klantid;
        this.eenheidsprijs = eenheidsprijs;
        this.korting = korting;
        this.aantalkilometer = aantalkilometer;
        this.naam = naam;
        this.voornaam = voornaam;
        this.bedrijf = bedrijf;
        this.website = website;
        this.munt = munt;
        this.btwregime = btwregime;
        this.btwnummer = btwnummer;
        this.ondernemingsnummer = ondernemingsnummer;
        this.iban = iban;
        this.bic = bic;
        this.adresid = adresid;
        this.straat = straat;
        this.nummer = nummer;
        this.bus = bus;
        this.land = land;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.email = email;
        this.telefoon = telefoon;
        this.gsm = gsm;
        this.fax = fax;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(Object telefoon) {
        this.telefoon = telefoon;
    }

    public Object getGsm() {
        return gsm;
    }

    public void setGsm(Object gsm) {
        this.gsm = gsm;
    }

    public Object getFax() {
        return fax;
    }

    public void setFax(Object fax) {
        this.fax = fax;
    }
    
    public Object getFacturatieId() {
        return facturatieId;
    }

    public void setFacturatieId(Object facturatieId) {
        this.facturatieId = facturatieId;
    }

    public Object getKlantid() {
        return klantid;
    }

    public void setKlantid(Object klantid) {
        this.klantid = klantid;
    }

    public Object getKorting() {
        return korting;
    }

    public void setKorting(Object korting) {
        this.korting = korting;
    }

    public Object getAantalkilometer() {
        return aantalkilometer;
    }

    public void setAantalkilometer(Object aantalkilometer) {
        this.aantalkilometer = aantalkilometer;
    }

    public Object getNaam() {
        return naam;
    }

    public void setNaam(Object naam) {
        this.naam = naam;
    }

    public Object getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(Object voornaam) {
        this.voornaam = voornaam;
    }

    public Object getBedrijf() {
        return bedrijf;
    }

    public void setBedrijf(Object bedrijf) {
        this.bedrijf = bedrijf;
    }

    public Object getWebsite() {
        return website;
    }

    public void setWebsite(Object website) {
        this.website = website;
    }

    public Object getMunt() {
        return munt;
    }

    public void setMunt(Object munt) {
        this.munt = munt;
    }

    public Object getBtwregime() {
        return btwregime;
    }

    public void setBtwregime(Object btwregime) {
        this.btwregime = btwregime;
    }

    public Object getBtwnummer() {
        return btwnummer;
    }

    public void setBtwnummer(Object btwnummer) {
        this.btwnummer = btwnummer;
    }

    public Object getOndernemingsnummer() {
        return ondernemingsnummer;
    }

    public void setOndernemingsnummer(Object ondernemingsnummer) {
        this.ondernemingsnummer = ondernemingsnummer;
    }

    public Object getIban() {
        return iban;
    }

    public void setIban(Object iban) {
        this.iban = iban;
    }

    public Object getBic() {
        return bic;
    }

    public void setBic(Object bic) {
        this.bic = bic;
    }

    public Object getAdresid() {
        return adresid;
    }

    public void setAdresid(Object adresid) {
        this.adresid = adresid;
    }

    public Object getStraat() {
        return straat;
    }

    public void setStraat(Object straat) {
        this.straat = straat;
    }

    public Object getNummer() {
        return nummer;
    }

    public void setNummer(Object nummer) {
        this.nummer = nummer;
    }

    public Object getBus() {
        return bus;
    }

    public void setBus(Object bus) {
        this.bus = bus;
    }

    public Object getLand() {
        return land;
    }

    public void setLand(Object land) {
        this.land = land;
    }

    public Object getPostcode() {
        return postcode;
    }

    public void setPostcode(Object postcode) {
        this.postcode = postcode;
    }

    public Object getGemeente() {
        return gemeente;
    }

    public void setGemeente(Object gemeente) {
        this.gemeente = gemeente;
    }

    public Object getEenheidsprijs() {
        return eenheidsprijs;
    }

    public void setEenheidsprijs(Object eenheidsprijs) {
        this.eenheidsprijs = eenheidsprijs;
    }
    
}
