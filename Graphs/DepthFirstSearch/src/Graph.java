import java.util.*;

public class Graph {

    private int V;
    private LinkedList<Integer> adjList[];

    public Graph(int v){
        V = v;
        adjList = new LinkedList[V];
        for(int i=0;i<v;i++){
            adjList[i] = new LinkedList<>();
        }

    }

    void addAresta(int v,int w){
        adjList[v].add(w);
        adjList[w].add(v);
    }


    public void depthFirstSearch(int v){
        boolean visited[] = new boolean[V];
        depthFirstSearchUtil(v,visited);
    }

    private void depthFirstSearchUtil(int v,boolean visited[]){
        visited[v] = true;
        System.out.println(v+" ");
        for(int temp:adjList[v]){
            System.out.println("i eh "+ temp);
            if(!visited[temp]){
                depthFirstSearchUtil(temp,visited);
            }
        }
    }



    public static void main(String args[]){
        Graph graph = new Graph(100);
        graph.addAresta(0,1);
        graph.addAresta(0,2);
        graph.addAresta(2,10);
        graph.addAresta(10,90);
        graph.addAresta(0,4);
        graph.depthFirstSearch(0);
        
    }









}
