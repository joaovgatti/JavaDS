/**
 * This is the implementation of the famous Breadth First Search algorithm.
 * The algorithm traversals the graph in a levels fashion.
 * Runs in O(V+E).
 * @author João Vitor Gatti Teixeira, joaogatti17@gmail.com
 */

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    //numero de vertices do grafo
    private int v;
    //array de LinkedList representando a lista de adjacencias
    private LinkedList<Integer>[] adjList;

    /**
     *
     * @param v is the number of vertices in the graph.
     *  Note that the underlying data structure is an array of linkedList. Its the
     *  adjacency list graph representation.
     */
    public Graph(int v){
        this.v= v;
        adjList = new LinkedList[v];
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
    public void addEdge(int v,int w){
        adjList[v].add(w);
        adjList[w].add(v);

    }

    /**
     *
     * @param s the vertice the algorithm will begin. It can be any.
     */
    public void breathFirstSearch(int s){
        boolean visited[] = new boolean[this.v];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while(!queue.isEmpty()){
            s = queue.poll();
            System.out.println(s + " ");
            for (int item : adjList[s]){
                if(!visited[item]){
                    visited[item] = true;
                    queue.add(item);
                }
            }
        }
    }

    public static void main(String[] args){
        Graph g = new Graph(14);
        g.addEdge(0,7);
        g.addEdge(0,9);
        g.addEdge(0,11);
        g.addEdge(1,10);
        g.addEdge(1,8);
        g.addEdge(2, 12);
        g.addEdge(2 ,3);
        g.addEdge(3, 4);
        g.addEdge(3,7);
        g.addEdge(5,6);
        g.addEdge(6,7);
        g.addEdge(7,11);
        g.addEdge(8,12);
        g.addEdge(8,9);
        g.addEdge(9,10);

        System.out.println("Graph Traversal:  " + "(starting from vertex 0)");
        g.breathFirstSearch(0);
    }
}
