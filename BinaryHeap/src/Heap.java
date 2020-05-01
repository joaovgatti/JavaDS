/*
Implementacao maxHeap de um heap binario.
Um heap pode ser visto como um arvore binaria completa onde (maxheap) cada
no eh maior que os seus filhos e assim recursivamente.Logo nesse caso
a raiz eh o maior elemento.
*/

public class Heap {

    int[] heap;
    //maior tamanho possivel do array
    int maxsize;
    //tamanho do array conforme adiciona-se elementos
    int size;


    public Heap(int maxsize){
        this.maxsize = maxsize;
        heap = new int[this.maxsize + 1];
        this.size = 0;
        //estamos comecando o array no index 1 para simplificar
        heap[0] = Integer.MAX_VALUE;
    }

    //retorna a posicao do pai do no da posicao position
    private int parent(int position){
        return (position / 2);
    }
    //retorna a posicao do filho esquerdo do no da posicao position
    private int leftChild(int position){
        return (2*position);
    }
    //retorna a posicao do filho direito do no da posicao position
    private int rightChild(int position){
        return ((2*position) + 1);
    }

    //Esse metodo troca de valores dois nos, onde o no de maior valor
    //vai antes do de menor valor
    private void swap(int firstPosition,int secondPosition){
        int temp;
        temp = heap[firstPosition];
        heap[firstPosition] = heap[secondPosition];
        heap[secondPosition] = temp;
    }


    //esse metodo eh responsavel por "balancear" a arvore,isto e,
    //dado um no ele ve se eh maior do q seus filhos,em caso negativo
    //realiza as operacoes apropriadas para se "balancear"
    private void maxHeapify(int position){
        int largest;
        int leftSon = leftChild(position);
        int rightSon = rightChild(position);
        if(leftSon <= this.size && heap[leftSon] > heap[position]){
             largest = leftSon;
        }else{
            largest = position;
        }
        if(rightSon <= this.size && heap[rightSon] > heap[position]){
            largest = rightSon;
        }
        if(largest != position){
            swap(heap[position],heap[largest]);
            maxHeapify(largest);
        }
    }

    //metodo para adicionar um elemento
    public void insert(int element){
        heap[++size] = element;
        int current = size;
        while(heap[current] > heap[parent(current)]){
            swap(current,parent(current));
            current = parent(current);
        }
    }

    //responsavel por retornar o maior valor,
    //ou seja,a raiz heap[1]
    public int extractMax(){
        int popped = heap[1];
        heap[1] = heap[size--];
        maxHeapify(1);
        return popped;
    }

    public void print(){
        for(int i=1;i<=size/2;i++){
            System.out.println("parent: " + heap[i] + "left child: " + heap[leftChild(i)] + "right child : "
                    + heap[rightChild(i)]);
        }
    }

}
