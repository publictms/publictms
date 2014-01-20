
package be.pxl.publictms.view;


public class WerknemerView {
    
    private Object actief;
    private Object werknemerid;
     private Object naam;
     private Object voornaam;
     private Object geslacht;
     private Object statuut;
     private Object datuminschrijving;
     private Object datumuitschrijving;
     private Object functie;
     private Object taalid;
     private Object taalnaam;
     private Object adresid;
     private Object postcode;
     private Object straat;
     private Object nummer;
     private Object bus;
     private Object land;
     private Object contactid;
     private Object email;
     private Object telefoon;
     private Object gsm;
     private Object fax;
     private Object rijbewijsid;
     private Object rijbewijsnr;
     private Object rijbewijscat;
     private Object geldigtot;
     private Object adrcertificaat;
     private Object medischattest;
     private Object tankkaartnr;
     private Object tachograafnr;
     private Object tachograaftot;
     private Object infoid;
     private Object rijksregisternr;
     private Object siskaart;
     private Object identiteitsnr;
     private Object pensioennr;
     private Object geboorteplaats;
     private Object geboortedatum;
     private Object iban;
     private Object bic;
     private Object burgerstand;
     private Object aantalkinderen;
     
     public WerknemerView(){}
     
    public WerknemerView(Object actief, Object werknemerid, Object naam, Object voornaam, Object geslacht, Object statuut, Object datuminschrijving, Object datumuitschrijving, Object functie, Object taalid, Object taalnaam, Object adresid, Object postcode, Object straat, Object nummer, Object bus, Object land, Object contactid, Object email, Object telefoon, Object gsm, Object fax, Object rijbewijsid, Object rijbewijsnr, Object rijbewijscat, Object geldigtot, Object adrcertificaat, Object medischattest, Object tankkaartnr, Object tachograafnr, Object tachograaftot, Object infoid, Object rijksregisternr, Object siskaart, Object identiteitsnr, Object pensioennr, Object geboorteplaats, Object geboortedatum, Object iban, Object bic, Object burgerstand, Object aantalkinderen) {
        this.actief = actief;
        this.werknemerid = werknemerid;
        this.naam = naam;
        this.voornaam = voornaam;
        this.geslacht = geslacht;
        this.statuut = statuut;
        this.datuminschrijving = datuminschrijving;
        this.datumuitschrijving = datumuitschrijving;
        this.functie = functie;
        this.taalid = taalid;
        this.taalnaam = taalnaam;
        this.adresid = adresid;
        this.postcode = postcode;
        this.straat = straat;
        this.nummer = nummer;
        this.bus = bus;
        this.land = land;
        this.contactid = contactid;
        this.email = email;
        this.telefoon = telefoon;
        this.gsm = gsm;
        this.fax = fax;
        this.rijbewijsid = rijbewijsid;
        this.rijbewijsnr = rijbewijsnr;
        this.rijbewijscat = rijbewijscat;
        this.geldigtot = geldigtot;
        this.adrcertificaat = adrcertificaat;
        this.medischattest = medischattest;
        this.tankkaartnr = tankkaartnr;
        this.tachograafnr = tachograafnr;
        this.tachograaftot = tachograaftot;
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
    
    public WerknemerView(Object actief, Object naam, Object voornaam, Character geslacht, Object statuut, Object datuminschrijving, Object datumuitschrijving, Object functie, Object taalnaam, Object postcode, Object straat, Object nummer, Object bus, Object land, Object email, Object telefoon, Object gsm, Object fax, Object rijbewijsnr, Object rijbewijscat, Object geldigtot, Object adrcertificaat, Object medischattest, Object tankkaartnr, Object tachograafnr, Object tachograaftot, Object rijksregisternr, Object siskaart, Object identiteitsnr, Object pensioennr, Object geboorteplaats, Object geboortedatum, Object iban, Object bic, Object burgerstand, Object aantalkinderen) {
        this.actief = actief;
        this.naam = naam;
        this.voornaam = voornaam;
        this.geslacht = geslacht;
        this.statuut = statuut;
        this.datuminschrijving = datuminschrijving;
        this.datumuitschrijving = datumuitschrijving;
        this.functie = functie;
        this.taalnaam = taalnaam;
        this.postcode = postcode;
        this.straat = straat;
        this.nummer = nummer;
        this.bus = bus;
        this.land = land;
        this.email = email;
        this.telefoon = telefoon;
        this.gsm = gsm;
        this.fax = fax;
        this.rijbewijsnr = rijbewijsnr;
        this.rijbewijscat = rijbewijscat;
        this.geldigtot = geldigtot;
        this.adrcertificaat = adrcertificaat;
        this.medischattest = medischattest;
        this.tankkaartnr = tankkaartnr;
        this.tachograafnr = tachograafnr;
        this.tachograaftot = tachograaftot;
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
    
    public Object getActief() {
        return actief;
    }

    public void setActief(Object actief) {
        this.actief = actief;
    }

    public Object getWerknemerid() {
        return werknemerid;
    }

    public void setWerknemerid(Object werknemerid) {
        this.werknemerid = werknemerid;
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

    public Object getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Character geslacht) {
        this.geslacht = geslacht;
    }

    public Object getStatuut() {
        return statuut;
    }

    public void setStatuut(Object statuut) {
        this.statuut = statuut;
    }

    public Object getDatuminschrijving() {
        return datuminschrijving;
    }

    public void setDatuminschrijving(Object datuminschrijving) {
        this.datuminschrijving = datuminschrijving;
    }

    public Object getDatumuitschrijving() {
        return datumuitschrijving;
    }

    public void setDatumuitschrijving(Object datumuitschrijving) {
        this.datumuitschrijving = datumuitschrijving;
    }

    public Object getFunctie() {
        return functie;
    }

    public void setFunctie(Object functie) {
        this.functie = functie;
    }

    public Object getTaalnaam() {
        return taalnaam;
    }

    public void setTaalnaam(Object taalnaam) {
        this.taalnaam = taalnaam;
    }

    public Object getAdresid() {
        return adresid;
    }

    public void setAdresid(Object adresid) {
        this.adresid = adresid;
    }

    public Object getPostcode() {
        return postcode;
    }

    public void setPostcode(Object postcode) {
        this.postcode = postcode;
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

    public Object getContactid() {
        return contactid;
    }

    public void setContactid(Object contactid) {
        this.contactid = contactid;
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

    public Object getRijbewijsid() {
        return rijbewijsid;
    }

    public void setRijbewijsid(Object rijbewijsid) {
        this.rijbewijsid = rijbewijsid;
    }

    public Object getRijbewijsnr() {
        return rijbewijsnr;
    }

    public void setRijbewijsnr(Object rijbewijsnr) {
        this.rijbewijsnr = rijbewijsnr;
    }

    public Object getRijbewijscat() {
        return rijbewijscat;
    }

    public void setRijbewijscat(Object rijbewijscat) {
        this.rijbewijscat = rijbewijscat;
    }

    public Object getGeldigtot() {
        return geldigtot;
    }

    public void setGeldigtot(Object geldigtot) {
        this.geldigtot = geldigtot;
    }

    public Object getAdrcertificaat() {
        return adrcertificaat;
    }

    public void setAdrcertificaat(Object adrcertificaat) {
        this.adrcertificaat = adrcertificaat;
    }

    public Object getMedischattest() {
        return medischattest;
    }

    public void setMedischattest(Object medischattest) {
        this.medischattest = medischattest;
    }

    public Object getTankkaartnr() {
        return tankkaartnr;
    }

    public void setTankkaartnr(Object tankkaartnr) {
        this.tankkaartnr = tankkaartnr;
    }

    public Object getTachograafnr() {
        return tachograafnr;
    }

    public void setTachograafnr(Object tachograafnr) {
        this.tachograafnr = tachograafnr;
    }

    public Object getTachograaftot() {
        return tachograaftot;
    }

    public void setTachograaftot(Object tachograaftot) {
        this.tachograaftot = tachograaftot;
    }

    public Object getInfoid() {
        return infoid;
    }

    public void setInfoid(Object infoid) {
        this.infoid = infoid;
    }

    public Object getRijksregisternr() {
        return rijksregisternr;
    }

    public void setRijksregisternr(Object rijksregisternr) {
        this.rijksregisternr = rijksregisternr;
    }

    public Object getSiskaart() {
        return siskaart;
    }

    public void setSiskaart(Object siskaart) {
        this.siskaart = siskaart;
    }

    public Object getIdentiteitsnr() {
        return identiteitsnr;
    }

    public void setIdentiteitsnr(Object identiteitsnr) {
        this.identiteitsnr = identiteitsnr;
    }

    public Object getPensioennr() {
        return pensioennr;
    }

    public void setPensioennr(Object pensioennr) {
        this.pensioennr = pensioennr;
    }

    public Object getGeboorteplaats() {
        return geboorteplaats;
    }

    public void setGeboorteplaats(Object geboorteplaats) {
        this.geboorteplaats = geboorteplaats;
    }

    public Object getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Object geboortedatum) {
        this.geboortedatum = geboortedatum;
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

    public Object getBurgerstand() {
        return burgerstand;
    }

    public void setBurgerstand(Object burgerstand) {
        this.burgerstand = burgerstand;
    }

    public Object getAantalkinderen() {
        return aantalkinderen;
    }

    public void setAantalkinderen(Object aantalkinderen) {
        this.aantalkinderen = aantalkinderen;
    }
    
    public Object getTaalid() {
        return taalid;
    }

    public void setTaalid(Object taalid) {
        this.taalid = taalid;
    }
}
