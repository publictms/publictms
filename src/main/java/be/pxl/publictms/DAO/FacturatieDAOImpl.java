/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Facturatie;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementatie van AdresDAO deze klasse zorgt voor de interactie tussen de database
 * en de webservice. Hibernate verzorgt de communicatie tussen beide.
 * @author Laurens Putseys
 */
@Repository
public class FacturatieDAOImpl implements FacturatieDAO{
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
     * Voegt een factuur toe.
     * @param factuur 
     */
    @Override
    public void addFacturatie(Facturatie factuur) {
        sessionFactory.getCurrentSession().save(factuur);
    }
    /**
     * Aan de hand van een id geeft deze een facturatie object terug
     * @param id
     * @return facturatie
     */
    @Override
    public Facturatie getFacturatie(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Facturatie where FacturatieId = :id");
        query.setParameter("id", id);
        return (Facturatie)query.list().get(0);
    }
    /**
     * Geef een list van facturatie objecten terug aan de hand van een id. Deze index is de klant id.
     * @param klantId
     * @return List facturatie 
     */
    @Override
    public List<Facturatie> getFacturen(int klantId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Facturatie where KlantId = :id");
        query.setParameter("id", klantId);
        return query.list();
    }
    /**
     * Delete een facturatie object aan de hand van zijn index.
     * @param id 
     */
    @Override
    public void deleteFactuur(int id) {
        Facturatie factuur = (Facturatie)sessionFactory.getCurrentSession().load(Facturatie.class, id);
        if(null != factuur){
            sessionFactory.getCurrentSession().delete(factuur);
        }
    }
    /**
     * Bewerkt een factuur aan de hand van een Facturatie object.
     * @param factuur 
     */
    @Override
    public void updateFactuur(Facturatie factuur) {
        sessionFactory.getCurrentSession().update(factuur);
    }

    
    
}
