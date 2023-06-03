package model;

public class Dijkstra {
    private Graph graph;
    private int auxAccumulated;
    private int subAccumulated;
    private Node nodes[];
    private int auxNumberMaxNodes;
    private int numberMaxNodes;
    private int positionPermanentNode;
    private int positionEndNode;
    private String namePermanentNode;
    private String nameEndNode;


    public Dijkstra(Graph graph, String namePermanentNode, String nameEndNode) {
        this.graph = graph;
        this.positionPermanentNode =graph.returnPosition(namePermanentNode);
        this.positionEndNode=graph.returnPosition(nameEndNode);
        this.numberMaxNodes = graph.getNumberNodes();
        this.nodes = new Node[numberMaxNodes];
        this.namePermanentNode = namePermanentNode;
        this.nameEndNode = nameEndNode;
        dijkstra();
    }

    public String showDistance(String destiny){
        Node tempNode= nodes[positionEndNode];
        if(tempNode==null)return "no existe este destino";
        String msg= tempNode.getName();

        while (tempNode.getPredecessor()!=null){

            msg= tempNode.getPredecessor().getName()+ " -> "+msg;
            tempNode=tempNode.getPredecessor();
        }
        return msg;
    }
    public void dijkstra() {
        for(int i = 0; i < numberMaxNodes; i++) nodes[i] = new Node();

        if(positionPermanentNode != positionEndNode) {

            do {
                nodes[positionPermanentNode].setWasVisited(true);
                nodes[positionPermanentNode].setName(namePermanentNode);
                nodes[positionPermanentNode].setTag(true);

                subAccumulated = 0;
                auxAccumulated = Integer.MAX_VALUE;
                for (int j = 0; j < numberMaxNodes; j++) {
                    if (graph.getMatrixAdjacency(positionPermanentNode, j) == 1) {
                        subAccumulated = nodes[positionPermanentNode].getAccumulator() + graph.getMatrixCoefficient(positionPermanentNode, j);
                        if ((subAccumulated <= nodes[j].getAccumulator() && nodes[j].wasVisited() && !nodes[j].isTag()) || !nodes[j].wasVisited()) {
                            nodes[j].setAccumulator(subAccumulated);
                            nodes[j].setWasVisited(true);
                            nodes[j].setName(graph.getNameNode(j));
                            nodes[j].setPredecessor(nodes[positionPermanentNode]);
                        }
                    }
                }

                this.findNextNodePermanent();
                auxNumberMaxNodes++;
            } while (auxNumberMaxNodes < numberMaxNodes + 1);

        }
    }

    private void findNextNodePermanent() {
        for(int i = 0; i < numberMaxNodes; i++) {
            if(nodes[i].wasVisited() && !nodes[i].isTag() && nodes[i].getAccumulator() <= auxAccumulated) {
                positionPermanentNode = i;
                namePermanentNode = graph.getNameNode(i);
                auxAccumulated = nodes[i].getAccumulator();
            }
        }
    }

}
