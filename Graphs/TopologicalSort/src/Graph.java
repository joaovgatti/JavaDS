import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    private int v;
    private LinkedList<Integer>[] adjList;

    public Graph(int v){
        this.v = v;
        adjList = new LinkedList[v];
        for(int i=0;i<v;i++){
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v,int w){
        adjList[v].add(w);
    }

    private void topologicalSortUtil(int s, boolean[] visited, Stack<Integer> stack){
        visited[s] = true;
        for(int temp : adjList[s]){
            if(!visited[temp]){
                topologicalSortUtil(temp,visited,stack);
            }
        }
        stack.push(s);
    }

    public void topologicalSort(){
        Stack<Integer> stack  = new Stack<Integer>();
        boolean visited[] = new boolean[this.v];
        for(int i=0;i<this.v;i++){
            visited[i] = false;
        }
        for(int i=0;i<this.v;i++){
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }

        }
        while(!stack.isEmpty()){

            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args){
        Graph g = new Graph(7);
        g.addEdge(1,5);
        g.addEdge(2,3);
        g.addEdge(2,6);
        g.addEdge(3,6);
        g.addEdge(5,2);
        g.addEdge(6,4);
        //g.addEdge(0,4);
        g.topologicalSort();
    }

}
