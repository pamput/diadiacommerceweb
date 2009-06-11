/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistenza.postgresql;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.sql.ResultSet;
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
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kimo
 */
public class OrdineDAOpostgresqlTest extends DatabaseTestCase{
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(new FileInputStream("dataset/build.xml"));
    }

    @Override
    protected IDatabaseConnection getConnection() throws Exception {

        return new DatabaseConnection(new DataSource().getConnection());
    }
    /**
     * Test of retrieveOrdineByCodice method, of class OrdineDAOpostgresql.
     */
    @Test
    public void testRetrieveOrdineByCodice() throws Exception {
        System.out.println("retrieveOrdineByCodice");
        String codiceOrdine = "DUE";
        OrdineDAOpostgresql instance = new OrdineDAOpostgresql();
        Ordine expResult = new OrdineProxy();
        Cliente cliente = new Cliente();
        cliente.setCodice(codiceOrdine);
        cliente.setID(2);
        cliente.setIndirizzo("Via Dove");
        cliente.setNome("Marco Verdi");
        cliente.setPartitaiva("PIVA2");
        cliente.getOrdini();
        expResult.setCliente(cliente);
        expResult.setCodice("DUE");
        expResult.setData(new Date(1990,11,19));
        expResult.setID(2);
        expResult.getRigheOrdine();
        expResult.setStato("chiuso");
        Ordine result = instance.retrieveOrdineByCodice(codiceOrdine);
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveOrdineByID method, of class OrdineDAOpostgresql.
     */
    @Test
    public void testRetrieveOrdineByID() throws Exception {
        System.out.println("retrieveOrdineByID");
        int idOrdine = 2;
        OrdineDAOpostgresql instance = new OrdineDAOpostgresql();
        Ordine expResult = new OrdineProxy();
        Cliente cliente = new Cliente();
        cliente.setCodice("DUE");
        cliente.setID(idOrdine);
        cliente.setIndirizzo("Via Dove");
        cliente.setNome("Marco Verdi");
        cliente.setPartitaiva("PIVA2");
        cliente.getOrdini();
        expResult.setCliente(cliente);
        expResult.setCodice("DUE");
        expResult.setData(new Date(1990,11,19));
        expResult.setID(2);
        expResult.getRigheOrdine();
        expResult.setStato("chiuso");
        Ordine result = instance.retrieveOrdineByID(idOrdine);
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveAll method, of class OrdineDAOpostgresql.
     */
    @Test
    public void testRetrieveAll() throws Exception {
        System.out.println("retrieveAll");
        OrdineDAOpostgresql instance = new OrdineDAOpostgresql();
        List<Ordine> expResult = new LinkedList<Ordine>();

        IDataSet dataSet = getConnection().createDataSet();
        ITable expTable = dataSet.getTable("ordini");

        Ordine ordine = null;
        for(int i = 0; i < expTable.getRowCount(); i++){
            ordine = new OrdineProxy();
            ordine.setID((Integer)expTable.getValue(i, "id"));
            ordine.setCodice((String)expTable.getValue(i, "codice"));
            ordine.setData((Date)expTable.getValue(i, "data"));
            ordine.getRigheOrdine();
            ordine.setStato((String)expTable.getValue(i, "stato"));
            expResult.add(ordine);
        }
        List<Ordine> result = instance.retrieveAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveOrdineByIDCliente method, of class OrdineDAOpostgresql.
     */
    @Test
    public void testRetrieveOrdineByIDCliente() throws Exception {
        System.out.println("retrieveOrdineByIDCliente");
        int idCliente = 2;
        OrdineDAOpostgresql instance = new OrdineDAOpostgresql();
        List<Ordine> expResult = new LinkedList<Ordine>();

        IDataSet dataSet = getConnection().createDataSet();
        ITable expTable = dataSet.getTable("ordini");

        Ordine ordine = null;
        for(int i = 0; i < expTable.getRowCount(); i++){
            ordine = new OrdineProxy();
            ordine.setID((Integer)expTable.getValue(i, "id"));
            ordine.setCodice((String)expTable.getValue(i, "codice"));
            ordine.setData((Date)expTable.getValue(i, "data"));
            ordine.getRigheOrdine();
            ordine.setStato((String)expTable.getValue(i, "stato"));
            ClienteDAOpostgresql clienteDAO = new ClienteDAOpostgresql();
            ordine.setCliente(clienteDAO.retrieveClienteByID((Integer)expTable.getValue(i, "idcliente")));
            if(ordine.getCliente().getID() == idCliente)
                expResult.add(ordine);
        }
        List<Ordine> result = instance.retrieveOrdineByIDCliente(idCliente);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveOrdine method, of class OrdineDAOpostgresql.
     */
    @Test
    public void testSaveOrdine() throws Exception {
        System.out.println("saveOrdine");
        Ordine ordine = new OrdineProxy();
        ordine.setCodice("TRE");
        ordine.setData(new Date(103,03,04)); //Attenzione, problemi con la data
        ordine.setID(3);
        ordine.setStato("aperto");
        ClienteDAOpostgresql clienteDAO = new ClienteDAOpostgresql();
        ordine.setCliente(clienteDAO.retrieveClienteByID(1));
        OrdineDAOpostgresql instance = new OrdineDAOpostgresql();
        getConnection().getConnection().prepareStatement("SELECT setval('public.sequenzaordini', 3, false);").executeQuery();
        instance.saveOrdine(ordine);
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("ordini");
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.OrdineDAOpostgresql/testSaveOrdine.xml"));
        ITable expectedTable = expectedDataSet.getTable("ordini");
        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
    }

    @Test
    public void testSaveOrdineEsistente() throws Exception {
        System.out.println("saveOrdineEsistente");
        Ordine ordine = new OrdineProxy();
        ordine.setCodice("UNOMOD");
        ordine.setData(new Date(112,11,12)); //Attenzione, problemi con la data
        ordine.setID(1);
        ordine.setStato("evaso");
        ClienteDAOpostgresql clienteDAO = new ClienteDAOpostgresql();
        ordine.setCliente(clienteDAO.retrieveClienteByID(1));
        OrdineDAOpostgresql instance = new OrdineDAOpostgresql();
        instance.saveOrdine(ordine);
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("ordini");
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.OrdineDAOpostgresql/testSaveOrdineEsistente.xml"));
        ITable expectedTable = expectedDataSet.getTable("ordini");
        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
    }

    /**
     * Test of deleteOrdine method, of class OrdineDAOpostgresql.
     */
    @Test
    public void testDeleteOrdine() throws Exception {
        System.out.println("deleteOrdine");
        int idOrdine = 2;
        OrdineDAOpostgresql instance = new OrdineDAOpostgresql();
        instance.deleteOrdine(idOrdine);
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("ordini");
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.OrdineDAOpostgresql/testDeleteOrdine.xml"));
        ITable expectedTable = expectedDataSet.getTable("ordini");
        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
    }

    public void testEvadiOrdine() throws Exception {
        System.out.println("evadiOrdine");
        Ordine ordine = new OrdineProxy();
        ordine.setCodice("DUE");
        ordine.setID(2);
        ordine.setStato("chiuso");
        ClienteDAOpostgresql clienteDAO = new ClienteDAOpostgresql();
        ordine.setCliente(clienteDAO.retrieveClienteByID(2));
        OrdineDAOpostgresql instance = new OrdineDAOpostgresql();
        instance.evadiOrdine(ordine);
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("ordini");
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.OrdineDAOpostgresql/testEvadiOrdine.xml"));
        ITable expectedTable = expectedDataSet.getTable("ordini");
        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
    }

}