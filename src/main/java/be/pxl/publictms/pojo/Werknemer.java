package be.pxl.publictms.pojo;
// Generated 19-dec-2013 20:16:01 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Werknemer generated by hbm2java
 */
public class Werknemer  implements java.io.Serializable {


     private int werknemerid;
     private Taal taal;
     private String naam;
     private String voornaam;
     private Boolean actief;
     private int adresid;
     private int contactid;
     private Character geslacht;
     private String statuut;
     private Date datuminschrijving;
     private Date datumuitschrijving;
     private String functie;
     private int rijbewijsid;
     private int infoid;
     private Set<Gebruiker> gebruikers = new HashSet<Gebruiker>(0);
     private Set<Opdracht> opdrachts = new HashSet<Opdracht>(0);

    public Werknemer() {
    }

	
    public Werknemer(int werknemerid, String naam, String voornaam, int adresid, int contactid, String statuut, Date datuminschrijving, int rijbewijsid, int infoid) {
        this.werknemerid = werknemerid;
        this.naam = naam;
        this.voornaam = voornaam;
        this.adresid = adresid;
        this.contactid = contactid;
        this.statuut = statuut;
        this.datuminschrijving = datuminschrijving;
        this.rijbewijsid = rijbewijsid;
        this.infoid = infoid;
    }
    public Werknemer(int werknemerid, Taal taal, String naam, String voornaam, Boolean actief, int adresid, int contactid, Character geslacht, String statuut, Date datuminschrijving, Date datumuitschrijving, String functie, int rijbewijsid, int infoid, Set<Gebruiker> gebruikers, Set<Opdracht> opdrachts) {
       this.werknemerid = werknemerid;
       this.taal = taal;
       this.naam = naam;
       this.voornaam = voornaam;
       this.actief = actief;
       this.adresid = adresid;
       this.contactid = contactid;
       this.geslacht = geslacht;
       this.statuut = statuut;
       this.datuminschrijving = datuminschrijving;
       this.datumuitschrijving = datumuitschrijving;
       this.functie = functie;
       this.rijbewijsid = rijbewijsid;
       this.infoid = infoid;
       this.gebruikers = gebruikers;
       this.opdrachts = opdrachts;
    }
   
    public int getWerknemerid() {
        return this.werknemerid;
    }
    
    public void setWerknemerid(int werknemerid) {
        this.werknemerid = werknemerid;
    }
    public Taal getTaal() {
        return this.taal;
    }
    
    public void setTaal(Taal taal) {
        this.taal = taal;
    }
    public String getNaam() {
        return this.naam;
    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public String getVoornaam() {
        return this.voornaam;
    }
    
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }
    public Boolean getActief() {
        return this.actief;
    }
    
    public void setActief(Boolean actief) {
        this.actief = actief;
    }
    public int getAdresid() {
        return this.adresid;
    }
    
    public void setAdresid(int adresid) {
        this.adresid = adresid;
    }
    public int getContactid() {
        return this.contactid;
    }
    
    public void setContactid(int contactid) {
        this.contactid = contactid;
    }
    public Character getGeslacht() {
        return this.geslacht;
    }
    
    public void setGeslacht(Character geslacht) {
        this.geslacht = geslacht;
    }
    public String getStatuut() {
        return this.statuut;
    }
    
    public void setStatuut(String statuut) {
        this.statuut = statuut;
    }
    public Date getDatuminschrijving() {
        return this.datuminschrijving;
    }
    
    public void setDatuminschrijving(Date datuminschrijving) {
        this.datuminschrijving = datuminschrijving;
    }
    public Date getDatumuitschrijving() {
        return this.datumuitschrijving;
    }
    
    public void setDatumuitschrijving(Date datumuitschrijving) {
        this.datumuitschrijving = datumuitschrijving;
    }
    public String getFunctie() {
        return this.functie;
    }
    
    public void setFunctie(String functie) {
        this.functie = functie;
    }
    public int getRijbewijsid() {
        return this.rijbewijsid;
    }
    
    public void setRijbewijsid(int rijbewijsid) {
        this.rijbewijsid = rijbewijsid;
    }
    public int getInfoid() {
        return this.infoid;
    }
    
    public void setInfoid(int infoid) {
        this.infoid = infoid;
    }
    public Set<Gebruiker> getGebruikers() {
        return this.gebruikers;
    }
    
    public void setGebruikers(Set<Gebruiker> gebruikers) {
        this.gebruikers = gebruikers;
    }
    public Set<Opdracht> getOpdrachts() {
        return this.opdrachts;
    }
    
    public void setOpdrachts(Set<Opdracht> opdrachts) {
        this.opdrachts = opdrachts;
    }




}


