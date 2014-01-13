/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Opdracht;
import be.pxl.publictms.view.OpdrachtView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van OpdrachtDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Stijn Ceunen, Laurens Putseys
 */
@Repository
public class OpdrachtDAOImpl implements OpdrachtDAO{
    
    final String select = "select o.opdrachtid, \n" +
        "k.naam as \"klant naam\", k.voornaam as \"klant voornaam\", k.bedrijf, o.datum, w.naam as \"werknemer naam\", w.voornaam as \"werknemer voornaam\", v.nummerplaat as \"voertuig\", op.nummerplaat as \"oplegger\", o.opdrachtklaar, o.vrijveld\n" +
        "from opdracht o\n" +
        "inner join klant k\n" +
        "on o.klantid = k.klantid\n" +
        "inner join voertuig v\n" +
        "on o.voertuigid = v.voertuigid\n" +
        "inner join werknemer w\n" +
        "on o.werknemerid = w.werknemerid\n" +
        "inner join oplegger op\n" +
        "on o.opleggerid = op.opleggerid";
    
    final String selectWerknemer ="select o.opdrachtid, \n" +
        "k.naam as \"klant naam\", k.voornaam as \"klant voornaam\", k.bedrijf, o.datum, w.naam as \"werknemer naam\", w.voornaam as \"werknemer voornaam\", v.nummerplaat as \"voertuig\", op.nummerplaat as \"oplegger\", o.opdrachtklaar, o.vrijveld\n" +
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
    public void addOpdracht(Opdracht opdracht) {
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
    public void updateOpdracht(Opdracht opdracht) {
        sessionFactory.getCurrentSession().update(opdracht);
    }
    /**
     * Is de levering afgeleverd op klaar zetten. 
     * @param klaar 
     */
    public void setKlaar(boolean klaar, int id){
        Opdracht opdracht = (Opdracht)sessionFactory.getCurrentSession().load(Opdracht.class, id);
        if(null != opdracht){
            opdracht.setOpdrachtklaar(klaar);
            sessionFactory.getCurrentSession().update(opdracht);
        }
    }
     /**
     * mapt een hibernate list naar een object namelijk Actieview. Zo kan spring
     * een goede json array sturen met value-pairs.
     * @param list
     * @return 
     */
    public List<OpdrachtView> mapJson(List list){
        List<OpdrachtView> opdrachten = new ArrayList<OpdrachtView>();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            Object[] row = (Object[]) iter.next();
            OpdrachtView actieView = 
                    new OpdrachtView(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], row[10]);
            opdrachten.add(actieView);
        }
        return opdrachten;
    }
    
}
