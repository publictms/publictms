/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Oplegger;
import be.pxl.publictms.pojo.Laadgegevens;
import be.pxl.publictms.view.OpleggerView;
import java.util.ArrayList;
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
    public void addOplegger(Oplegger oplegger) {
        sessionFactory.getCurrentSession().save(oplegger);
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
        if(null != oplegger){
            sessionFactory.getCurrentSession().delete(oplegger);
        }
    }
    /**
     * Bewerkt een oplegger aan der hand zijn oplegger object.
     * @param oplegger 
     */
    @Override
    public void updateOplegger(OpleggerView opleggerView) {
        System.out.println("****************************************************************");
        System.out.println(opleggerView.getNummerplaat().toString());
        try {
            Laadgegevens laadgegevens = new Laadgegevens(Integer.parseInt(opleggerView.getLaadId().toString()),
                    Double.parseDouble(opleggerView.getTarragewicht().toString()),
                    Double.parseDouble(opleggerView.getLaadvermogen().toString()),
                    Double.parseDouble(opleggerView.getLaadvolume().toString()), 
                    Double.parseDouble(opleggerView.getLaadmeters().toString()), Double.parseDouble(opleggerView.getLengte().toString()), 
                    Double.parseDouble(opleggerView.getBreedte().toString()), Double.parseDouble(opleggerView.getHoogte().toString()), 
                    Integer.parseInt(opleggerView.getAantalAssen().toString()), opleggerView.getMotorNorm().toString());
            
            //Date ingebruik = new SimpleDateFormat("ddMMyyyy").parse(opleggerView.getInGebruik().toString());
            //Date uitgebruik = new SimpleDateFormat("ddMMyyyy").parse(opleggerView.getUitGebruik().toString());
            //Date geldigTot = new SimpleDateFormat("ddMMyyyy").parse(opleggerView.getGeldigTot().toString());
            
            Oplegger oplegger = new Oplegger(Integer.parseInt(opleggerView.getOpleggerid().toString()),
                    Integer.parseInt(opleggerView.getLaadId().toString()), 
                    opleggerView.getNummerplaat().toString(),
                    (Boolean)opleggerView.getActief(), opleggerView.getOmschrijving().toString(), opleggerView.getType().toString(),
                    opleggerView.getBouwjaar().toString(), null, null, 
                    opleggerView.getChassisnr().toString(), (Boolean)opleggerView.getVergunning(), null, 
                    opleggerView.getPvg().toString());

            sessionFactory.getCurrentSession().update(oplegger);
            sessionFactory.getCurrentSession().update(laadgegevens);
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
