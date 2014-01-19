/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Oplegger;
import be.pxl.publictms.pojo.Laadgegevens;
import be.pxl.publictms.view.OpleggerView;
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
 * Implementatie van OpleggerDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Laurens Putseys
 */
@Repository
public class OpleggerDAOImpl implements OpleggerDAO{
    private final String qryOpleggers = "select o.opleggerid, l.laadid, "
            + "o.nummerplaat, o.actief, o.omschrijving, o.opleggertype,\n" +
            "o.bouwjaar, o.datumingebruik, o.datumuitgebruik, o.chassisnummer, o.vergunning,\n" +
            "o.vergunninggeldigtot, o.pvg, l.tarragewicht, l.laadvermogen, "
            + "l.laadvolume, l.laadmeters, l.lengte,\n" +
            "l.breedte, l.hoogte, l.aantalassen, l.motornorm\n" +
            "from oplegger o inner join laadgegevens l on o.laadid = l.laadid";
    private final String qryOplegger ="select o.opleggerid, l.laadid, "
            + "o.nummerplaat, o.actief, o.omschrijving, o.opleggertype,\n" +
            "o.bouwjaar, o.datumingebruik, o.datumuitgebruik, o.chassisnummer, o.vergunning,\n" +
            "o.vergunninggeldigtot, o.pvg, l.tarragewicht, l.laadvermogen, l.laadvolume, "
            + "l.laadmeters, l.lengte,\n" +
            "l.breedte, l.hoogte, l.aantalassen, l.motornorm\n" +
            "from oplegger o inner join laadgegevens l on o.laadid = l.laadid\n" +
            "where o.opleggerid = :id";
    
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
     * Voegt een oplegger toe.
     * @param oplegger 
     */
    @Override
    public void addOplegger(OpleggerView opleggerView) {
        System.out.println(opleggerView.getType());
        try {
            Laadgegevens laadgegevens = 
                    new Laadgegevens(
                    Double.parseDouble(opleggerView.getTarragewicht().toString()),
                    Double.parseDouble(opleggerView.getLaadvermogen().toString()),
                    Double.parseDouble(opleggerView.getLaadvolume().toString()), 
                    Double.parseDouble(opleggerView.getLaadmeters().toString()), Double.parseDouble(opleggerView.getLengte().toString()), 
                    Double.parseDouble(opleggerView.getBreedte().toString()), Double.parseDouble(opleggerView.getHoogte().toString()), 
                    Integer.parseInt(opleggerView.getAantalAssen().toString()), opleggerView.getMotorNorm().toString());
            sessionFactory.getCurrentSession().save(laadgegevens);
            
            Date geldigTot = null,ingebruik = null, uitgebruik = null;
            System.out.println("waarde van: " + opleggerView.getGeldigTot());
            if(!opleggerView.getGeldigTot().toString().isEmpty()){
                geldigTot = new SimpleDateFormat("yyyy-MM-dd").parse(opleggerView.getGeldigTot().toString());
            }if(!opleggerView.getInGebruik().toString().isEmpty()){
                ingebruik = new SimpleDateFormat("yyyy-MM-dd").parse(opleggerView.getInGebruik().toString());
            }if(!opleggerView.getUitGebruik().toString().isEmpty()){
                uitgebruik = new SimpleDateFormat("yyyy-MM-dd").parse(opleggerView.getUitGebruik().toString());
            }

            Oplegger oplegger = 
                    new Oplegger(500,laadgegevens.getLaadid(), opleggerView.getNummerplaat().toString(),
                    Boolean.parseBoolean(opleggerView.getActief().toString()), opleggerView.getOmschrijving().toString(),
                    opleggerView.getType().toString(),opleggerView.getBouwjaar().toString()
                    ,ingebruik,uitgebruik,
                    opleggerView.getChassisnr().toString(),Boolean.parseBoolean(opleggerView.getVergunning().toString()),geldigTot,opleggerView.getPvg().toString());
            sessionFactory.getCurrentSession().save(oplegger);
            } catch (Exception ex) {
            Logger.getLogger(OpleggerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Geeft een lijst terug met alle opleggers 
     * @return List Oplegger
     */
    @Override
    public List getOpleggers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryOpleggers);   
        return mapJson(query.list());
    }
    /**
     * Geeft een specifieke oplegger terug aan de hand van zijn index.
     * @param id
     * @return Oplegger
     */
    @Override
    public OpleggerView getOplegger(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryOplegger);
        query.setParameter("id", id);    
        return mapJson(query.list()).get(0);
    }
    /**
     * Delete een oplegger aan de hand van zijn index.
     * @param id 
     */
    @Override
    public void deleteOpleggers(int id) {
        Oplegger oplegger = (Oplegger)sessionFactory.getCurrentSession().load(Oplegger.class, id);
        int laaadid = oplegger.getLaadgegevens();
        Laadgegevens laadgegevens = (Laadgegevens)sessionFactory.getCurrentSession().load(Laadgegevens.class, laaadid);
        try{
            sessionFactory.getCurrentSession().delete(laadgegevens);
            sessionFactory.getCurrentSession().delete(oplegger);
        }catch(Exception ex){
            ex.toString();
        }
        
    }
    /**
     * Bewerkt een oplegger aan der hand zijn oplegger object.
     * @param oplegger 
     */
    @Override
    public void updateOplegger(OpleggerView opleggerView) {
        try {
            Laadgegevens laadgegevens = new Laadgegevens(Integer.parseInt(opleggerView.getLaadId().toString()),
                    Double.parseDouble(opleggerView.getTarragewicht().toString()),
                    Double.parseDouble(opleggerView.getLaadvermogen().toString()),
                    Double.parseDouble(opleggerView.getLaadvolume().toString()), 
                    Double.parseDouble(opleggerView.getLaadmeters().toString()), Double.parseDouble(opleggerView.getLengte().toString()), 
                    Double.parseDouble(opleggerView.getBreedte().toString()), Double.parseDouble(opleggerView.getHoogte().toString()), 
                    Integer.parseInt(opleggerView.getAantalAssen().toString()), opleggerView.getMotorNorm().toString());
            Date geldigTot = null,ingebruik = null, uitgebruik = null;
            try{
                geldigTot = new SimpleDateFormat("yyyy-MM-dd").parse(opleggerView.getGeldigTot().toString());
            }catch(Exception ex){
                ex.toString();
            }try{
                ingebruik = new SimpleDateFormat("yyyy-MM-dd").parse(opleggerView.getInGebruik().toString());
            }catch(Exception ex){
                ex.toString();
            }try{
                uitgebruik = new SimpleDateFormat("yyyy-MM-dd").parse(opleggerView.getUitGebruik().toString());
            }catch(Exception ex){
                ex.toString();
            }
            
            Oplegger oplegger = 
                    new Oplegger(Integer.parseInt(opleggerView.getOpleggerid().toString()),
                    laadgegevens.getLaadid(), opleggerView.getNummerplaat().toString(),
                    Boolean.parseBoolean(opleggerView.getActief().toString()), opleggerView.getOmschrijving().toString(),
                    opleggerView.getType().toString(),opleggerView.getBouwjaar().toString()
                    ,ingebruik,uitgebruik,
                    opleggerView.getChassisnr().toString(),Boolean.parseBoolean(opleggerView.getVergunning().toString()),geldigTot,opleggerView.getPvg().toString());
            sessionFactory.getCurrentSession().update(laadgegevens);
            sessionFactory.getCurrentSession().update(oplegger);
        } catch (Exception ex) {
            Logger.getLogger(OpleggerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * mapt een hibernate list naar een object namelijk Actieview. Zo kan spring
     * een goede json array sturen met value-pairs.
     * @param list
     * @return 
     */
    public List<OpleggerView> mapJson(List list){
        List<OpleggerView> opleggers = new ArrayList<OpleggerView>();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            Object[] row = (Object[]) iter.next();
            OpleggerView opleggerView = 
                    new OpleggerView(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], 
                    row[10], row[11], row[12], row[13], row[14], row[15], row[16], row[17], row[18], row[19], row[20], row[21]);
            opleggers.add(opleggerView);
        }
        return opleggers;
    }
    
}
