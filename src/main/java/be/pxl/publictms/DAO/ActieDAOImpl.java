/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Actie;
import be.pxl.publictms.view.ActieView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    public void addActie(Actie actie) {
        sessionFactory.getCurrentSession().save(actie);
    }
    /**
     * Aan de hand van de index zal deze alle acties ophalen die bij de 
     * bijhorende opdracht horen. Deze id is de index van een opdracht.
     * @param id 
     * @return List met acties 
     */
    @Override
    public List<Actie> getActiesVanOpdracht(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Actie where OpdrachtId = :id");
        query.setParameter("id", id);
        return query.list();
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
    public void updateActie(Actie actie) {
        sessionFactory.getCurrentSession().update(actie);
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
    public List<ActieView> mapJson(List list){
        List<ActieView> acties = new ArrayList<ActieView>();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            Object[] row = (Object[]) iter.next();
            ActieView actieView = 
                    new ActieView(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], 
                    row[10], row[11], row[12], row[13], row[14], row[15], row[16], row[17], row[18], row[19], row[20], row[21]);
            acties.add(actieView);
        }
        return acties;
    }
    
}
