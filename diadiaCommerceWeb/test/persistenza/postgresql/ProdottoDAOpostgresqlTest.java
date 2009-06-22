/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistenza.postgresql;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import modello.*;
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
 * @author Kimo
 */
public class ProdottoDAOpostgresqlTest extends DatabaseTestCase{
    /**
     * Test of getProdottoFromResultSet method, of class ProdottoDAOpostgresql.
     */

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(new FileInputStream("dataset/build.xml"));
    }

    @Override
    protected IDatabaseConnection getConnection() throws Exception {

        return new DatabaseConnection(new DataSource().getConnection());
    }

    /**
     * Test of retrieveProdottoByID method, of class ProdottoDAOpostgresql.
     */
    @Test
    public void testRetrieveProdottoByID() throws Exception {
        System.out.println("retrieveProdottoByID");
        int idProdotto = 3;
        ProdottoDAOpostgresql instance = new ProdottoDAOpostgresql();
        Prodotto expResult = new Prodotto();
        expResult.setCodice("TRE");
        expResult.setDescrizione("Prodotto alimentare");
        expResult.setId(idProdotto);
        expResult.setNome("Caramelle alla liquirizia");
        expResult.setPrezzo(2);
        expResult.setQuantita(500);
        Prodotto result = instance.retrieveProdottoByID(idProdotto);
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveProdottoByCodice method, of class ProdottoDAOpostgresql.
     */
    @Test
    public void testRetrieveProdottoByCodice() throws Exception {
        System.out.println("retrieveProdottoByCodice");
        String codiceProdotto = "DUE";
        ProdottoDAOpostgresql instance = new ProdottoDAOpostgresql();
        Prodotto expResult = new Prodotto();
        expResult.setCodice(codiceProdotto);
        expResult.setDescrizione("Pneumatici");
        expResult.setId(2);
        expResult.setNome("Pneumatici R13");
        expResult.setPrezzo(50);
        expResult.setQuantita(4);
        Prodotto result = instance.retrieveProdottoByCodice(codiceProdotto);
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveAll method, of class ProdottoDAOpostgresql.
     */
    @Test
    public void testRetrieveAll() throws Exception {
        System.out.println("retrieveAll");
        ProdottoDAOpostgresql instance = new ProdottoDAOpostgresql();
        List<Prodotto> expResult = new LinkedList<Prodotto>();

        IDataSet dataSet = getConnection().createDataSet();
        ITable expTable = dataSet.getTable("prodotti");

        Prodotto prodotto = null;
        for(int i = 0; i < expTable.getRowCount(); i++){
            prodotto = new Prodotto();
            prodotto.setId((Integer)expTable.getValue(i, "id"));
            prodotto.setCodice((String) expTable.getValue(i, "codice"));
            prodotto.setDescrizione((String) expTable.getValue(i, "descrizione"));
            prodotto.setNome((String) expTable.getValue(i, "nome"));
            prodotto.setPrezzo((Integer) expTable.getValue(i, "prezzo"));
            prodotto.setQuantita((Integer) expTable.getValue(i, "quantita"));
            expResult.add(prodotto);
        }
        List<Prodotto> result = instance.retrieveAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveDisponibili method, of class ProdottoDAOpostgresql.
     */
    @Test
    public void testRetrieveDisponibili() throws Exception {
        System.out.println("retrieveDisponibili");
        ProdottoDAOpostgresql instance = new ProdottoDAOpostgresql();
        List<Prodotto> expResult =  new LinkedList<Prodotto>();

        IDataSet dataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.ProdottoDAOpostgresql/testRetrieveDisponibili.xml"));
        ITable expTable = dataSet.getTable("prodotti");

        Prodotto prodotto = null;
        for(int i = 0; i < expTable.getRowCount(); i++){
            prodotto = new Prodotto();
            prodotto.setId(Integer.parseInt((String) expTable.getValue(i, "id")));
            prodotto.setCodice((String) expTable.getValue(i, "codice"));
            prodotto.setDescrizione((String) expTable.getValue(i, "descrizione"));
            prodotto.setNome((String) expTable.getValue(i, "nome"));
            prodotto.setPrezzo(Integer.parseInt((String) expTable.getValue(i, "prezzo")));
            prodotto.setQuantita(Integer.parseInt((String) expTable.getValue(i, "quantita")));
            if(prodotto.getQuantita() != 0)
                expResult.add(prodotto);
        }
        List<Prodotto> result = instance.retrieveDisponibili();
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveProdottiByIDFornitore method, of class ProdottoDAOpostgresql.
     */
    @Test
    public void testRetrieveProdottiByIDFornitore() throws Exception {
        System.out.println("retrieveProdottiByIDFornitore");
        int IDFornitore = 3;
        ProdottoDAOpostgresql instance = new ProdottoDAOpostgresql();
        List<Prodotto> expResult = new LinkedList<Prodotto>();

        IDataSet buildDataSet  = getConnection().createDataSet();
        ITable forniture = buildDataSet.getTable("fornisce");

        List<Integer> forniti = new LinkedList<Integer>();
        for(int i = 0; i < forniture.getRowCount(); i++){
            if((Integer)forniture.getValue(i, "idfornitore") == IDFornitore)
                forniti.add((Integer)forniture.getValue(i, "idprodotto"));
        }

        IDataSet dataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.ProdottoDAOpostgresql/testRetrieveProdottiByIDFornitore.xml"));
        ITable expTable = dataSet.getTable("prodotti");

        Prodotto prodotto = null;
        for(int i = 0; i < expTable.getRowCount(); i++){
            prodotto = new Prodotto();
            prodotto.setId(Integer.parseInt((String) expTable.getValue(i, "id")));
            prodotto.setCodice((String) expTable.getValue(i, "codice"));
            prodotto.setDescrizione((String) expTable.getValue(i, "descrizione"));
            prodotto.setNome((String) expTable.getValue(i, "nome"));
            prodotto.setPrezzo(Integer.parseInt((String) expTable.getValue(i, "prezzo")));
            prodotto.setQuantita(Integer.parseInt((String) expTable.getValue(i, "quantita")));
            if(forniti.contains(prodotto.getId()))
                expResult.add(prodotto);
        }
        List<Prodotto> result = instance.retrieveProdottiByIDFornitore(IDFornitore);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveProdotto method, of class ProdottoDAOpostgresql.
     */
    @Test
    public void testSaveProdotto() throws Exception {
        System.out.println("saveProdotto");
        ProdottoDAOpostgresql instance = new ProdottoDAOpostgresql();
        Prodotto prodotto = new Prodotto();
        prodotto.setCodice("SEI");
        prodotto.setDescrizione("Prodotto di cartoleria");
        prodotto.setId(6);
        prodotto.setNome("Supercolla");
        prodotto.setPrezzo(7);
        prodotto.setQuantita(24);
        getConnection().getConnection().prepareStatement("SELECT setval('public.sequenzaprodotti', 6, false);").executeQuery();
        instance.saveProdotto(prodotto);
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("prodotti");
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.ProdottoDAOpostgresql/testSaveProdotto.xml"));
        ITable expectedTable = expectedDataSet.getTable("prodotti");
        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
    }

    @Test
    public void testSaveProdottoEsistente() throws Exception {
        System.out.println("saveProdottoEsistente");
        ProdottoDAOpostgresql instance = new ProdottoDAOpostgresql();
        Prodotto prodotto = new Prodotto();
        prodotto.setCodice("QUATTRO");
        prodotto.setDescrizione("Notebook");
        prodotto.setId(4);
        prodotto.setNome("AsusG50");
        prodotto.setPrezzo(800);
        prodotto.setQuantita(32);
        instance.saveProdotto(prodotto);
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("prodotti");
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.ProdottoDAOpostgresql/testSaveProdottoEsistente.xml"));
        ITable expectedTable = expectedDataSet.getTable("prodotti");
        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
    }

    /**
     * Test of deleteProdotto method, of class ProdottoDAOpostgresql.
     */
    @Test
    public void testDeleteProdotto() throws Exception {
        System.out.println("deleteProdotto");
        int idProdotto = 3;
        ProdottoDAOpostgresql instance = new ProdottoDAOpostgresql();
        instance.deleteProdotto(idProdotto);
                // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("prodotti");
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.ProdottoDAOpostgresql/testDeleteProdotto.xml"));
        ITable expectedTable = expectedDataSet.getTable("prodotti");
        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
    }

}