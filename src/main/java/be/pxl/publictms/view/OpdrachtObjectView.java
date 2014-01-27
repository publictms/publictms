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
public class OpdrachtObjectView {
    private Object Id;
    private Object klantId;
    private Object klantNaam;
    private Object klantVoorNaam;
    private Object bedrijf;
    private Object datum;
    private Object starttijd;
    private Object eindtijd;
    private Object werknemerId;
    private Object werknemerNaam;
    private Object werknemerVoornaam;
    private Object title;
    private Object voertuig;
    private Object oplegger;
    private Object opdrachtklaar;
    private Object vrijveld;

    public OpdrachtObjectView(Object opdrachtid,Object klantId, Object klantNaam, Object klantVoorNaam, Object bedrijf, Object datum, Object starttijd, Object eindtijd, Object werknemerId, Object werknemerNaam, Object werknemerVoornaam, Object voertuig, Object oplegger, Object opdrachtklaar, Object vrijveld) {
        this.Id = opdrachtid;
        this.klantId = klantId;
        this.klantNaam = klantNaam;
        this.klantVoorNaam = klantVoorNaam;
        this.bedrijf = bedrijf;
        this.datum = datum;
        this.starttijd = starttijd;
        this.eindtijd = eindtijd;
        this.werknemerId = werknemerId;
        this.werknemerNaam = werknemerNaam;
        this.werknemerVoornaam = werknemerVoornaam;
        this.voertuig = voertuig;
        this.oplegger = oplegger;
        this.opdrachtklaar = opdrachtklaar;
        this.vrijveld = vrijveld;
        this.title = werknemerNaam + " " + werknemerVoornaam;
    }

    public Object getStarttijd() {
        return starttijd;
    }

    public void setStarttijd(Object starttijd) {
        this.starttijd = starttijd;
    }

    public Object getEindtijd() {
        return eindtijd;
    }

    public void setEindtijd(Object eindtijd) {
        this.eindtijd = eindtijd;
    }
    
    public Object getId() {
        return Id;
    }

    public void setId(Object Id) {
        this.Id = Id;
    }

    public Object getKlantId() {
        return klantId;
    }

    public void setKlantId(Object klantId) {
        this.klantId = klantId;
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

    public Object getWerknemerId() {
        return werknemerId;
    }

    public void setWerknemerId(Object werknemerId) {
        this.werknemerId = werknemerId;
    }

    public Object getWerknemerNaam() {
        return werknemerNaam;
    }

    public void setWerknemerNaam(Object werknemerNaam) {
        this.werknemerNaam = werknemerNaam;
    }

    public Object getWerknemerVoornaam() {
        return werknemerVoornaam;
    }

    public void setWerknemerVoornaam(Object werknemerVoornaam) {
        this.werknemerVoornaam = werknemerVoornaam;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
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
