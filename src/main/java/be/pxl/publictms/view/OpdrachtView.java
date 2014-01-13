/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.view;

/**
 * Een model van opdrahten zodat men een mooi overzicht krijgt zonder dat men een 
 * hoop indexen ziet maar de werkelijke waarde ervan alsook extra's.
 * @author Laurens Putseys
 */
public class OpdrachtView {
    private Object opdrachtid;
    private Object klantNaam;
    private Object klantVoorNaam;
    private Object bedrijf;
    private Object datum;
    private Object werkenemerNaam;
    private Object werknemerVoornaam;
    private Object voertuig;
    private Object oplegger;
    private Object opdrachtklaar;
    private Object vrijveld;

    public OpdrachtView(Object opdrachtid, Object klantNaam, Object klantVoorNaam, Object bedrijf, Object datum, Object werkenemerNaam, Object werknemerVoornaam, Object voertuig, Object oplegger, Object opdrachtklaar, Object vrijveld) {
        this.opdrachtid = opdrachtid;
        this.klantNaam = klantNaam;
        this.klantVoorNaam = klantVoorNaam;
        this.bedrijf = bedrijf;
        this.datum = datum;
        this.werkenemerNaam = werkenemerNaam;
        this.werknemerVoornaam = werknemerVoornaam;
        this.voertuig = voertuig;
        this.oplegger = oplegger;
        this.opdrachtklaar = opdrachtklaar;
        this.vrijveld = vrijveld;
    }

    public Object getOpdrachtid() {
        return opdrachtid;
    }

    public void setOpdrachtid(Object opdrachtid) {
        this.opdrachtid = opdrachtid;
    }

    public Object getKlantNaam() {
        return klantNaam;
    }

    public void setKlantNaam(Object klantNaam) {
        this.klantNaam = klantNaam;
    }

    public Object getKlantVoorNaam() {
        return klantVoorNaam;
    }

    public void setKlantVoorNaam(Object klantVoorNaam) {
        this.klantVoorNaam = klantVoorNaam;
    }

    public Object getBedrijf() {
        return bedrijf;
    }

    public void setBedrijf(Object bedrijf) {
        this.bedrijf = bedrijf;
    }

    public Object getDatum() {
        return datum;
    }

    public void setDatum(Object datum) {
        this.datum = datum;
    }

    public Object getWerkenemerNaam() {
        return werkenemerNaam;
    }

    public void setWerkenemerNaam(Object werkenemerNaam) {
        this.werkenemerNaam = werkenemerNaam;
    }

    public Object getWerknemerVoornaam() {
        return werknemerVoornaam;
    }

    public void setWerknemerVoornaam(Object werknemerVoornaam) {
        this.werknemerVoornaam = werknemerVoornaam;
    }

    public Object getVoertuig() {
        return voertuig;
    }

    public void setVoertuig(Object voertuig) {
        this.voertuig = voertuig;
    }

    public Object getOplegger() {
        return oplegger;
    }

    public void setOplegger(Object oplegger) {
        this.oplegger = oplegger;
    }

    public Object getOpdrachtklaar() {
        return opdrachtklaar;
    }

    public void setOpdrachtklaar(Object opdrachtklaar) {
        this.opdrachtklaar = opdrachtklaar;
    }

    public Object getVrijveld() {
        return vrijveld;
    }

    public void setVrijveld(Object vrijveld) {
        this.vrijveld = vrijveld;
    } 
}
