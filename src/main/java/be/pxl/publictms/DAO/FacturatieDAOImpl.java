/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.pxl.publictms.DAO;

import be.pxl.publictms.hibernate.HibernateUtil;
import be.pxl.publictms.pojo.Facturatie;
import be.pxl.publictms.view.FacturatieObjectView;
import be.pxl.publictms.view.FacturatieView;
import java.util.ArrayList;
import java.util.Iterator;
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
    
    private final String qryFactuur = "select f.*, k.naam, k.voornaam, k.bedrijf, k.website, k.munt, k.btwregime, btwnummer, \n" +
            "k.ondernemingsnummer, k.iban, k.bic, a.adresid, a.straat, a.nummer, a.bus, a.land, \n" +
            "p.postcode, p.gemeente, c.email, c.telefoon, c.gsm, c.fax\n" +
            "from facturatie f \n" +
            "inner join klant k\n" +
            "on k.klantid = f.klantid\n" +
            "inner join transportadres t\n" +
            "on k.transportadresid = t.transportid\n" +
            "inner join adres a\n" +
            "on t.adresid = a.adresid\n" +
            "inner join postcode p\n" +
            "on p.postcode = a.postcode\n" +
            "inner join contact c\n" +
            "on c.contactid = t.contactid\n" +
            "where f.facturatieid = :id";
    private final String qryFacturen = "select f.*, k.naam, k.voornaam, k.bedrijf, k.website, k.munt, k.btwregime, btwnummer, \n" +
            "k.ondernemingsnummer, k.iban, k.bic, a.adresid, a.straat, a.nummer, a.bus, a.land, \n" +
            "p.postcode, p.gemeente, c.email, c.telefoon, c.gsm, c.fax\n" +
            "from facturatie f \n" +
            "inner join klant k\n" +
            "on k.klantid = f.klantid\n" +
            "inner join transportadres t\n" +
            "on k.transportadresid = t.transportid\n" +
            "inner join adres a\n" +
            "on t.adresid = a.adresid\n" +
            "inner join postcode p\n" +
            "on p.postcode = a.postcode\n" +
            "inner join contact c\n" +
            "on c.contactid = t.contactid";
    
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
    public void addFacturatie(FacturatieView factuur) {
        Facturatie facturatie = new Facturatie(factuur.getFacturatieId(), factuur.getKlantid(), factuur.getKorting(), factuur.getPrijsgegeven());
        sessionFactory.getCurrentSession().save(facturatie);
    }
    /**
     * Aan de hand van een id geeft deze een facturatie object terug
     * @param id
     * @return facturatie
     */
    @Override
    public FacturatieObjectView getFacturatie(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryFactuur);
        query.setParameter("id", id);    
        return mapJson(query.list()).get(0);
    }
    /**
     * Geef een list van facturatie objecten terug aan de hand van een id. Deze index is de klant id.
     * @param klantId
     * @return List facturatie 
     */
    @Override
    public List getFacturen() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery(qryFacturen);   
        return mapJson(query.list());
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
    public void updateFactuur(FacturatieView factuur) {
        Facturatie facturatie = new Facturatie(factuur.getFacturatieId(), factuur.getKlantid(), factuur.getKorting(), factuur.getPrijsgegeven());
        sessionFactory.getCurrentSession().update(facturatie);
    }
    
    /**
     * Mapped een hibernate query naar een objecten klasse
     * @param list
     * @return List<TransportView>
     */
    public List<FacturatieObjectView> mapJson(List list){
        List<FacturatieObjectView> facturatieObjectView = new ArrayList<FacturatieObjectView>();
        for(Iterator iter = list.iterator(); iter.hasNext();){
            Object[] row = (Object[]) iter.next();
            FacturatieObjectView transportView = 
                    new FacturatieObjectView(row[0],
                    row[1],row[2],row[3], row[4], row[5],row[6], row[7], row[8], 
                    row[9], row[10], row[11], row[12], row[13], 
                    row[14], row[15],row[16], row[17], row[18], row[19], row[20], row[21], row[22], row[23], row[24]);
            facturatieObjectView.add(transportView);
        }
        return facturatieObjectView;
    }

    
    
}
