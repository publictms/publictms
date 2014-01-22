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
    private Object opdrachtId;
    private Object Id;
    private Object klantId;
    private Object klantNaam;
    private Object klantVoornaam;
    private Object bedrijf;
    private Object datum;
    private Object start;
    private Object werknemerId;
    private Object werknemerNaam;
    private Object werknemerVoornaam;
    private Object title;
    private Object voertuig;
    private Object oplegger;
    private Object opdrachtklaar;
    private Object vrijveld;

    public OpdrachtView(Object opdrachtid,Object klantId, Object klantNaam, Object klantVoornaam, Object bedrijf, Object datum, Object werknemerId, Object werknemerNaam, Object werknemerVoornaam, Object voertuig, Object oplegger, Object opdrachtklaar, Object vrijveld) {
        this.opdrachtId = opdrachtid;
        this.Id = opdrachtid;
        this.klantId = klantId;
        this.klantNaam = klantNaam;
        this.klantVoornaam = klantVoornaam;
        this.bedrijf = bedrijf;
        this.datum = datum;
        this.start = datum;
        this.werknemerId = werknemerId;
        this.werknemerNaam = werknemerNaam;
        this.werknemerVoornaam = werknemerVoornaam;
        this.voertuig = voertuig;
        this.oplegger = oplegger;
        this.opdrachtklaar = opdrachtklaar;
        this.vrijveld = vrijveld;
        this.title = werknemerNaam + " " + werknemerVoornaam;
    }

    public Object getOpdrachtId() {
        return opdrachtId;
    }

    public void setOpdrachtId(Object opdrachtId) {
        this.opdrachtId = opdrachtId;
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

    public Object getKlantVoornaam() {
        return klantVoornaam;
    }

    public void setKlantVoornaam(Object klantVoornaam) {
        this.klantVoornaam = klantVoornaam;
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

    public Object getStart() {
        return start;
    }

    public void setStart(Object start) {
        this.start = start;
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
