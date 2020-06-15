import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    //numero de vertices do grafo
    private int v;
    //array de LinkedList representando a lista de adjacencias
    private LinkedList<Integer>[] adjList;

    //Setando o grafo
    public Graph(int v){
        this.v= v;
        adjList = new LinkedList[v];
        for(int i=0;i<v;i++){
            adjList[i] = new LinkedList<>();
        }
    }

    //Adicionado as arestas entre os vertices
    //Como G nao eh direcionado eh necessario
    //add nas duas listas dos vertices
    public void addEdge(int v,int w){
        adjList[v].add(w);
        adjList[w].add(v);

    }

    //Nossa BuscaPorLargura
    public void breathFirstSearch(int s){
        //Array de boolean para impedir que o algoritmo
        //percorra vertices ja visitados
        boolean visited[] = new boolean[this.v];
        //criacao da fila onde se add os vizinhos do atual vertice
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        //quando a fila estiver vazia o algoritmo visitou todos os vertices
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

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 100)");
        g.breathFirstSearch(0);
    }





}
