package kafkajson.movie;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Movie App
 */
public class AppTest 
    extends TestCase
{
    /**
     * Crea il test Case
     *
     * @param testTitolo 
     */
    public AppTest( String testTitolo )
    {
        super( testTitolo );
        // aggiungi due assert ed è fatta
        // una funzione con un for che verifica il numero di record
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
