/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.view;

/**
 *
 * @author 11302785
 */
public class TransportView {
    private Object transportid;
    private Object adresid;
    private Object taalid;
    private Object contactid;
    private Object naam;
    private Object soortadres;
    private Object actief;
    private Object vensteruren;
    private Object vrachtbeperking;
    private Object chauffeursbeperking;
    private Object vrijveld;
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
    private Object taalNaam;

    public TransportView(){
        
    }
    
    public TransportView(Object naam, Object soortadres,Object actief, Object vensteruren, Object vrachtbeperking, Object chauffeursbeperking, Object vrijveld, Object straat, Object nummer, Object bus, Object land, Object postcode, Object gemeente, Object email, Object telefoon, Object gsm, Object fax, Object taalNaam) {
        this.naam = naam;
        this.soortadres = soortadres;
        this.vensteruren = vensteruren;
        this.actief = actief;
        this.vrachtbeperking = vrachtbeperking;
        this.chauffeursbeperking = chauffeursbeperking;
        this.vrijveld = vrijveld;
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
        this.taalNaam = taalNaam;
    }
    
    public TransportView(Object transportid,Object adresid,Object contactid,Object taalid, Object naam, Object soortadres,Object actief, Object vensteruren, Object vrachtbeperking, Object chauffeursbeperking, Object vrijveld, Object straat, Object nummer, Object bus, Object land, Object postcode, Object gemeente, Object email, Object telefoon, Object gsm, Object fax, Object taalNaam) {
        this.transportid = transportid;
        this.adresid = adresid;
        this.contactid = contactid;
        this.taalid = taalid;
        this.naam = naam;
        this.soortadres = soortadres;
        this.actief = actief;
        this.vensteruren = vensteruren;
        this.vrachtbeperking = vrachtbeperking;
        this.chauffeursbeperking = chauffeursbeperking;
        this.vrijveld = vrijveld;
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
        this.taalNaam = taalNaam;
    }

    public Object getActief() {
        return actief;
    }

    public void setActief(Object actief) {
        this.actief = actief;
    }

    public Object getAdresid() {
        return adresid;
    }

    public void setAdresid(Object adresid) {
        this.adresid = adresid;
    }

    public Object getTaalid() {
        return taalid;
    }

    public void setTaalid(Object taalid) {
        this.taalid = taalid;
    }

    public Object getContactid() {
        return contactid;
    }

    public void setContactid(Object contactid) {
        this.contactid = contactid;
    }
    
    public Object getTransportid() {
        return transportid;
    }

    public void setTransportid(Object transportid) {
        this.transportid = transportid;
    }

    public Object getNaam() {
        return naam;
    }

    public void setNaam(Object naam) {
        this.naam = naam;
    }

    public Object getSoortadres() {
        return soortadres;
    }

    public void setSoortadres(Object soortadres) {
        this.soortadres = soortadres;
    }

    public Object getVensteruren() {
        return vensteruren;
    }

    public void setVensteruren(Object vensteruren) {
        this.vensteruren = vensteruren;
    }

    public Object getVrachtbeperking() {
        return vrachtbeperking;
    }

    public void setVrachtbeperking(Object vrachtbeperking) {
        this.vrachtbeperking = vrachtbeperking;
    }

    public Object getChauffeursbeperking() {
        return chauffeursbeperking;
    }

    public void setChauffeursbeperking(Object chauffeursbeperking) {
        this.chauffeursbeperking = chauffeursbeperking;
    }

    public Object getVrijveld() {
        return vrijveld;
    }

    public void setVrijveld(Object vrijveld) {
        this.vrijveld = vrijveld;
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

    public Object getTaalNaam() {
        return taalNaam;
    }

    public void setTaalNaam(Object taalNaam) {
        this.taalNaam = taalNaam;
    } 
}
