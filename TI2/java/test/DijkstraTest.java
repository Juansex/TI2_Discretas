package test;

import junit.framework.TestCase;
import model.Airport;
import model.Dijkstra;

public class DijkstraTest extends TestCase {

    public void testDijkstra() {
        Airport airport = Airport.getInstance();
        airport.genGraph(5, "A B C D E", "A-B-1/A-C-2/B-D-3/C-E-4");

        Dijkstra dijkstra = new Dijkstra(airport.getGraph(), "A", "E");

        assertEquals("A -> C -> E", dijkstra.showDistance("E"));
    }

    public void testDijkstraWithRandomGraph() {
        Airport airport = Airport.getInstance();
        airport.generateRandomGraph(10);

        Dijkstra dijkstra = new Dijkstra(airport.getGraph(), "City0", "City9");

        String result = dijkstra.showDistance("City9");
        if (result.equals("no existe este destino")) {
            System.out.println("There is no route available between City0 and City9 in the random graph.");
        } else {
            System.out.println(result);
        }
    }
    public void testDijkstra2() {
        Airport airport = Airport.getInstance();
        airport.genGraph(6, "A B C D E F", "A-B-2/A-C-5/B-D-3/C-D-1/C-E-4/D-E-6/D-F-7/E-F-2");

        Dijkstra dijkstra = new Dijkstra(airport.getGraph(), "A", "B");

        assertEquals("A -> B", dijkstra.showDistance("B"));
    }

    public void testDijkstraWithRandomGraph2() {
        Airport airport = Airport.getInstance();
        airport.generateRandomGraph(8);

        Dijkstra dijkstra = new Dijkstra(airport.getGraph(), "City0", "City7");

        String result = dijkstra.showDistance("City7");

        System.out.println(result);

    }
}
