/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.view;

/**
 *
 * @author 11302785
 */
public class KlantView {
    private int transportid;
    private int adresid;
    private int taalid;
    private int contactid;
    private String soortadres;
    private boolean actief;
    private String vensteruren;
    private String vrachtbeperking;
    private String chauffeursbeperking;
    private String vrijveld;
    private String straat;
    private short nummer;
    private String bus;
    private int landid;
    private String land;
    private String postcode;
    private String gemeente;
    private String email;
    private String telefoon;
    private String gsm;
    private String fax;
    private String taalNaam;
    private int klantid;
    private String klantnaam;
    private String voornaam;
    private String bedrijf;
    private String website;
    private String betalingscondities;
    private String munt;
    private String btwregime;
    private String btwnummer;
    private String ondernemingsnummer;
    private String iban;
    private String bic;
    
    public KlantView(){
        
    }

    public KlantView(int transportid, int adresid, int taalid, int contactid, String soortadres, boolean actief, String vensteruren, String vrachtbeperking, String chauffeursbeperking, String vrijveld, String straat, short nummer, String bus,int landid, String land, String postcode, String gemeente, String email, String telefoon, String gsm, String fax, String taalNaam, int klantid, String klantnaam, String voornaam, String bedrijf, String website, String betalingscondities, String munt, String btwregime, String btwnummer, String ondernemingsnummer, String iban, String bic) {
        this.transportid = transportid;
        this.adresid = adresid;
        this.taalid = taalid;
        this.contactid = contactid;
        this.soortadres = soortadres;
        this.actief = actief;
        this.vensteruren = vensteruren;
        this.vrachtbeperking = vrachtbeperking;
        this.chauffeursbeperking = chauffeursbeperking;
        this.vrijveld = vrijveld;
        this.straat = straat;
        this.nummer = nummer;
        this.bus = bus;
        this.landid = landid;
        this.land = land;
        this.landid = landid;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.email = email;
        this.telefoon = telefoon;
        this.gsm = gsm;
        this.fax = fax;
        this.taalNaam = taalNaam;
        this.klantid = klantid;
        this.klantnaam = klantnaam;
        this.voornaam = voornaam;
        this.bedrijf = bedrijf;
        this.website = website;
        this.betalingscondities = betalingscondities;
        this.munt = munt;
        this.btwregime = btwregime;
        this.btwnummer = btwnummer;
        this.ondernemingsnummer = ondernemingsnummer;
        this.iban = iban;
        this.bic = bic;
    }

    public int getLandid() {
        return landid;
    }

    public void setLandid(int landid) {
        this.landid = landid;
    }
    
    public String getBetalingscondities() {
        return betalingscondities;
    }

    public void setBetalingscondities(String betalingscondities) {
        this.betalingscondities = betalingscondities;
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

    public int getTransportid() {
        return transportid;
    }

    public void setTransportid(int transportid) {
        this.transportid = transportid;
    }

    public int getAdresid() {
        return adresid;
    }

    public void setAdresid(int adresid) {
        this.adresid = adresid;
    }   
    

    public int getTaalid() {
        return taalid;
    }

    public void setTaalid(int taalid) {
        this.taalid = taalid;
    }

    public int getContactid() {
        return contactid;
    }

    public void setContactid(int contactid) {
        this.contactid = contactid;
    }

    public String getSoortadres() {
        return soortadres;
    }

    public void setSoortadres(String soortadres) {
        this.soortadres = soortadres;
    }

    public boolean isActief() {
        return actief;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }

    public String getVensteruren() {
        return vensteruren;
    }

    public void setVensteruren(String vensteruren) {
        this.vensteruren = vensteruren;
    }

    public String getVrachtbeperking() {
        return vrachtbeperking;
    }

    public void setVrachtbeperking(String vrachtbeperking) {
        this.vrachtbeperking = vrachtbeperking;
    }

    public String getChauffeursbeperking() {
        return chauffeursbeperking;
    }

    public void setChauffeursbeperking(String chauffeursbeperking) {
        this.chauffeursbeperking = chauffeursbeperking;
    }

    public String getVrijveld() {
        return vrijveld;
    }

    public void setVrijveld(String vrijveld) {
        this.vrijveld = vrijveld;
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

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
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

    public String getTaalNaam() {
        return taalNaam;
    }

    public void setTaalNaam(String taalNaam) {
        this.taalNaam = taalNaam;
    }

    public int getKlantid() {
        return klantid;
    }

    public void setKlantid(int klantid) {
        this.klantid = klantid;
    }

    public String getKlantnaam() {
        return klantnaam;
    }

    public void setKlantnaam(String klantnaam) {
        this.klantnaam = klantnaam;
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
}
