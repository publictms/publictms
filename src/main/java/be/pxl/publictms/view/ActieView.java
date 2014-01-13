/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.view;


/**
 * Een model van acties zodat men een mooi overzicht krijgt zonder dat men een 
 * hoop indexen ziet maar de werkelijke waarde ervan alsook extra's.
 * @author Laurens Putseys
 */
public class ActieView {
    private Object actieid;
    private Object naam;
    private Object straat;
    private Object nummer;
    private Object bus;
    private Object land;
    private Object postcode;
    private Object email;
    private Object telefoon;
    private Object gsm;
    private Object fax;
    private Object taalNaam;
    private Object transportStatus;
    private Object soortAdres;
    private Object vensterUren;
    private Object vrachtBeperking;
    private Object chauffeurBeperking;
    private Object transportOpmerking;
    private Object actieklaar;
    private Object lading;
    private Object actieOpmerking;
    private Object opdrachtid;

    public ActieView(Object actieid, Object naam, Object straat, Object nummer, Object bus, Object land, Object postcode, Object email, Object telefoon, Object gsm, Object fax, Object taalNaam, Object transportStatus, Object soortAdres, Object vensterUren, Object vrachtBeperking, Object chauffeurBeperking, Object transportOpmerking, Object actieklaar, Object lading, Object actieOpmerking, Object opdrachtid) {
        this.actieid = actieid;
        this.naam = naam;
        this.straat = straat;
        this.nummer = nummer;
        this.bus = bus;
        this.land = land;
        this.postcode = postcode;
        this.email = email;
        this.telefoon = telefoon;
        this.gsm = gsm;
        this.fax = fax;
        this.taalNaam = taalNaam;
        this.transportStatus = transportStatus;
        this.soortAdres = soortAdres;
        this.vensterUren = vensterUren;
        this.vrachtBeperking = vrachtBeperking;
        this.chauffeurBeperking = chauffeurBeperking;
        this.transportOpmerking = transportOpmerking;
        this.actieklaar = actieklaar;
        this.lading = lading;
        this.actieOpmerking = actieOpmerking;
        this.opdrachtid = opdrachtid;
    }

    public Object getActieid() {
        return actieid;
    }

    public void setActieid(Object actieid) {
        this.actieid = actieid;
    }

    public Object getNaam() {
        return naam;
    }

    public void setNaam(Object naam) {
        this.naam = naam;
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

    public Object getTransportStatus() {
        return transportStatus;
    }

    public void setTransportStatus(Object transportStatus) {
        this.transportStatus = transportStatus;
    }

    public Object getSoortAdres() {
        return soortAdres;
    }

    public void setSoortAdres(Object soortAdres) {
        this.soortAdres = soortAdres;
    }

    public Object getVensterUren() {
        return vensterUren;
    }

    public void setVensterUren(Object vensterUren) {
        this.vensterUren = vensterUren;
    }

    public Object getVrachtBeperking() {
        return vrachtBeperking;
    }

    public void setVrachtBeperking(Object vrachtBeperking) {
        this.vrachtBeperking = vrachtBeperking;
    }

    public Object getChauffeurBeperking() {
        return chauffeurBeperking;
    }

    public void setChauffeurBeperking(Object chauffeurBeperking) {
        this.chauffeurBeperking = chauffeurBeperking;
    }

    public Object getTransportOpmerking() {
        return transportOpmerking;
    }

    public void setTransportOpmerking(Object transportOpmerking) {
        this.transportOpmerking = transportOpmerking;
    }

    public Object getActieklaar() {
        return actieklaar;
    }

    public void setActieklaar(Object actieklaar) {
        this.actieklaar = actieklaar;
    }

    public Object getLading() {
        return lading;
    }

    public void setLading(Object lading) {
        this.lading = lading;
    }

    public Object getActieOpmerking() {
        return actieOpmerking;
    }

    public void setActieOpmerking(Object actieOpmerking) {
        this.actieOpmerking = actieOpmerking;
    }

    public Object getOpdrachtid() {
        return opdrachtid;
    }

    public void setOpdrachtid(Object opdrachtid) {
        this.opdrachtid = opdrachtid;
    }
    
}
