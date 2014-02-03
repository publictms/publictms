package be.pxl.publictms.view;

import java.util.Date;

public class WerknemerView {
    
    private int werknemerid;
     private int taalid;
     private String naam;
     private String voornaam;
     private Boolean actief;
     private int adresid;
     private int contactid;
     private Character geslacht;
     private String statuut;
     private Date datuminschrijving;
     private Date datumuitschrijving;
     private String functie;
     private int rijbewijsid;
     private int infoid;
     private String postcode;
     private String straat;
     private short nummer;
     private String bus;
     private int land;
     private String email;
     private String telefoon;
     private String gsm;
     private String fax;
     private String rijksregisternr;
     private String siskaart;
     private String identiteitsnr;
     private String pensioennr;
     private String geboorteplaats;
     private Date geboortedatum;
     private String iban;
     private String bic;
     private String burgerstand;
     private int aantalkinderen;
     private String rijbewijsnr;
     private String rijbewijscat;
     private Date geldigtot;
     private Boolean adrcertificaat;
     private Boolean medischattest;
     private String tankkaartnr;
     private String tachograafnr;
     private int tachograaftot;
     private String taalnaam;
     private int gebruikersid;
     private String gebruikersnaam;
     private String paswoord;
     private String paswoord2;
     private boolean admin;
     private String name;
     private int id;
     
     public WerknemerView(){};
     
    public WerknemerView(int werknemerid, int taalid, String naam, String voornaam, 
            Boolean actief, int adresid, int contactid, Character geslacht, String statuut, 
            Date datuminschrijving, Date datumuitschrijving, String functie, int rijbewijsid, 
            int infoid, String postcode, String straat, short nummer, String bus, int land, 
            String email, String telefoon, String gsm, String fax, String rijksregisternr, 
            String siskaart, String identiteitsnr, String pensioennr, String geboorteplaats, 
            Date geboortedatum, String iban, String bic, String burgerstand, int aantalkinderen, 
            String rijbewijsnr, String rijbewijscat, Date geldigtot, Boolean adrcertificaat, Boolean medischattest, 
            String tankkaartnr, String tachograafnr, int tachograaftot, String taalnaam,
            int gebruikersid, String gebruikersnaam, String paswoord, String paswoord2, boolean admin) {
        this.werknemerid = werknemerid;
        this.taalid = taalid;
        this.naam = naam;
        this.voornaam = voornaam;
        this.actief = actief;
        this.adresid = adresid;
        this.contactid = contactid;
        this.geslacht = geslacht;
        this.statuut = statuut;
        this.datuminschrijving = datuminschrijving;
        this.datumuitschrijving = datumuitschrijving;
        this.functie = functie;
        this.rijbewijsid = rijbewijsid;
        this.infoid = infoid;
        this.postcode = postcode;
        this.straat = straat;
        this.nummer = nummer;
        this.bus = bus;
        this.land = land;
        this.email = email;
        this.telefoon = telefoon;
        this.gsm = gsm;
        this.fax = fax;
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
        this.rijbewijsnr = rijbewijsnr;
        this.rijbewijscat = rijbewijscat;
        this.geldigtot = geldigtot;
        this.adrcertificaat = adrcertificaat;
        this.medischattest = medischattest;
        this.tankkaartnr = tankkaartnr;
        this.tachograafnr = tachograafnr;
        this.tachograaftot = tachograaftot;
        this.taalnaam = taalnaam;
        this.gebruikersid = gebruikersid;
        this.gebruikersnaam = gebruikersnaam;
        this.paswoord = paswoord;
        this.paswoord2 = paswoord2;
        this.admin = admin;
        this.name = voornaam;
        this.id = werknemerid;
    }

    public WerknemerView(String naam, String voornaam, Boolean actief, Character geslacht, 
            String statuut, Date datuminschrijving, Date datumuitschrijving, String functie, 
            String postcode, String straat, short nummer, String bus, int land, String email, 
            String telefoon, String gsm, String fax, String rijksregisternr, String siskaart, 
            String identiteitsnr, String pensioennr, String geboorteplaats, Date geboortedatum, 
            String iban, String bic, String burgerstand, int aantalkinderen, String rijbewijsnr, 
            String rijbewijscat, Date geldigtot, Boolean adrcertificaat, Boolean medischattest, 
            String tankkaartnr, String tachograafnr, int tachograaftot, String taalnaam,
            int gebruikersid, String gebruikersnaam, String paswoord, String paswoord2, boolean admin) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.actief = actief;
        this.geslacht = geslacht;
        this.statuut = statuut;
        this.datuminschrijving = datuminschrijving;
        this.datumuitschrijving = datumuitschrijving;
        this.functie = functie;
        this.postcode = postcode;
        this.straat = straat;
        this.nummer = nummer;
        this.bus = bus;
        this.land = land;
        this.email = email;
        this.telefoon = telefoon;
        this.gsm = gsm;
        this.fax = fax;
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
        this.rijbewijsnr = rijbewijsnr;
        this.rijbewijscat = rijbewijscat;
        this.geldigtot = geldigtot;
        this.adrcertificaat = adrcertificaat;
        this.medischattest = medischattest;
        this.tankkaartnr = tankkaartnr;
        this.tachograafnr = tachograafnr;
        this.tachograaftot = tachograaftot;
        this.taalnaam = taalnaam;
        this.gebruikersid = gebruikersid;
        this.gebruikersnaam = gebruikersnaam;
        this.paswoord = paswoord;
        this.paswoord2 = paswoord2;
        this.admin = admin;
        this.name = voornaam;
        this.id = werknemerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getGebruikersid() {
        return gebruikersid;
    }

    public void setGebruikersid(int gebruikersid) {
        this.gebruikersid = gebruikersid;
    }
    
    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

     
     
    public int getWerknemerid() {
        return werknemerid;
    }

    public void setWerknemerid(int werknemerid) {
        this.werknemerid = werknemerid;
    }

    public int getTaalid() {
        return taalid;
    }

    public void setTaalid(int taalid) {
        this.taalid = taalid;
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

    public Boolean getActief() {
        return actief;
    }

    public void setActief(Boolean actief) {
        this.actief = actief;
    }

    public int getAdresid() {
        return adresid;
    }

    public void setAdresid(int adresid) {
        this.adresid = adresid;
    }

    public int getContactid() {
        return contactid;
    }

    public void setContactid(int contactid) {
        this.contactid = contactid;
    }

    public Character getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Character geslacht) {
        this.geslacht = geslacht;
    }

    public String getStatuut() {
        return statuut;
    }

    public void setStatuut(String statuut) {
        this.statuut = statuut;
    }

    public Date getDatuminschrijving() {
        return datuminschrijving;
    }

    public void setDatuminschrijving(Date datuminschrijving) {
        this.datuminschrijving = datuminschrijving;
    }

    public Date getDatumuitschrijving() {
        return datumuitschrijving;
    }

    public void setDatumuitschrijving(Date datumuitschrijving) {
        this.datumuitschrijving = datumuitschrijving;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public int getRijbewijsid() {
        return rijbewijsid;
    }

    public void setRijbewijsid(int rijbewijsid) {
        this.rijbewijsid = rijbewijsid;
    }

    public int getInfoid() {
        return infoid;
    }

    public void setInfoid(int infoid) {
        this.infoid = infoid;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    public String getRijksregisternr() {
        return rijksregisternr;
    }

    public void setRijksregisternr(String rijksregisternr) {
        this.rijksregisternr = rijksregisternr;
    }

    public String getSiskaart() {
        return siskaart;
    }

    public void setSiskaart(String siskaart) {
        this.siskaart = siskaart;
    }

    public String getIdentiteitsnr() {
        return identiteitsnr;
    }

    public void setIdentiteitsnr(String identiteitsnr) {
        this.identiteitsnr = identiteitsnr;
    }

    public String getPensioennr() {
        return pensioennr;
    }

    public void setPensioennr(String pensioennr) {
        this.pensioennr = pensioennr;
    }

    public String getGeboorteplaats() {
        return geboorteplaats;
    }

    public void setGeboorteplaats(String geboorteplaats) {
        this.geboorteplaats = geboorteplaats;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
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

    public String getBurgerstand() {
        return burgerstand;
    }

    public void setBurgerstand(String burgerstand) {
        this.burgerstand = burgerstand;
    }

    public int getAantalkinderen() {
        return aantalkinderen;
    }

    public void setAantalkinderen(int aantalkinderen) {
        this.aantalkinderen = aantalkinderen;
    }

    public String getRijbewijsnr() {
        return rijbewijsnr;
    }

    public void setRijbewijsnr(String rijbewijsnr) {
        this.rijbewijsnr = rijbewijsnr;
    }

    public String getRijbewijscat() {
        return rijbewijscat;
    }

    public void setRijbewijscat(String rijbewijscat) {
        this.rijbewijscat = rijbewijscat;
    }

    public Date getGeldigtot() {
        return geldigtot;
    }

    public void setGeldigtot(Date geldigtot) {
        this.geldigtot = geldigtot;
    }

    public Boolean getAdrcertificaat() {
        return adrcertificaat;
    }

    public void setAdrcertificaat(Boolean adrcertificaat) {
        this.adrcertificaat = adrcertificaat;
    }

    public Boolean getMedischattest() {
        return medischattest;
    }

    public void setMedischattest(Boolean medischattest) {
        this.medischattest = medischattest;
    }

    public String getTankkaartnr() {
        return tankkaartnr;
    }

    public void setTankkaartnr(String tankkaartnr) {
        this.tankkaartnr = tankkaartnr;
    }

    public String getTachograafnr() {
        return tachograafnr;
    }

    public void setTachograafnr(String tachograafnr) {
        this.tachograafnr = tachograafnr;
    }

    public int getTachograaftot() {
        return tachograaftot;
    }

    public void setTachograaftot(int tachograaftot) {
        this.tachograaftot = tachograaftot;
    }

    public String getTaalnaam() {
        return taalnaam;
    }

    public void setTaalnaam(String taalnaam) {
        this.taalnaam = taalnaam;
    }

    public String getPaswoord2() {
        return paswoord2;
    }

    public void setPaswoord2(String paswoord2) {
        this.paswoord2 = paswoord2;
    }
     
     
}
