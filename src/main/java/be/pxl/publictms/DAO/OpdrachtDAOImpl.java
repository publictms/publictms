/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Opdracht;
import be.pxl.publictms.view.OpdrachtObjectView;
import be.pxl.publictms.view.OpdrachtView;
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
import java.sql.Time;
/**
 * Implementatie van OpdrachtDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Stijn Ceunen, Laurens Putseys
 */
@Repository
public class OpdrachtDAOImpl implements OpdrachtDAO{
    
    final String select = "select o.opdrachtid, k.klantid as \"klant id\"\n" +
        ",k.naam as \"klant naam\" ,k.voornaam as \"klant voornaam\", k.bedrijf, w.werknemerid as \"werknemer id\" ,w.naam as \"werknemer naam\", w.voornaam as \"werknemer voornaam\", \n" +
        "v.voertuigid, v.nummerplaat as \"voertuig\",op.opleggerid, op.nummerplaat as \"oplegger\", o.opdrachtklaar, o.vrijveld\n" +
        "from opdracht o\n" +
        "inner join klant k\n" +
        "on o.klantid = k.klantid\n" +
        "inner join voertuig v\n" +
        "on o.voertuigid = v.voertuigid\n" +
        "inner join werknemer w\n" +
        "on o.werknemerid = w.werknemerid\n" +
        "inner join oplegger op\n" +
        "on o.opleggerid = op.opleggerid";
    
    final String selectOpdracht = "select o.opdrachtid, k.klantid as \"klant id\"\n" +
"        ,k.naam as \"klant naam\" ,k.voornaam as \"klant voornaam\", k.bedrijf, w.werknemerid as \"werknemer id\" ,w.naam as \"werknemer naam\", w.voornaam as \"werknemer voornaam\", v.voertuigid, v.nummerplaat as \"voertuig\",op.opleggerid, op.nummerplaat as \"oplegger\", o.opdrachtklaar, o.vrijveld\n" +
"        from opdracht o\n" +
"        inner join klant k\n" +
"        on o.klantid = k.klantid\n" +
"        inner join voertuig v\n" +
"        on o.voertuigid = v.voertuigid\n" +
"        inner join werknemer w\n" +
"        on o.werknemerid = w.werknemerid\n" +
"        inner join oplegger op\n" +
"        on o.opleggerid = op.opleggerid\n" +
"        where o.opdrachtid = :id";
    
    final String selectWerknemer ="select o.opdrachtid, k.klantid as \"klantid\"\n" +
        ",k.naam as \"klantnaam\", k.voornaam as \"klantvoornaam\", k.bedrijf," +
        "w.werknemerid as \"werknemerid\" ,w.naam as \"werknemernaam\", w.voornaam as \"werknemervoornaam\", v.voertuigid, v.nummerplaat as \"voertuig\",op.opleggerid, op.nummerplaat as \"oplegger\", o.opdrachtklaar, o.vrijveld\n" +
        "from opdracht o\n" +
        "inner join klant k\n" +
        "on o.klantid = k.klantid\n" +
        "inner join voertuig v\n" +
        "on o.voertuigid = v.voertuigid\n" +
        "inner join werknemer w\n" +
        "on o.werknemerid = w.werknemerid\n" +
        "inner join oplegger op\n" +
        "on o.opleggerid = op.opleggerid\n" +
        "where w.werknemerid = :id";
    
    
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
     * Voeg een opdracht toe.
     * @param opdracht 
     */
    @Override
    public void addOpdracht(OpdrachtView opdrachtView) {
        System.out.println(opdrachtView.getKlantId());
        /*SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
        Date start = null, end = null;
        try {
            start = dt.parse(opdrachtView.getStart().toString()); 
        } catch (ParseException ex) {
            Logger.getLogger(OpdrachtDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            end = dt.parse(opdrachtView.getEnd().toString()); 
        }catch(ParseException ex){
            Logger.getLogger(OpdrachtDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        Opdracht opdracht = new Opdracht(opdrachtView.getId(), opdrachtView.getVoertuigid(), 
        opdrachtView.getWerknemerId(), opdrachtView.getOpleggerid(), opdrachtView.getKlantId(), 
        opdrachtView.isOpdrachtklaar(), opdrachtView.getVrijveld());
        sessionFactory.getCurrentSession().save(opdracht);
    }
    /**
     * Geeft een list met opdracht terug
     * @return List Opdracht
     */
    @Override
    public List getOpdrachten() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(select);
        return mapJson(query.list());
        //return query.list();
    }
    
    @Override
    public List getOpdrachtenWerknemer(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(selectWerknemer);
        return mapJson(query.setParameter("id", id).list());
    }
    /**
     * Delete een opdracht aan de hand van zijn index.
     * @param id 
     */
    @Override
    public void deleteOpdracht(int id) {
        Opdracht opdracht = (Opdracht)sessionFactory.getCurrentSession().load(Opdracht.class, id);
        if(null != opdracht){
            sessionFactory.getCurrentSession().delete(opdracht);
        }
    }
    /**
     * Bewerkt een opdracht aan de hand een opdracht object
     * @param opdracht 
     */
    @Override
    public void updateOpdracht(OpdrachtView opdrachtView) {
        /*SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
        Date start = null, end = null;
        try {
            start = dt.parse(opdrachtView.getStart().toString()); 
        } catch (ParseException ex) {
            Logger.getLogger(OpdrachtDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            end = dt.parse(opdrachtView.getEnd().toString()); 
        }catch(ParseException ex){
            Logger.getLogger(OpdrachtDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        System.out.println(opdrachtView.getOpleggerid());
        Opdracht opdracht = new Opdracht(opdrachtView.getId(), opdrachtView.getVoertuigid(), 
        opdrachtView.getWerknemerId(), opdrachtView.getOpleggerid(), opdrachtView.getKlantId(), 
        opdrachtView.isOpdrachtklaar(), opdrachtView.getVrijveld());
        sessionFactory.getCurrentSession().update(opdracht);
    }
    /**
     * Is de levering afgeleverd op klaar zetten. 
     * @param klaar 
     */
    @Override
    public void setKlaar(boolean klaar, int id){
        Opdracht opdracht = (Opdracht)sessionFactory.getCurrentSession().load(Opdracht.class, id);
        if(null != opdracht){
            opdracht.setOpdrachtklaar(klaar);
            sessionFactory.getCurrentSession().update(opdracht);
        }
    }
    @Override
    public OpdrachtObjectView getOpdracht(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(selectOpdracht);
        query.setParameter("id", id);
        return mapJson(query.list()).get(0);
    }
     /**
     * mapt een hibernate list naar een object namelijk Actieview. Zo kan spring
     * een goede json array sturen met value-pairs.
     * @param list
     * @return 
     */
    public List<OpdrachtObjectView> mapJson(List list){
        List<OpdrachtObjectView> opdrachten = new ArrayList<OpdrachtObjectView>();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            Object[] row = (Object[]) iter.next();
            OpdrachtObjectView actieView = 
                    new OpdrachtObjectView(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], row[10], row[11], row[12], row[13]);
            opdrachten.add(actieView);
        }
        return opdrachten;
    }
}
