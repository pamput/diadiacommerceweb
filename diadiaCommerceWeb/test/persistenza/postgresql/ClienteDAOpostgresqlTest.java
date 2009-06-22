/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistenza.postgresql;

import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.util.List;
import modello.Cliente;
import org.dbunit.Assertion;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pamput
 */
public class ClienteDAOpostgresqlTest extends DatabaseTestCase{
    
    
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(new FileInputStream("dataset/build.xml"));
    }

    @Override
    protected IDatabaseConnection getConnection() throws Exception {
               
        return new DatabaseConnection(new DataSource().getConnection());
    }

    /**
     * Test of getClienteFromResultSet method, of class ClienteDAOpostgresql.
     */
    @Test
    public void testGetClienteFromResultSet() throws Exception {
        System.out.println("getClienteFromResultSet");
        //Prendiamo un fornitore
        ResultSet result_2 = null;
        result_2 = getConnection().getConnection().prepareStatement("SELECT * FROM clienti WHERE id='3';").executeQuery();
        
        
        ClienteDAOpostgresql instance = new ClienteDAOpostgresql();
        
        //Il cliente atteso è:
        //<clienti id="3" codice="TRE" nome="Giovanni Blu" indirizzo="Via Quando" partitaiva="PIVA3"/>
        Cliente expResult = new ClienteProxy();
        expResult.setId(3);
        expResult.setIndirizzo("Via Quando");
        expResult.setNome("Giovanni Blu");
        expResult.setCodice("TRE");
        expResult.setPartitaiva("PIVA3");
                
        result_2.next();
        Cliente result = instance.getClienteFromResultSet(result_2);
        assertEquals(expResult, result);
        
    }
        
    /**
     * Test of retrieveClienteByID method, of class ClienteDAOpostgresql.
     */
    @Test
    public void testRetrieveClienteByID() throws Exception {
        System.out.println("retrieveClienteByID");
     
        ClienteDAOpostgresql instance = new ClienteDAOpostgresql();
        
        //Il cliente atteso è:
        //<clienti id="3" codice="TRE" nome="Giovanni Blu" indirizzo="Via Quando" partitaiva="PIVA3"/>
        Cliente expResult = new ClienteProxy();
        expResult.setId(3);
        expResult.setIndirizzo("Via Quando");
        expResult.setNome("Giovanni Blu");
        expResult.setCodice("TRE");
        expResult.setPartitaiva("PIVA3");
                
        Cliente result = instance.retrieveClienteByID(3);
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveClienteByCodice method, of class ClienteDAOpostgresql.
     */
    @Test
    public void testRetrieveClienteByCodice() throws Exception {
        System.out.println("retrieveClienteByCodice");
        ClienteDAOpostgresql instance = new ClienteDAOpostgresql();
        
        //Il cliente atteso è:
        //<clienti id="3" codice="TRE" nome="Giovanni Blu" indirizzo="Via Quando" partitaiva="PIVA3"/>
        Cliente expResult = new ClienteProxy();
        expResult.setId(3);
        expResult.setIndirizzo("Via Quando");
        expResult.setNome("Giovanni Blu");
        expResult.setCodice("TRE");
        expResult.setPartitaiva("PIVA3");
                
        Cliente result = instance.retrieveClienteByCodice("TRE");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getClienti method, of class ClienteDAOpostgresql.
     */
    @Test
    public void testGetClienti() throws Exception {
        System.out.println("getClienti");
        ClienteDAOpostgresql instance = new ClienteDAOpostgresql();

        List<Cliente> result = instance.getClienti();
        assertEquals(4, result.size());

    }
    
        /**
     * Test of saveCliente method, of class ClienteDAOpostgresql.
     */
    @Test
    public void testSaveCliente() throws Exception {
        ClienteDAOpostgresql clienteDao = new ClienteDAOpostgresql();
        
        Cliente nuovoCliente = new Cliente();
        nuovoCliente.setId(5);
        nuovoCliente.setNome("Kamal");
        nuovoCliente.setIndirizzo("Via via via da qui!");
        nuovoCliente.setPartitaiva("PARTIVA123");
        nuovoCliente.setCodice("CINQUE");
        
        //Setta il contatore
        getConnection().getConnection().prepareStatement("SELECT setval('public.sequenzaclienti', 5, false);").executeQuery();
        
        //Esegui metodo da testare
        clienteDao.saveCliente(nuovoCliente);
        
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("clienti");

        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.ClienteDAOpostgresql/testSaveCliente.xml"));
        ITable expectedTable = expectedDataSet.getTable("clienti");

        // Assert actual database table match expected table
        
        Assertion.assertEquals(expectedTable, actualTable);

    }
    
    /**
     * Questo test esegue saveCliente e modifica un cliente già esistente.
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveClienteEsistente() throws Exception {
        ClienteDAOpostgresql clienteDao = new ClienteDAOpostgresql();
        
        Cliente nuovoCliente = new Cliente();
        nuovoCliente.setId(4);
        nuovoCliente.setNome("Kamal");
        nuovoCliente.setIndirizzo("Via via via da qui!");
        nuovoCliente.setPartitaiva("PARTIVA123");
        nuovoCliente.setCodice("QUATTRO");
        
        //Setta il contatore
        getConnection().getConnection().prepareStatement("SELECT setval('public.sequenzaclienti', 5, false);").executeQuery();
        
        //Esegui metodo da testare
        clienteDao.saveCliente(nuovoCliente);
        
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("clienti");

        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.ClienteDAOpostgresql/testSaveClienteEsistente.xml"));
        ITable expectedTable = expectedDataSet.getTable("clienti");

        // Assert actual database table match expected table
        
        Assertion.assertEquals(expectedTable, actualTable);

    }
    
        /**
     * Test of deleteCliente method, of class ClienteDAOpostgresql.
     */
    @Test
    public void testDeleteCliente() throws Exception {
        System.out.println("deleteCliente");
        int idCliente = 2;
        ClienteDAOpostgresql instance = new ClienteDAOpostgresql();
        
        //Esegui metodo da testare
        instance.deleteCliente(idCliente);
        
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("clienti");
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.ClienteDAOpostgresql/testDeleteCliente.xml"));
        ITable expectedTable = expectedDataSet.getTable("clienti");
        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
        
    }
    
}





















