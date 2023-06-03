package test;

import junit.framework.TestCase;
import model.Airport;
import model.DFS;

public class DFSTest extends TestCase {

    public void testDFSConnection() {
        Airport airport = Airport.getInstance();
        airport.genGraph(6, "A B C D E F", "A-B-2/A-C-5/B-D-3/C-D-1/C-E-4/D-E-6/D-F-7/E-F-2");

        DFS dfs = new DFS(airport.getGraph(), "A", "F");

        assertTrue(dfs.dfsConection());
    }

    public void testDFSConnectionNoRoute() {
        Airport airport = Airport.getInstance();
        airport.genGraph(4, "A B C D", "A-B-1/A-C-1/C-D-1");

        DFS dfs = new DFS(airport.getGraph(), "A", "D");

        assertTrue(dfs.dfsConection());
    }

    public void testDFSConnected() {
        Airport airport = Airport.getInstance();
        airport.genGraph(6, "A B C D E F", "A-B-1/A-C-1/B-D-1/C-D-1/C-E-1/D-F-1");

        DFS dfs = new DFS(airport.getGraph());

        assertTrue(dfs.dfsConected());
    }

    public void testDFSNotConnected() {
        Airport airport = Airport.getInstance();
        airport.genGraph(6, "A B C D E F", "A-B-1/B-C-1/C-D-1/D-E-1");

        DFS dfs = new DFS(airport.getGraph());

        assertFalse(dfs.dfsConected());
    }
}
