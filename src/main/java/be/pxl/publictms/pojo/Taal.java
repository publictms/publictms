package be.pxl.publictms.pojo;
// Generated 19-dec-2013 20:16:01 by Hibernate Tools 3.2.1.GA

/**
 * Taal generated by hbm2java
 * Welke talen de werkenemers kunnen spreken.
 */
public class Taal  implements java.io.Serializable {


     private int taalid;
     private String taalnaam;

    public Taal() {
    }
	
    public Taal(int taalid, String taalnaam) {
        this.taalid = taalid;
        this.taalnaam = taalnaam;
    }
   
    public int getTaalid() {
        return this.taalid;
    }
    
    public void setTaalid(int taalid) {
        this.taalid = taalid;
    }
    public String getTaalnaam() {
        return this.taalnaam;
    }
    
    public void setTaalnaam(String taalnaam) {
        this.taalnaam = taalnaam;
    }

}


