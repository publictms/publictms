/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.view;

import java.text.SimpleDateFormat;


/**
 * Een model van acties zodat men een mooi overzicht krijgt zonder dat men een 
 * hoop indexen ziet maar de werkelijke waarde ervan alsook extra's.
 * @author Laurens Putseys
 */
public class ActieObjectView {
    private Object actieid;
    private Object actieklaar;
    private Object start;
    private Object end;
    private Object soortactie;
    private Object lading;
    private Object vrijveld;
    private Object opdrachtid;
    private Object adres;
    private Object klantid;
    private Object resource;
    private Object voertuigid;
    private Object opleggerid;
    private Object title;
    private Object allDay;

    public ActieObjectView(){}
    
    public ActieObjectView(Object actieid, Object actieklaar, Object start, Object end, Object soortactie, Object lading, Object vrijveld, Object opdrachtid, Object adres, Object klantid, Object resource, Object voertuigid, Object opleggerid,Object title) {
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
        this.title = lading+ " " +soortactie;
        this.allDay = false;
    }
    
    public Object getAllDay() {
        return allDay;
    }

    public void setAllDay(Object allDay) {
        this.allDay = allDay;
    }
    
    public Object getActieid() {
        return actieid;
    }

    public void setActieid(Object actieid) {
        this.actieid = actieid;
    }

    public Object getActieklaar() {
        return actieklaar;
    }

    public void setActieklaar(Object actieklaar) {
        this.actieklaar = actieklaar;
    }

    public Object getSoortactie() {
        return soortactie;
    }

    public void setSoortactie(Object soortactie) {
        this.soortactie = soortactie;
    }

    public Object getLading() {
        return lading;
    }

    public void setLading(Object lading) {
        this.lading = lading;
    }

    public Object getVrijveld() {
        return vrijveld;
    }

    public void setVrijveld(Object vrijveld) {
        this.vrijveld = vrijveld;
    }

    public Object getOpdrachtid() {
        return opdrachtid;
    }

    public void setOpdrachtid(Object opdrachtid) {
        this.opdrachtid = opdrachtid;
    }

    public Object getAdres() {
        return adres;
    }

    public void setAdres(Object adres) {
        this.adres = adres;
    }

    public Object getKlantid() {
        return klantid;
    }

    public void setKlantid(Object klantid) {
        this.klantid = klantid;
    }

    public Object getResource() {
        return resource;
    }

    public void setResource(Object resource) {
        this.resource = resource;
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

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }
    

    public Object getStart() {
        SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return DATE_FORMAT.format(this.start);
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
    }
}
