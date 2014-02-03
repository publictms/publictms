package be.pxl.publictms.pojo;
// Generated 19-dec-2013 20:16:01 by Hibernate Tools 3.2.1.GA

/**
 * Opdracht generated by hbm2java
 * Informatie wie bepaalde opdrachten moet uitvoeren en met welke voertuig, datum...
 */
public class Opdracht  implements java.io.Serializable {


     private int opdrachtid;
     private int voertuigid;
     private int werknemerid;
     private int opleggerid;
     private int klantid;
     private Boolean opdrachtklaar;
     private String vrijveld;

    public Opdracht() {
    }

	
    public Opdracht(int voertuigid, int werknemerid, int opleggerid, int klantid, Boolean opdrachtklaar, String vrijveld) {
       this.voertuigid = voertuigid;
       this.werknemerid = werknemerid;
       this.opleggerid = opleggerid;
       this.klantid = klantid;
       this.opdrachtklaar = opdrachtklaar;
       this.vrijveld = vrijveld;
    }
    public Opdracht(int opdrachtid, int voertuigid, int werknemerid, int opleggerid, int klantid, Boolean opdrachtklaar, String vrijveld) {
       this.opdrachtid = opdrachtid;
       this.voertuigid = voertuigid;
       this.werknemerid = werknemerid;
       this.opleggerid = opleggerid;
       this.klantid = klantid;
       this.opdrachtklaar = opdrachtklaar;
       this.vrijveld = vrijveld;
    }
    
    public int getOpdrachtid() {
        return this.opdrachtid;
    }
    
    public void setOpdrachtid(int opdrachtid) {
        this.opdrachtid = opdrachtid;
    }
    public int getVoertuigid() {
        return this.voertuigid;
    }
    
    public void setVoertuigid(int voertuigid) {
        this.voertuigid = voertuigid;
    }
    public int getWerknemerid() {
        return this.werknemerid;
    }
    
    public void setWerknemerid(int werknemerid) {
        this.werknemerid = werknemerid;
    }
    public int getOpleggerid() {
        return this.opleggerid;
    }
    
    public void setOpleggerid(int opleggerid) {
        this.opleggerid = opleggerid;
    }
    public int getKlantid() {
        return this.klantid;
    }
    
    public void setKlantid(int klantid) {
        this.klantid = klantid;
    }
    public Boolean getOpdrachtklaar() {
        return this.opdrachtklaar;
    }
    
    public void setOpdrachtklaar(Boolean opdrachtklaar) {
        this.opdrachtklaar = opdrachtklaar;
    }
    public String getVrijveld() {
        return this.vrijveld;
    }
    
    public void setVrijveld(String vrijveld) {
        this.vrijveld = vrijveld;
    }

}