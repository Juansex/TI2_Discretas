package model;

public class Graph {
    private int matrixCoefficient[][];
    private int adjMatrix[][];
    private Node nodesName[];
    private int numberNodes;

    public Graph(final int numberNodes) {
        this.matrixCoefficient = new int[numberNodes][numberNodes];
        this.adjMatrix = new int[numberNodes][numberNodes];
        this.nodesName = new Node[numberNodes];
        this.numberNodes = numberNodes;
    }

    public int returnPosition(String nameNode) {
        for (int i = 0; i < this.nodesName.length; i++) {
            if (nodesName[i].getName().equalsIgnoreCase(nameNode)) {
                return i;
            }
        }
        return -1;
    }

    public int getMatrixCoefficient(int node1, int node2) {
        return matrixCoefficient[node1][node2];
    }

    public void setMatrixCoefficient(int node1, int node2, int coefficient) {
        this.matrixCoefficient[node1][node2] = coefficient;
    }

    public int getMatrixAdjacency(int node1, int node2) {
        return adjMatrix[node1][node2];
    }

    public void setMatrixAdjacency(int node1, int node2, int adjacency) {
        this.adjMatrix[node1][node2] = adjacency;
    }

    public String getNameNode(int position) {
        return nodesName[position].getName();
    }

    public void setNameNodes(int position, String nodeName) {
        Node node = new Node(nodeName);
        this.nodesName[position] = node;
    }

    public Node [] getNodes(){
        return nodesName;
    }

    public int getNumberNodes() {
        return numberNodes;
    }
}
