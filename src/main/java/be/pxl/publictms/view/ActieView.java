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
public class ActieView {
    private int actieid;
    private boolean actieklaar;
    private String start;
    private String end;
    private String soortactie;
    private String lading;
    private String vrijveld;
    private int opdrachtid;
    private String adres;
    private int klantid;
    private int resource;
    private int voertuigid;
    private int opleggerid;
    private String title;
    private boolean allDay;

    public ActieView() {
        
    }
    
    public ActieView(int actieid, boolean actieklaar, String start, String end, String soortactie, String lading, String vrijveld, int opdrachtid, String adres, int klantid, int resource, int voertuigid, int opleggerid, String title, boolean allDay) {
        this.actieid = actieid;
        this.actieklaar = actieklaar;
        this.start = start;
        this.end = end;
        this.soortactie = soortactie;
        this.lading = lading;
        this.vrijveld = vrijveld;
        this.opdrachtid = opdrachtid;
        this.adres = adres;
        this.klantid = klantid;
        this.resource = resource;
        this.voertuigid = voertuigid;
        this.opleggerid = opleggerid;
        this.title = title;
        this.allDay = allDay;
    }
    
    public ActieView(int actieid, boolean actieklaar, String start, String end, String soortactie, String lading, String vrijveld, int opdrachtid, String adres, boolean allDay) {
        this.actieid = actieid;
        this.actieklaar = actieklaar;
        this.start = start;
        this.end = end;
        this.soortactie = soortactie;
        this.lading = lading;
        this.vrijveld = vrijveld;
        this.opdrachtid = opdrachtid;
        this.adres = adres;
        this.allDay = allDay;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public int getActieid() {
        return actieid;
    }

    public void setActieid(int actieid) {
        this.actieid = actieid;
    }

    public boolean isActieklaar() {
        return actieklaar;
    }

    public void setActieklaar(boolean actieklaar) {
        this.actieklaar = actieklaar;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getSoortactie() {
        return soortactie;
    }

    public void setSoortactie(String soortactie) {
        this.soortactie = soortactie;
    }

    public String getLading() {
        return lading;
    }

    public void setLading(String lading) {
        this.lading = lading;
    }

    public String getVrijveld() {
        return vrijveld;
    }

    public void setVrijveld(String vrijveld) {
        this.vrijveld = vrijveld;
    }

    public int getOpdrachtid() {
        return opdrachtid;
    }

    public void setOpdrachtid(int opdrachtid) {
        this.opdrachtid = opdrachtid;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getKlantid() {
        return klantid;
    }

    public void setKlantid(int klantid) {
        this.klantid = klantid;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public int getVoertuigid() {
        return voertuigid;
    }

    public void setVoertuigid(int voertuigid) {
        this.voertuigid = voertuigid;
    }

    public int getOpleggerid() {
        return opleggerid;
    }

    public void setOpleggerid(int opleggerid) {
        this.opleggerid = opleggerid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    
   
}
