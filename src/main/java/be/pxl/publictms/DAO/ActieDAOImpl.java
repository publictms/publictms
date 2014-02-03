/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Actie;
import be.pxl.publictms.pojo.Opdracht;
import be.pxl.publictms.view.ActieObjectView;
import be.pxl.publictms.view.ActieView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van ActieDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Stijn ceunen, laurens putseys
 */
@Repository
public class ActieDAOImpl implements ActieDAO{

    private final String qryGetActies = "select a.actieid, a.actieklaar, a.starttijd, a.eindtijd, a.soortactie, a.lading, a.vrijveld, a.opdrachtid, a.adres, o.klantid, o.werknemerid, o.voertuigid, o.opleggerid  from actie a\n" +
"inner join opdracht o on a.opdrachtid = o.opdrachtid";
    private final String qryGetActie ="select a.actieid, a.actieklaar, a.starttijd, a.eindtijd, a.soortactie,a.lading,a.vrijveld,a.opdrachtid,a.adres, o.klantid, o.werknemerid, o.voertuigid, o.opleggerid  from actie a\n" +
"inner join opdracht o on a.opdrachtid = o.opdrachtid where a.actieid = :id";
    private final String qryGetActiesWerknemer ="select a.actieid, a.actieklaar, a.starttijd, a.eindtijd, a.soortactie,a.lading,a.vrijveld,a.opdrachtid,a.adres, o.klantid, o.werknemerid, o.voertuigid, o.opleggerid  from actie a\n" +
"inner join opdracht o on a.opdrachtid = o.opdrachtid where o.werknemerid = :id";
    private final String qryGetActiesOpdracht ="select a.actieid, a.actieklaar, a.starttijd, a.eindtijd, a.soortactie,a.lading,a.vrijveld,a.opdrachtid,a.adres, o.klantid, o.werknemerid, o.voertuigid, o.opleggerid  from actie a\n" +
"inner join opdracht o on a.opdrachtid = o.opdrachtid where a.opdrachtid = :id";
    @Autowired
    private SessionFactory sessionFactory;
    /**
     * zorgt ervoor dat sessionFactory wordt geïnitialiseerd
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    /**
     * Een actie toevoegen.
     * @param actie 
     */
    @Override
    public void addActie(ActieView actieView) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
        Date start = null, end = null;
        try {
            start = dt.parse(actieView.getStart().toString()); 
        } catch (ParseException ex) {
            Logger.getLogger(OpdrachtDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            end = dt.parse(actieView.getEnd().toString()); 
        }catch(ParseException ex){
            Logger.getLogger(OpdrachtDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Actie actie = new Actie(actieView.getActieid(), actieView.getOpdrachtid(), actieView.isActieklaar(), 
                start, end, actieView.getSoortactie(), actieView.getLading(), actieView.getVrijveld(), actieView.getAdres());
        System.out.println(actieView.getActieid() +" "+ actieView.getOpdrachtid() +" "+ actieView.isActieklaar() +" "+ 
                start +" "+ end +" "+ actieView.getSoortactie() +" "+ actieView.getLading() +" "+ actieView.getVrijveld() +" "+ actieView.getAdres());
        sessionFactory.getCurrentSession().save(actie);
    }
    /**
     * Geeft één actie terug.
     * @param id
     * @return Actie
     */
    public ActieObjectView getActie(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryGetActie);
        query.setParameter("id", id);
        return mapJson(query.list()).get(0);
    }
    /**
     * Aan de hand van de index zal deze alle acties ophalen die bij de 
     * bijhorende opdracht horen. Deze id is de index van een opdracht.
     * @param id 
     * @return List met acties 
     */
    @Override
    public List<ActieObjectView> getActiesWerknemer(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryGetActiesWerknemer);
        query.setParameter("id", id);
        return mapJson(query.list());
    }
    /**
     * Aan de hand van de index zal deze alle acties ophalen die bij de 
     * bijhorende opdracht horen. Deze id is de index van een opdracht.
     * @param id 
     * @return List met acties 
     */
    @Override
    public List<ActieObjectView> getActiesOpdracht(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryGetActiesOpdracht);
        query.setParameter("id", id);
        return mapJson(query.list());
    }
    /**
     * Aan de hand van de index zal deze alle acties ophalen die bij de 
     * bijhorende opdracht horen. Deze id is de index van een opdracht.
     * @param id 
     * @return List met acties 
     */
    @Override
    public List<ActieObjectView> getActies() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryGetActies);
        return mapJson(query.list());
    }
    /**
     * Aan de hand van de index kan men een actie verwijderen
     * @param id 
     */
    @Override
    public void deleteActie(int id) {
        Actie actie = (Actie)sessionFactory.getCurrentSession().load(Actie.class, id);
        if(null != actie){
            sessionFactory.getCurrentSession().delete(actie);
        }
    }
    /**
     * Update een actie
     * @param actie 
     */
    @Override
    public void updateActie(ActieView actieView) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
        Date start = null, end = null;
        try {
            start = dt.parse(actieView.getStart().toString()); 
        } catch (ParseException ex) {
            Logger.getLogger(OpdrachtDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            end = dt.parse(actieView.getEnd().toString()); 
        }catch(ParseException ex){
            Logger.getLogger(OpdrachtDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Opdracht opdracht = new Opdracht(actieView.getOpdrachtid(), actieView.getKlantid(), actieView.getVoertuigid(),
                actieView.getResource(), actieView.getOpleggerid(), actieView.isActieklaar(), actieView.getVrijveld());
        Actie actie = new Actie(actieView.getActieid(), actieView.getOpdrachtid(), actieView.isActieklaar(), 
                start, end, actieView.getSoortactie(), actieView.getLading(), actieView.getVrijveld(), actieView.getAdres());
        sessionFactory.getCurrentSession().update(actie);
        sessionFactory.getCurrentSession().update(opdracht);
    }

    /**
     * Zet de actie status op actief of niet actief
     * @param klaar
     * @param id 
     */
    @Override
    public void setKlaar(boolean klaar, int id){
        Actie actie = (Actie)sessionFactory.getCurrentSession().load(Actie.class, id);
        if(null != actie){
            actie.setActieklaar(klaar);
            sessionFactory.getCurrentSession().update(actie);
        }
    }
    /**
     * mapt een hibernate list naar een object namelijk Actieview. Zo kan spring
     * een goede json array sturen met value-pairs.
     * @param list
     * @return 
     */
    public List<ActieObjectView> mapJson(List list){
        List<ActieObjectView> acties = new ArrayList<ActieObjectView>();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            Object[] row = (Object[]) iter.next();
            ActieObjectView actieView = 
                    new ActieObjectView(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], 
                    row[10], row[11], row[12], (row[5]+" " +row[4]).toString());
            acties.add(actieView);
        }
        return acties;
    }
    
}
