/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.view;

/**
 *
 * @author 11302785
 */
public class FacturatieView {
    private int facturatieId;
    private int klantid;
    private double korting;
    private double prijsgegeven;

    public FacturatieView(){}
    
    public FacturatieView(int facturatieId, int klantid, double korting, double prijsgegeven) {
        this.facturatieId = facturatieId;
        this.klantid = klantid;
        this.korting = korting;
        this.prijsgegeven = prijsgegeven;
    }

    public int getFacturatieId() {
        return facturatieId;
    }

    public void setFacturatieId(int facturatieId) {
        this.facturatieId = facturatieId;
    }

    public int getKlantid() {
        return klantid;
    }

    public void setKlantid(int klantid) {
        this.klantid = klantid;
    }

    public double getKorting() {
        return korting;
    }

    public void setKorting(double korting) {
        this.korting = korting;
    }

    public double getPrijsgegeven() {
        return prijsgegeven;
    }

    public void setPrijsgegeven(double prijsgegeven) {
        this.prijsgegeven = prijsgegeven;
    }  
}
