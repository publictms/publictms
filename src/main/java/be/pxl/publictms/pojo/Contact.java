package be.pxl.publictms.pojo;
// Generated 19-dec-2013 20:16:01 by Hibernate Tools 3.2.1.GA

/**
 * Contact generated by hbm2java
 * Houdt informatie bij om een bepaald contactpersoon
 */
public class Contact  implements java.io.Serializable {

    
     private int contactid;
     private String email;
     private String telefoon;
     private String gsm;
     private String fax;

    public Contact() {
    }

	
    public Contact(String email, String telefoon, String gsm, String fax) {
       this.email = email;
       this.telefoon = telefoon;
       this.gsm = gsm;
       this.fax = fax;
    }
    public Contact(String email, String telefoon, String gsm, String fax) {
       this.contactid = contactid;
       this.email = email;
       this.telefoon = telefoon;
       this.gsm = gsm;
       this.fax = fax;
    }
    public Contact(int contactid, String email, String telefoon, String gsm, String fax) {
       this.contactid = contactid;
       this.email = email;
       this.telefoon = telefoon;
       this.gsm = gsm;
       this.fax = fax;
    }
   
    public int getContactid() {
        return this.contactid;
    }
    
    public void setContactid(int contactid) {
        this.contactid = contactid;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefoon() {
        return this.telefoon;
    }
    
    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }
    public String getGsm() {
        return this.gsm;
    }
    
    public void setGsm(String gsm) {
        this.gsm = gsm;
    }
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
}


