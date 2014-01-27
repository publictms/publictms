/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Oplegger;
import be.pxl.publictms.pojo.Laadgegevens;
import be.pxl.publictms.view.OpleggerObjectView;
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
 * Implementatie van OpleggerDAO deze klasse zorgt voor de interactie tussen de
 * database en de webservice. Hibernate verzorgt de communicatie tussen beide.
 *
 * @author Laurens Putseys
 */
@Repository
public class OpleggerDAOImpl implements OpleggerDAO {

    private final String qryOpleggers = "select o.opleggerid, l.laadid, "
            + "o.nummerplaat, o.actief, o.omschrijving, o.opleggertype,\n"
            + "o.bouwjaar, o.datumingebruik, o.datumuitgebruik, o.chassisnummer, o.vergunning,\n"
            + "o.vergunninggeldigtot, o.pvg, l.tarragewicht, l.laadvermogen, "
            + "l.laadvolume, l.laadmeters, l.lengte,\n"
            + "l.breedte, l.hoogte, l.aantalassen, l.motornorm\n"
            + "from oplegger o inner join laadgegevens l on o.laadid = l.laadid";
    private final String qryOplegger = "select o.opleggerid, l.laadid, "
            + "o.nummerplaat, o.actief, o.omschrijving, o.opleggertype,\n"
            + "o.bouwjaar, o.datumingebruik, o.datumuitgebruik, o.chassisnummer, o.vergunning,\n"
            + "o.vergunninggeldigtot, o.pvg, l.tarragewicht, l.laadvermogen, l.laadvolume, "
            + "l.laadmeters, l.lengte,\n"
            + "l.breedte, l.hoogte, l.aantalassen, l.motornorm\n"
            + "from oplegger o inner join laadgegevens l on o.laadid = l.laadid\n"
            + "where o.opleggerid = :id";
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * zorgt ervoor dat sessionFactory wordt geïnitialiseerd
     *
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Voegt een oplegger toe.
     *
     * @param oplegger
     */
    @Override
    public void addOplegger(OpleggerView opleggerView) {

        Laadgegevens laadgegevens =
                new Laadgegevens(opleggerView.getTarragewicht(), opleggerView.getLaadvermogen(), opleggerView.getLaadvolume(), opleggerView.getLaadmeters(),
                opleggerView.getLengte(), opleggerView.getBreedte(), opleggerView.getHoogte(), opleggerView.getAantalAssen(), opleggerView.getMotorNorm());
        sessionFactory.getCurrentSession().save(laadgegevens);

        Oplegger oplegger =
                new Oplegger(laadgegevens.getLaadid(), opleggerView.getNummerplaat(), opleggerView.getActief(), opleggerView.getOmschrijving(),
                opleggerView.getType(), opleggerView.getBouwjaar(), opleggerView.getInGebruik(), opleggerView.getUitGebruik(),
                opleggerView.getChassisnr(), opleggerView.getVergunning(), opleggerView.getGeldigTot(), opleggerView.getPvg());
        sessionFactory.getCurrentSession().save(oplegger);
    }

    /**
     * Geeft een lijst terug met alle opleggers
     *
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
     *
     * @param id
     * @return Oplegger
     */
    @Override
    public OpleggerObjectView getOplegger(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryOplegger);
        query.setParameter("id", id);
        return mapJson(query.list()).get(0);
    }

    /**
     * Delete een oplegger aan de hand van zijn index.
     *
     * @param id
     */
    @Override
    public void deleteOpleggers(int id) {
        Oplegger oplegger = (Oplegger) sessionFactory.getCurrentSession().load(Oplegger.class, id);
        int laaadid = oplegger.getLaadgegevens();
        Laadgegevens laadgegevens = (Laadgegevens) sessionFactory.getCurrentSession().load(Laadgegevens.class, laaadid);
        try {
            sessionFactory.getCurrentSession().delete(laadgegevens);
            sessionFactory.getCurrentSession().delete(oplegger);
        } catch (Exception ex) {
            ex.toString();
        }

    }

    /**
     * Bewerkt een oplegger aan der hand zijn oplegger object.
     *
     * @param oplegger
     */
    @Override
    public void updateOplegger(OpleggerView opleggerView) {
        Laadgegevens laadgegevens =
                new Laadgegevens(opleggerView.getLaadId(), opleggerView.getTarragewicht(), opleggerView.getLaadvermogen(), opleggerView.getLaadvolume(), opleggerView.getLaadmeters(),
                opleggerView.getLengte(), opleggerView.getBreedte(), opleggerView.getHoogte(), opleggerView.getAantalAssen(), opleggerView.getMotorNorm());
        sessionFactory.getCurrentSession().update(laadgegevens);

        Oplegger oplegger =
                new Oplegger(opleggerView.getOpleggerid(),laadgegevens.getLaadid(), opleggerView.getNummerplaat(), opleggerView.getActief(), opleggerView.getOmschrijving(),
                opleggerView.getType(), opleggerView.getBouwjaar(), opleggerView.getInGebruik(), opleggerView.getUitGebruik(),
                opleggerView.getChassisnr(), opleggerView.getVergunning(), opleggerView.getGeldigTot(), opleggerView.getPvg());
        sessionFactory.getCurrentSession().update(oplegger);

    }

    /**
     * mapt een hibernate list naar een object namelijk Actieview. Zo kan spring
     * een goede json array sturen met value-pairs.
     *
     * @param list
     * @return
     */
    public List<OpleggerObjectView> mapJson(List list) {
        List<OpleggerObjectView> opleggers = new ArrayList<OpleggerObjectView>();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object[] row = (Object[]) iter.next();
            OpleggerObjectView opleggerView =
                    new OpleggerObjectView(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9],
                    row[10], row[11], row[12], row[13], row[14], row[15], row[16], row[17], row[18], row[19], row[20], row[21]);
            opleggers.add(opleggerView);
        }
        return opleggers;
    }
}
