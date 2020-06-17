import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    //Representando o grafo com uma lista de adjacencias
    private int v;
    private LinkedList<Integer>[] adjList;

    public Graph(int v){
        this.v = v;
        adjList = new LinkedList[v];
        for(int i=0;i<v;i++){
            adjList[i] = new LinkedList<>();
        }
    }

    //Como eh um grafo direcionado,o metodo para add
    //uma aresta eh de mao unica.
    public void addEdge(int v,int w){
        adjList[v].add(w);
    }

    /*
    * Esta eh uma funcao auxiliar, que desempenha o papel de uma DFS
    * para ir adicionando os vertices na stack*/
    private void topologicalSortUtil(int s, boolean[] visited, Stack<Integer> stack){
        //visita-se o vertice em questao
        visited[s] = true;
        //visita-se de forma recursiva todos os vizinhos do vertice atual
        for(int temp : adjList[s]){
            if(!visited[temp]){
                topologicalSortUtil(temp,visited,stack);
            }
        }
        //adiciona-se o vertice na stack para a busca topologica
        stack.push(s);
    }

    public void topologicalSort(){
        //Cria-se a stack para armazenar os vertices
        Stack<Integer> stack  = new Stack<Integer>();
        //Array de boolean para nao visitar um no ja visitado
        boolean visited[] = new boolean[this.v];
        //inicializa cada entrada do array como falso
        for(int i=0;i<this.v;i++){
            visited[i] = false;
        }
        //para cada vertice nao visitado ele realiza uma dfs para visitar os outros
        for(int i=0;i<this.v;i++){
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }

        }
        //aqui a stack ja esta com todos os vertices ( sem repetidos)
        //logo eh so desempilhar e teremos uma ordenacao topologica
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
        g.addEdge(0,4);
        g.topologicalSort();
    }

}
