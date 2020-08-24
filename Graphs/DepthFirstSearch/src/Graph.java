/**
 * This is the implementation of the DFS algorithm.Runs in O(v+e).
 * @author João Vitor Gatti Teixeira, joaogatti17@gmail.com
 */

import java.util.*;

public class Graph {

    private int V;
    private LinkedList<Integer> adjList[];
    public int count = 0;

    /**
     *
     * @param v is the number of vertices in the graph.
     *   Note that the underlying data structure is an array of linkedList. Its the
     *   adjacency list graph representation.
     */
    public Graph(int v){
        V = v;
        adjList = new LinkedList[V];
        for(int i=0;i<v;i++){
            adjList[i] = new LinkedList<>();
        }

    }
    /**
     *
     * @param v the vertice V
     * @param w the vertice W
     * This method adds an edge between two vertices. Its a two-way street because
     *  the graph is not directed.
     */
    void addAresta(int v,int w){
        adjList[v].add(w);
        adjList[w].add(v);
    }

    /**
     *
     * @param v any vertice to start the algorithm.
     */
    public void depthFirstSearch(int v){
        boolean visited[] = new boolean[V];
        depthFirstSearchUtil(v,visited);
    }
    private void depthFirstSearchUtil(int v,boolean visited[]){
        visited[v] = true;
        System.out.println(v+" ");
        for(int temp:adjList[v]){
            if(!visited[temp]){
                depthFirstSearchUtil(temp,visited);
            }
        }
    }

    /**
     * Gets the number of connected components in the graph.
     */
    public void numberOfConnectedComponents(){
        boolean visited[] = new boolean[V];
        int x = 0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                depthFirstSearchUtil(i,visited);
                System.out.println("---");
                x = x + 1;
            }
        }
        System.out.println("O numero de componentes conexos eh: ");
        System.out.println(x);

    }

    public static void main(String args[]){
        Graph graph = new Graph(10);
        graph.addAresta(0,1);
        graph.addAresta(0,2);
        graph.addAresta(1,3);
        graph.addAresta(1,2);
        graph.addAresta(5,4);

        graph.numberOfConnectedComponents();


    }









}
