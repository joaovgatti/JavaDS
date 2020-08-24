/**
This class implements the Priority Queue ADT with a Binary Heap.
 @author João Vitor Gatti Teixeira, joaogatti17@gmail.com
**/

public class Heap {

    private int[] heap;

    private int maxsize;

    private int size;

    /**
     *
     * @param maxsize -> tamanho do array.
     */
    public Heap(int maxsize){
        this.maxsize = maxsize;
        heap = new int[this.maxsize + 1];
        this.size = 0;
        //estamos comecando o array no index 1 para simplificar
        heap[0] = Integer.MAX_VALUE;
    }

    /**
     *
     * @param position of the current element.
     * @return  a posicao do pai do no da posicao position
     */
    private int parent(int position){
        return (position / 2);
    }

    /**
     *
     * @param position of the current element.
     * @return the position of the left child.
     */
    private int leftChild(int position){
        return (2*position);
    }

    /**
     *
     * @param position of the current element.
     * @return the position of the left child.
     */
    private int rightChild(int position){
        return ((2*position) + 1);
    }


    /**
     *
     * @param firstPosition to swap
     * @param secondPosition to swaṕ
     * This method simply changes the values of two given nodes.
     */
    private void swap(int firstPosition,int secondPosition){
        int temp;
        temp = heap[firstPosition];
        heap[firstPosition] = heap[secondPosition];
        heap[secondPosition] = temp;
    }

    /**
     *
     * @param position to Start the maxHeapify.
     * This method is responsable for "balance" the tree,
     * check if a node is bigger than his sons.
     */
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

    /**
     *
     * @param element to be Inserted.
     * This method inserts an element in the heap.
     */
    public void insert(int element){
        heap[++size] = element;
        int current = size;
        while(heap[current] > heap[parent(current)]){
            swap(current,parent(current));
            current = parent(current);
        }
    }

    /**
     *
     * @return the max value in the heap, which is the root.
     */
    public int extractMax(){
        int popped = heap[1];
        heap[1] = heap[size--];
        maxHeapify(1);
        return popped;
    }

    /**
     * Print the array representing the heap.
     */
    public void print(){
        for(int i=1;i<=size/2;i++){
            System.out.println("parent: " + heap[i] + "left child: " + heap[leftChild(i)] + "right child : "
                    + heap[rightChild(i)]);
        }
    }

}
