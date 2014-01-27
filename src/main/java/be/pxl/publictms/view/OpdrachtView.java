/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.view;

import java.util.Date;

/**
 *
 * @author 11302785
 */
public class OpdrachtView {
    private int Id;
    private int klantId;
    private String klantNaam;
    private String klantVoorNaam;
    private String bedrijf;
    private Date datum;
    private Date starttijd;
    private Date eindtijd;
    private int werknemerId;
    private String werknemerNaam;
    private String werknemerVoornaam;
    private String title;
    private String voertuig;
    private String oplegger;
    private boolean opdrachtklaar;
    private String vrijveld;

    public OpdrachtView(){}
    
    public OpdrachtView(int klantId, String klantNaam, String klantVoorNaam, String bedrijf, Date datum, Date starttijd, Date eindtijd, int werknemerId, String werknemerNaam, String werknemerVoornaam, String title, String voertuig, String oplegger, boolean opdrachtklaar, String vrijveld) {
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
        this.title = title;
        this.voertuig = voertuig;
        this.oplegger = oplegger;
        this.opdrachtklaar = opdrachtklaar;
        this.vrijveld = vrijveld;
    }
    
    public OpdrachtView(int Id, int klantId, String klantNaam, String klantVoorNaam, String bedrijf, Date datum, Date starttijd, Date eindtijd, int werknemerId, String werknemerNaam, String werknemerVoornaam, String title, String voertuig, String oplegger, boolean opdrachtklaar, String vrijveld) {
        this.Id = Id;
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
        this.title = title;
        this.voertuig = voertuig;
        this.oplegger = oplegger;
        this.opdrachtklaar = opdrachtklaar;
        this.vrijveld = vrijveld;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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

    public String getKlantVoorNaam() {
        return klantVoorNaam;
    }

    public void setKlantVoorNaam(String klantVoorNaam) {
        this.klantVoorNaam = klantVoorNaam;
    }

    public String getBedrijf() {
        return bedrijf;
    }

    public void setBedrijf(String bedrijf) {
        this.bedrijf = bedrijf;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Date getStarttijd() {
        return starttijd;
    }

    public void setStarttijd(Date starttijd) {
        this.starttijd = starttijd;
    }

    public Date getEindtijd() {
        return eindtijd;
    }

    public void setEindtijd(Date eindtijd) {
        this.eindtijd = eindtijd;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVoertuig() {
        return voertuig;
    }

    public void setVoertuig(String voertuig) {
        this.voertuig = voertuig;
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
