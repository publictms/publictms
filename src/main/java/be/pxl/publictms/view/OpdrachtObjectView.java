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
    private Object klantVoornaam;
    private Object bedrijf;
    private Object werknemerId;
    private Object werknemerNaam;
    private Object werknemerVoornaam;
    private Object voertuigid;
    private Object voertuig;
    private Object opleggerid;
    private Object oplegger;
    private Object opdrachtklaar;
    private Object vrijveld;

    public OpdrachtObjectView(Object opdrachtid,Object klantId, Object klantNaam, Object klantVoornaam, Object bedrijf, Object werknemerId, Object werknemerNaam, Object werknemerVoornaam,Object voertuigid, Object voertuig,Object opleggerid, Object oplegger, Object opdrachtklaar, Object vrijveld) {
        this.Id = opdrachtid;
        this.klantId = klantId;
        this.klantNaam = klantNaam;
        this.klantVoornaam = klantVoornaam;
        this.bedrijf = bedrijf;
        this.werknemerId = werknemerId;
        this.werknemerNaam = werknemerNaam;
        this.werknemerVoornaam = werknemerVoornaam;
        this.voertuigid = voertuigid;
        this.voertuig = voertuig;
        this.opleggerid = opleggerid;
        this.oplegger = oplegger;
        this.opdrachtklaar = opdrachtklaar;
        this.vrijveld = vrijveld;
    }

    public Object getVoertuigid() {
        return voertuigid;
    }

    public void setVoertuigid(Object voertuigid) {
        this.voertuigid = voertuigid;
    }

    public Object getOpleggerid() {
        return opleggerid;
    }

    public void setOpleggerid(Object opleggerid) {
        this.opleggerid = opleggerid;
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

    /*public Object getStart() {
        SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return DATE_FORMAT.format(this.start);
        //return start;
    }

    public void setStart(Object start) {
        this.start = start;
    }

    public Object getEnd() {
        SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return DATE_FORMAT.format(this.end);
    }

    public void setEnd(Object end) {
        this.end = end;
    }*/

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
