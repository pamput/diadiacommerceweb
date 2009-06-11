/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistenza.postgresql;

/**
 *
 * @author Kimo
 */

import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.LinkedList;
import modello.*;
import persistenza.postgresql.*;
import org.dbunit.Assertion;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConfig.ConfigProperty;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.ITableIterator;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

public class RigaOrdineDAOpostgresqlTest extends DatabaseTestCase{
    @Test
    public void testRetrieveRigheOrdineByIDOrdine() throws Exception {
        RigaOrdineDAOpostgresql rigaordineDao = new RigaOrdineDAOpostgresql();
        //Esegui metodo da testare
        List<RigaOrdine> listaRighe = rigaordineDao.retrieveRigheOrdineByIDOrdine(2);
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.RigaOrdineDAOpostgresql/testRetrieveRigheOrdineByIDOrdine.xml"));
        ITable expectedTable = expectedDataSet.getTable("righeordine");
        //Preparazione dati aspettati
        RigaOrdine rigaordine = null;
        List<RigaOrdine> expectedResult = new LinkedList<RigaOrdine>();
        for(int i = 0; i < expectedTable.getRowCount(); i++){
            rigaordine = new RigaOrdine();
            rigaordine.setID(Integer.parseInt((String) expectedTable.getValue(i, "id")));
            rigaordine.setNumeroRiga(Integer.parseInt((String) expectedTable.getValue(i, "numeroriga")));
            rigaordine.setQuantita(Integer.parseInt((String) expectedTable.getValue(i, "quantita")));
            ProdottoDAOpostgresql prodottoDAO = new ProdottoDAOpostgresql();
            Prodotto prodotto = prodottoDAO.retrieveProdottoByID(Integer.parseInt((String)expectedTable.getValue(i, "idprodotto")));
            rigaordine.setProdotto(prodotto);
            expectedResult.add(rigaordine);
        }
        // Assert actual database table match expected table
        assertEquals(listaRighe,expectedResult);
    }

    @Test
    public void testSaveRigaOrdine() throws Exception {
        RigaOrdineDAOpostgresql rigaordineDao = new RigaOrdineDAOpostgresql();
        //Inizializzazione oggetto per il test
        //<ordini id="2" codice="DUE" data="1990-11-19" stato="chiuso" idcliente="2"/>
        
        RigaOrdine nuovaRigaOrdine = new RigaOrdine();
        Ordine ordine = new Ordine();
        ordine.setID(2);
        Prodotto prodotto = new Prodotto();
        prodotto.setID(2);
        nuovaRigaOrdine.setProdotto(prodotto);
        nuovaRigaOrdine.setNumeroRiga(3);
        nuovaRigaOrdine.setQuantita(10);
        //Setta il contatore
        getConnection().getConnection().prepareStatement("SELECT setval('public.sequenzarigheordine', 5, false);").executeQuery();
        //Esegui metodo da testare
        rigaordineDao.saveRigaOrdine(nuovaRigaOrdine,ordine);
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("righeordine");
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.RigaOrdineDAOpostgresql/testSaveRigaOrdine.xml"));
        ITable expectedTable = expectedDataSet.getTable("righeordine");
        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
    }

    @Test
    public void testSaveRigaOrdineEsistente() throws Exception {
        RigaOrdineDAOpostgresql rigaordineDao = new RigaOrdineDAOpostgresql();
        //Inizializzazione oggetto per il test
        //	<righeordine id="4" idordine="2" idprodotto="4" numeroriga="2" quantita="2" />
        RigaOrdine nuovaRigaOrdine = new RigaOrdine();
        nuovaRigaOrdine.setID(4);
        Ordine ordine = new Ordine();
        ordine.setID(2);
        Prodotto prodotto = new Prodotto();
        prodotto.setID(4);
        nuovaRigaOrdine.setProdotto(prodotto);
        nuovaRigaOrdine.setNumeroRiga(2);
        nuovaRigaOrdine.setQuantita(12);
        //Setta il contatore
        getConnection().getConnection().prepareStatement("SELECT setval('public.sequenzarigheordine', 5, false);").executeQuery();
        //Esegui metodo da testare
        rigaordineDao.saveRigaOrdine(nuovaRigaOrdine,ordine);
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("righeordine");
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.RigaOrdineDAOpostgresql/testSaveRigaOrdineEsistente.xml"));
        ITable expectedTable = expectedDataSet.getTable("righeordine");
        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
    }

    @Test
    public void testDeleteRigaOrdine() throws Exception {
        RigaOrdineDAOpostgresql rigaordineDao = new RigaOrdineDAOpostgresql();
        //Esegui metodo da testare
        rigaordineDao.deleteRigaOrdine(2);
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("righeordine");
        // Load expected data from an XML dataset
        IDataSet expectedDataSet = new FlatXmlDataSet(new File("dataset/persistenza.postgresql.RigaOrdineDAOpostgresql/testDeleteRigaOrdine.xml"));
        ITable expectedTable = expectedDataSet.getTable("righeordine");
        // Assert actual database table match expected table
        Assertion.assertEquals(expectedTable, actualTable);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(new FileInputStream("dataset/build.xml"));
    }

    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        return new DatabaseConnection(new DataSource().getConnection());
    }
}
