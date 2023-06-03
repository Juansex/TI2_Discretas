package test;

import junit.framework.TestCase;
import model.Airport;

public class AirportTest extends TestCase {

    public void testCalculateDFS() {
        Airport airport = Airport.getInstance();
        airport.genGraph(5, "A B C D E", "A-B-1/A-C-2/B-D-3/C-E-4");
        assertTrue(airport.calculateDFS("A", "D"));
        assertFalse(airport.calculateDFS("A", "o"));
    }

    public void testCalculateDFSRelated() {
        Airport airport = Airport.getInstance();
        airport.genGraph(5, "A B C D E", "A-B-1/A-C-2/B-D-3/C-E-4");
        assertTrue(airport.calculateDFSRelated());
    }

    public void testCalculateDFSRelated2() {
        Airport airport = Airport.getInstance();
        airport.genGraph(5, "A B C D E", "A-B-1/A-C-2/C-E-4");
        assertFalse(airport.calculateDFSRelated());
    }

    public void testCalculateDijkstra() {
        Airport airport = Airport.getInstance();
        airport.genGraph(5, "A B C D E", "A-B-1/A-C-2/B-D-3/C-E-4");
        assertTrue(airport.calculateDFS("A", "D"));
        assertEquals("La mejor ruta es: A -> B -> D", airport.calculateDijkstra("A", "D"));
    }

    public void testGenerateRandomGraph() {
        Airport airport = Airport.getInstance();
        airport.generateRandomGraph(10);
        assertTrue(airport.calculateDFSRelated());
    }

    public void testCalculateDFSWithRandomGraph() {
        Airport airport = Airport.getInstance();
        airport.generateRandomGraph(10);
        assertTrue(airport.calculateDFS("City0", "City5"));
        System.out.println(airport.calculateDFS("City0", "City9"));
    }

    public void testCalculateDijkstraWithRandomGraph() {
        Airport airport = Airport.getInstance();
        airport.generateRandomGraph(10);
        String result = airport.calculateDijkstra("City0", "City9");
        System.out.println(result);

    }
}
