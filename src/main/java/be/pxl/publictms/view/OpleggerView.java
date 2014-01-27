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
public class OpleggerView {
    
    private int opleggerid;
    private int laadId;
    private String nummerplaat;
    private Boolean actief;
    private String omschrijving;
    private String type;
    private String bouwjaar;
    private Date inGebruik;
    private Date uitGebruik;
    private String chassisnr;
    private Boolean vergunning;
    private Date geldigTot;
    private String pvg;
    private Double tarragewicht;
    private Double laadvermogen;
    private Double laadvolume;
    private Double laadmeters;
    private Double lengte;
    private Double breedte;
    private Double hoogte;
    private int aantalAssen;
    private String motorNorm;

    public OpleggerView(){}
    
    public OpleggerView(int opleggerid, int laadId, String nummerplaat, Boolean actief, String omschrijving, String type, String bouwjaar, Date inGebruik, Date uitGebruik, String chassisnr, Boolean vergunning, Date geldigTot, String pvg, Double tarragewicht, Double laadvermogen, Double laadvolume, Double laadmeters, Double lengte, Double breedte, Double hoogte, int aantalAssen, String motorNorm) {
        this.opleggerid = opleggerid;
        this.laadId = laadId;
        this.nummerplaat = nummerplaat;
        this.actief = actief;
        this.omschrijving = omschrijving;
        this.type = type;
        this.bouwjaar = bouwjaar;
        this.inGebruik = inGebruik;
        this.uitGebruik = uitGebruik;
        this.chassisnr = chassisnr;
        this.vergunning = vergunning;
        this.geldigTot = geldigTot;
        this.pvg = pvg;
        this.tarragewicht = tarragewicht;
        this.laadvermogen = laadvermogen;
        this.laadvolume = laadvolume;
        this.laadmeters = laadmeters;
        this.lengte = lengte;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.aantalAssen = aantalAssen;
        this.motorNorm = motorNorm;
    }
    
    public OpleggerView(int laadId, String nummerplaat, Boolean actief, String omschrijving, String type, String bouwjaar, Date inGebruik, Date uitGebruik, String chassisnr, Boolean vergunning, Date geldigTot, String pvg, Double tarragewicht, Double laadvermogen, Double laadvolume, Double laadmeters, Double lengte, Double breedte, Double hoogte, int aantalAssen, String motorNorm) {
        this.laadId = laadId;
        this.nummerplaat = nummerplaat;
        this.actief = actief;
        this.omschrijving = omschrijving;
        this.type = type;
        this.bouwjaar = bouwjaar;
        this.inGebruik = inGebruik;
        this.uitGebruik = uitGebruik;
        this.chassisnr = chassisnr;
        this.vergunning = vergunning;
        this.geldigTot = geldigTot;
        this.pvg = pvg;
        this.tarragewicht = tarragewicht;
        this.laadvermogen = laadvermogen;
        this.laadvolume = laadvolume;
        this.laadmeters = laadmeters;
        this.lengte = lengte;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.aantalAssen = aantalAssen;
        this.motorNorm = motorNorm;
    }

    public int getOpleggerid() {
        return opleggerid;
    }

    public void setOpleggerid(int opleggerid) {
        this.opleggerid = opleggerid;
    }

    public int getLaadId() {
        return laadId;
    }

    public void setLaadId(int laadId) {
        this.laadId = laadId;
    }

    public String getNummerplaat() {
        return nummerplaat;
    }

    public void setNummerplaat(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }

    public Boolean getActief() {
        return actief;
    }

    public void setActief(Boolean actief) {
        this.actief = actief;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBouwjaar() {
        return bouwjaar;
    }

    public void setBouwjaar(String bouwjaar) {
        this.bouwjaar = bouwjaar;
    }

    public Date getInGebruik() {
        return inGebruik;
    }

    public void setInGebruik(Date inGebruik) {
        this.inGebruik = inGebruik;
    }

    public Date getUitGebruik() {
        return uitGebruik;
    }

    public void setUitGebruik(Date uitGebruik) {
        this.uitGebruik = uitGebruik;
    }

    public String getChassisnr() {
        return chassisnr;
    }

    public void setChassisnr(String chassisnr) {
        this.chassisnr = chassisnr;
    }

    public Boolean getVergunning() {
        return vergunning;
    }

    public void setVergunning(Boolean vergunning) {
        this.vergunning = vergunning;
    }

    public Date getGeldigTot() {
        return geldigTot;
    }

    public void setGeldigTot(Date geldigTot) {
        this.geldigTot = geldigTot;
    }

    public String getPvg() {
        return pvg;
    }

    public void setPvg(String pvg) {
        this.pvg = pvg;
    }

    public Double getTarragewicht() {
        return tarragewicht;
    }

    public void setTarragewicht(Double tarragewicht) {
        this.tarragewicht = tarragewicht;
    }

    public Double getLaadvermogen() {
        return laadvermogen;
    }

    public void setLaadvermogen(Double laadvermogen) {
        this.laadvermogen = laadvermogen;
    }

    public Double getLaadvolume() {
        return laadvolume;
    }

    public void setLaadvolume(Double laadvolume) {
        this.laadvolume = laadvolume;
    }

    public Double getLaadmeters() {
        return laadmeters;
    }

    public void setLaadmeters(Double laadmeters) {
        this.laadmeters = laadmeters;
    }

    public Double getLengte() {
        return lengte;
    }

    public void setLengte(Double lengte) {
        this.lengte = lengte;
    }

    public Double getBreedte() {
        return breedte;
    }

    public void setBreedte(Double breedte) {
        this.breedte = breedte;
    }

    public Double getHoogte() {
        return hoogte;
    }

    public void setHoogte(Double hoogte) {
        this.hoogte = hoogte;
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public void setAantalAssen(int aantalAssen) {
        this.aantalAssen = aantalAssen;
    }

    public String getMotorNorm() {
        return motorNorm;
    }

    public void setMotorNorm(String motorNorm) {
        this.motorNorm = motorNorm;
    }
    
    
}
