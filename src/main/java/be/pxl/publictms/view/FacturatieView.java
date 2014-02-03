/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.view;

/**
 *
 * @author 11302785
 */
public class FacturatieView {
    private int facturatieId;
    private int klantid;
    private double eenheidsprijs;
    private double korting;
    private double aantalkilometer;
    private String naam;
    private String voornaam;
    private String bedrijf;
    private String website;
    private String munt;
    private String btwregime;
    private String btwnummer;
    private String ondernemingsnummer;
    private String iban;
    private String bic;
    private int adresid;
    private String straat;
    private short nummer;
    private String bus;
    private int land;
    private String postcode;
    private String gemeente;
    private String email;
    private String telefoon;
    private String gsm;
    private String fax;

    public FacturatieView(){
        
    }
    
    public FacturatieView(int facturatieId, int klantid, double eenheidsprijs, double korting, double aantalkilometer, String naam, String voornaam, 
            String bedrijf, String website, String munt, String btwregime, String btwnummer, String ondernemingsnummer, 
            String iban, String bic, int adresid, String straat, short nummer, String bus, int land, String postcode, String gemeente,
            String email, String telefoon, String gsm, String fax) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
    public int getFacturatieId() {
        return facturatieId;
    }

    public void setFacturatieId(int facturatieId) {
        this.facturatieId = facturatieId;
    }

    public int getKlantid() {
        return klantid;
    }

    public void setKlantid(int klantid) {
        this.klantid = klantid;
    }

    public double getKorting() {
        return korting;
    }

    public void setKorting(double korting) {
        this.korting = korting;
    }

    public double getAantalkilometer() {
        return aantalkilometer;
    }

    public void setAantalkilometer(double aantalkilometer) {
        this.aantalkilometer = aantalkilometer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getBedrijf() {
        return bedrijf;
    }

    public void setBedrijf(String bedrijf) {
        this.bedrijf = bedrijf;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMunt() {
        return munt;
    }

    public void setMunt(String munt) {
        this.munt = munt;
    }

    public String getBtwregime() {
        return btwregime;
    }

    public void setBtwregime(String btwregime) {
        this.btwregime = btwregime;
    }

    public String getBtwnummer() {
        return btwnummer;
    }

    public void setBtwnummer(String btwnummer) {
        this.btwnummer = btwnummer;
    }

    public String getOndernemingsnummer() {
        return ondernemingsnummer;
    }

    public void setOndernemingsnummer(String ondernemingsnummer) {
        this.ondernemingsnummer = ondernemingsnummer;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public int getAdresid() {
        return adresid;
    }

    public void setAdresid(int adresid) {
        this.adresid = adresid;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public short getNummer() {
        return nummer;
    }

    public void setNummer(short nummer) {
        this.nummer = nummer;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public int getLand() {
        return land;
    }

    public void setLand(int land) {
        this.land = land;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public double getEenheidsprijs() {
        return eenheidsprijs;
    }

    public void setEenheidsprijs(double eenheidsprijs) {
        this.eenheidsprijs = eenheidsprijs;
    }
    
}
