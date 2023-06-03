package model;

public class DFS {

    private Graph graph;
    private String sourceNode;
    private String endNode;

    public DFS(Graph graph, String sourceNode, String endNode) {
        this.graph = graph;
        this.sourceNode = sourceNode;
        this.endNode = endNode;
    }

    public DFS(Graph graph) {
        this.graph = graph;
    }


    public boolean dfsConection(){
        boolean [] visited = new boolean[graph.getNodes().length];
        visited[graph.returnPosition(sourceNode)] = true;
        Stack<Node> stack = new Stack<>();
        stack.push(graph.getNodes()[graph.returnPosition(sourceNode)]);
        return dfsConection(graph.returnPosition(sourceNode), graph.returnPosition(endNode), visited, stack, graph);
    }

    private boolean dfsConection(int a, int f, boolean [] visited, Stack<Node> stack, Graph graph){
        for (int i = 0; i < visited.length; i++) {
            if(graph.getMatrixAdjacency(a, i) == 1 && i == f){
                return true;
            } else if(graph.getMatrixAdjacency(a, i) == 1 && !visited[i]) {
                stack.push(graph.getNodes()[i]);
                visited[i] = true;
                return dfsConection(i, f, visited, stack, graph);
            }
        }
        stack.pop();
        if(stack.top() != null){
            return dfsConection(graph.returnPosition(stack.top().getName()), f, visited, stack, graph);
        }
        return false;
    }

    public boolean dfsConected(){//grafo conexo
        boolean [] visited = new boolean[graph.getNodes().length];
        visited[0] = true;
        Stack<Node> stack = new Stack<>();
        stack.push(graph.getNodes()[0]);
        visited = dfsConected(0, visited, stack, graph);

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }

    private boolean [] dfsConected(int source, boolean [] visited, Stack<Node> actual, Graph graph){
        for (int i = 0; i < visited.length; i++) {
            if(graph.getMatrixAdjacency(source, i) == 1 && !visited[i]) {
                actual.push(graph.getNodes()[i]);
                visited[i] = true;
                return dfsConected(i, visited, actual, graph);
            }
        }
        actual.pop();
        if(actual.top() != null){
            return dfsConected(graph.returnPosition(actual.top().getName()), visited, actual, graph);
        }
        return visited;
    }
}
