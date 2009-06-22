/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistenza.postgresql;

import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modello.Fornitore;
import org.dbunit.Assertion;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Test;

/**
 *
 * @author pamput
 */
public class FornitoreDAOpostgresqlTest extends DatabaseTestCase{
    
    
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(new FileInputStream("dataset/build.xml"));
    }

    @Override
    protected IDatabaseConnection getConnection() throws Exception {
               
        return new DatabaseConnection(new DataSource().getConnection());
    }

    /**
     * Test of saveFornitore method, of class ForinitoreDAOpostgresql.
     */
    @Test
    public void testSaveFornitore() throws Exception {
        FornitoreDAOpostgresql fornitoreDao = new FornitoreDAOpostgresql();
        
        Fornitore nuovoFornitore = new Fornitore();
        nuovoFornitore.setId(6);
        nuovoFornitore.setNome("Kamal");
        nuovoFornitore.setTelefono("123456");
        nuovoFornitore.setIndirizzo("Via via via da qui!");
        
        //Setta il contatore
        getConnection().getConnection().prepareStatement("SELECT setval('public.sequenzafornitori', 4, false);").executeQuery();
        
        //Esegui metodo da testare
        fornitoreDao.saveFornitore(nuovoFornitore);
        
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("fornitori");

        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.FornitoreDAOpostgresql/testSaveFornitore.xml"));
        ITable expectedTable = expectedDataSet.getTable("fornitori");

        // Assert actual database table match expected table
        
        Assertion.assertEquals(expectedTable, actualTable);

    }
    
    /**
     * Questo test esegue saveFornitore e modifica un fornitore già esistente.
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveFornitoreEsistente() throws Exception {
        FornitoreDAOpostgresql fornitoreDao = new FornitoreDAOpostgresql();
        
        Fornitore nuovoFornitore = new Fornitore();
        nuovoFornitore.setId(1);
        nuovoFornitore.setNome("Kamal");
        nuovoFornitore.setTelefono("123456");
        nuovoFornitore.setIndirizzo("Via via via da qui!");
        
        //Setta il contatore
        getConnection().getConnection().prepareStatement("SELECT setval('public.sequenzafornitori', 4, false);").executeQuery();
        
        //Esegui metodo da testare
        fornitoreDao.saveFornitore(nuovoFornitore);
        
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("fornitori");

        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.FornitoreDAOpostgresql/testSaveFornitoreEsistente.xml"));
        ITable expectedTable = expectedDataSet.getTable("fornitori");

        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);

    }
    


    /**
     * Test of getFornitoreFromResultSet method, of class FornitoreDAOpostgresql.
     */
    @Test
    public void testGetFornitoreFromResultSet() throws Exception {
        System.out.println("getFornitoreFromResultSet");
        //Prendiamo un fornitore
        ResultSet result_2 = null;
        result_2 = getConnection().getConnection().prepareStatement("SELECT * FROM fornitori WHERE id='2';").executeQuery();
        
        
        FornitoreDAOpostgresql instance = new FornitoreDAOpostgresql();
        
        //Il fornitore atteso è:
        //<fornitori id="2" nome="CARAMELLE inc" indirizzo="Via Boh 23" telefono="082342311"/>
        Fornitore expResult = new FornitoreProxy();
        expResult.setId(2);
        expResult.setIndirizzo("Via Boh 23");
        expResult.setNome("CARAMELLE inc");
        expResult.setTelefono("082342311");
        
        
        result_2.next();
        Fornitore result = instance.getFornitoreFromResultSet(result_2);
        assertEquals(expResult, result);
        
    }

        
    /**
     * Test of retrieveFornitoreByID method, of class FornitoreDAOpostgresql.
     */
    @Test
    public void testRetrieveFornitoreByID() throws Exception {
        System.out.println("retrieveFornitoreByID");
        int idFornitore = 2;
        FornitoreDAOpostgresql instance = new FornitoreDAOpostgresql();
        
        //Il fornitore atteso è:
        //<fornitori id="2" nome="CARAMELLE inc" indirizzo="Via Boh 23" telefono="082342311"/>
        Fornitore expResult = new FornitoreProxy();
        expResult.setId(2);
        expResult.setIndirizzo("Via Boh 23");
        expResult.setNome("CARAMELLE inc");
        expResult.setTelefono("082342311");
        
        Fornitore result = instance.retrieveFornitoreByID(idFornitore);
        
        assertEquals(expResult, result);
        
    }
    

    /**
     * Test of retrieveFornitoreByNome method, of class FornitoreDAOpostgresql.
     */
    @Test
    public void testRetrieveFornitoreByNome() throws Exception {
        System.out.println("retrieveFornitoreByNome");
        String nomeFornitore = "CARAMELLE inc";
        FornitoreDAOpostgresql instance = new FornitoreDAOpostgresql();
        
        //Il fornitore atteso è:
        //<fornitori id="2" nome="CARAMELLE inc" indirizzo="Via Boh 23" telefono="082342311"/>
        Fornitore expResult = new FornitoreProxy();
        expResult.setId(2);
        expResult.setIndirizzo("Via Boh 23");
        expResult.setNome("CARAMELLE inc");
        expResult.setTelefono("082342311");
        
        Fornitore result = instance.retrieveFornitoreByNome(nomeFornitore);
        
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getFornitori method, of class FornitoreDAOpostgresql.
     */
    @Test
    public void testGetFornitori() throws Exception {
        System.out.println("getFornitori");
        FornitoreDAOpostgresql instance = new FornitoreDAOpostgresql();
        
        //Risultato aspettato
        List<Fornitore> expResult = new LinkedList<Fornitore>();
        
        IDataSet dataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.FornitoreDAOpostgresql/testGetFornitori.xml"));
        ITable expTable = dataSet.getTable("fornitori");
        
        Fornitore fornitore = null;
        for(int i = 0; i < expTable.getRowCount(); i++){
            fornitore = new FornitoreProxy();
            fornitore.setId(Integer.parseInt((String) expTable.getValue(i, "id")));
            fornitore.setNome((String) expTable.getValue(i, "nome"));
            fornitore.setIndirizzo((String) expTable.getValue(i, "indirizzo"));
            fornitore.setTelefono((String) expTable.getValue(i, "telefono"));
            
            expResult.add(fornitore);
        }
           
        
        List<Fornitore> result = instance.getFornitori();
        assertEquals(expResult, result);
        
    }

     /**
     * Test of deleteFornitore method, of class FornitoreDAOpostgresql.
     */
    @Test
    public void testDeleteFornitore() throws Exception {
        System.out.println("deleteFornitore");
        int idFornitore = 2;
        FornitoreDAOpostgresql instance = new FornitoreDAOpostgresql();
        
        //Esegui metodo da testare
        instance.deleteFornitore(idFornitore);
        
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("fornitori");
        
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.FornitoreDAOpostgresql/testDeleteFornitore.xml"));
        ITable expectedTable = expectedDataSet.getTable("fornitori");
        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
        
    }
    
        /**
     * Test of retrieveFornitoriByCodiceProdotto method, of class FornitoreDAOpostgresql.
     */
    @Test
    public void testRetrieveFornitoriByCodiceProdotto() throws Exception {
        System.out.println("retrieveFornitoriByCodiceProdotto");
        String codiceProdotto = "UNO";
        List<Fornitore> result = new LinkedList<Fornitore>();
        
        FornitoreDAOpostgresql instance = new FornitoreDAOpostgresql();
        
        //Il fornitore atteso è:
        //<fornitori id="3" nome="ACME inc" indirizzo="Via Uhm 23" telefono="0390248902"/>
        Fornitore expResult = new FornitoreProxy();
        expResult.setId(3);
        expResult.setIndirizzo("Via Uhm 23");
        expResult.setNome("ACME inc");
        expResult.setTelefono("0390248902");
        
        List<Fornitore> expResultList = new LinkedList<Fornitore>();
        expResultList.add(expResult);
        
        result = instance.retrieveFornitoriByCodiceProdotto(codiceProdotto);
        
        assertEquals(expResultList, result);
    }
    
    
    /**
     * Test of associaFornitoreProdotto method, of class FornitoreDAOpostgresql.
     */
    @Test
    public void testAssociaFornitoreProdotto() throws Exception {
        System.out.println("associaFornitoreProdotto");
        int idProdotto = 4;
        int idFornitore = 3;
        FornitoreDAOpostgresql instance = new FornitoreDAOpostgresql();
        instance.associaFornitoreProdotto(idProdotto, idFornitore);

        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("fornisce");

        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.FornitoreDAOpostgresql/testAssociaFornitoreProdotto.xml"));
        ITable expectedTable = expectedDataSet.getTable("fornisce");

        // Assert actual database table match expected table
        
        Assertion.assertEquals(expectedTable, actualTable);
        
    }
    

}

















