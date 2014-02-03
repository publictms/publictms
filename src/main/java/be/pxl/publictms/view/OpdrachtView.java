/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.view;


/**
 *
 * @author 11302785
 */
public class OpdrachtView {
    private int Id;
    private int klantId;
    private String klantNaam;
    private String klantVoornaam;
    private String bedrijf;
    private int werknemerId;
    private String werknemerNaam;
    private String werknemerVoornaam;
    private int voertuigid;
    private String voertuig;
    private int opleggerid;
    private String oplegger;
    private boolean opdrachtklaar;
    private String vrijveld;

    public OpdrachtView(){}

    public OpdrachtView(int klantId, String klantNaam, String klantVoornaam, String bedrijf, int werknemerId, String werknemerNaam, String werknemerVoornaam, int voertuigid, String voertuig, int opleggerid, String oplegger, boolean opdrachtklaar, String vrijveld, int resource) {
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
    
    public OpdrachtView(int opdrachtid, int klantId, String klantNaam, String klantVoornaam, String bedrijf, int werknemerId, String werknemerNaam, String werknemerVoornaam, int voertuigid, String voertuig, int opleggerid, String oplegger, boolean opdrachtklaar, String vrijveld) {
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

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }
    

    public int getKlantId() {
        return klantId;
    }

    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }

    public String getKlantNaam() {
        return klantNaam;
    }

    public void setKlantNaam(String klantNaam) {
        this.klantNaam = klantNaam;
    }

    public String getKlantVoornaam() {
        return klantVoornaam;
    }

    public void setKlantVoornaam(String klantVoornaam) {
        this.klantVoornaam = klantVoornaam;
    }

    public String getBedrijf() {
        return bedrijf;
    }

    public void setBedrijf(String bedrijf) {
        this.bedrijf = bedrijf;
    }

    public int getWerknemerId() {
        return werknemerId;
    }

    public void setWerknemerId(int werknemerId) {
        this.werknemerId = werknemerId;
    }

    public String getWerknemerNaam() {
        return werknemerNaam;
    }

    public void setWerknemerNaam(String werknemerNaam) {
        this.werknemerNaam = werknemerNaam;
    }

    public String getWerknemerVoornaam() {
        return werknemerVoornaam;
    }

    public void setWerknemerVoornaam(String werknemerVoornaam) {
        this.werknemerVoornaam = werknemerVoornaam;
    }

    public int getVoertuigid() {
        return voertuigid;
    }

    public void setVoertuigid(int voertuigid) {
        this.voertuigid = voertuigid;
    }

    public String getVoertuig() {
        return voertuig;
    }

    public void setVoertuig(String voertuig) {
        this.voertuig = voertuig;
    }

    public int getOpleggerid() {
        return opleggerid;
    }

    public void setOpleggerid(int opleggerid) {
        this.opleggerid = opleggerid;
    }

    public String getOplegger() {
        return oplegger;
    }

    public void setOplegger(String oplegger) {
        this.oplegger = oplegger;
    }

    public boolean isOpdrachtklaar() {
        return opdrachtklaar;
    }

    public void setOpdrachtklaar(boolean opdrachtklaar) {
        this.opdrachtklaar = opdrachtklaar;
    }

    public String getVrijveld() {
        return vrijveld;
    }

    public void setVrijveld(String vrijveld) {
        this.vrijveld = vrijveld;
    }  
}
