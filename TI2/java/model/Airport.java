package model;
public class Airport {
    private Graph graph;
    private static Airport instance;

    public static Airport getInstance() {
        if (instance == null) {
            instance = new Airport();
        }
        return instance;
    }

    private Airport() {
    }

    public void genGraph(int n, String names, String c) {
        initializeGraph(n);
        String [] separetedNames = names.split(" ");

        for (int i = 0; i < n; i++) {
            graph.setNameNodes(i,separetedNames[i]);//crea un nuevo nodo con su nombre

        }
       addRoutes(c);
    }
    public void addRoutes(String c) {
        String [] separatedConections = c.split("/");

        for (int i = 0; i < separatedConections.length; i++) {
            String [] conection = separatedConections[i].split("-");
            int city1=graph.returnPosition(conection[0]);
            int city2=graph.returnPosition(conection[1]);
            if (city1!=-1 && city2!=-1){
                int weight=Integer.parseInt(conection[2]);
                graph.setMatrixAdjacency(city1,city2,1);
                graph.setMatrixCoefficient(city1,city2,weight);
            }

        }

    }

    public void initializeGraph(int numberNodes) {
        graph = new Graph(numberNodes);

    }


    public void generateRandomGraph(int n) {
        initializeGraph(n);
        for (int i = 0; i < n; i++) {
            String name="City"+i;
            graph.setNameNodes(i,name);//crea un nuevo nodo con su nombre
        }

        //agrega pesos aleatorios a las aristas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int weight = (int) (Math.random() * 9 + 1);
                graph.setMatrixCoefficient(i, j, weight);
                if (weight > 0) graph.setMatrixAdjacency(i, j, 1);

            }
        }
    }

    public void resetGraph() {
        graph = null;
    }

    public boolean calculateDFS(String node1, String node2) {
        //Ver si es posible la ruta de una ciudad a otra
        DFS dfs = new DFS(graph, node1, node2);
        return dfs.dfsConection(); //verdadero si es posible
    }

    public boolean calculateDFSRelated() {
        //si todas las ciudades son alcanzables por alguna ruta
        DFS dfs = new DFS(graph);
        return dfs.dfsConected(); //verdadero si es posible
    }

    public String calculateDijkstra(String startCity, String endCity) {
        //calcula la distancia mas corta entre dos ciudades
        Dijkstra dijkstra = new Dijkstra(graph, startCity, endCity);
        if (!calculateDFS(startCity, endCity)) return "No hay rutas disponibles";
        return "La mejor ruta es: " + dijkstra.showDistance(endCity);

    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}

