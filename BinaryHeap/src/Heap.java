public class Heap {

    int[] heap;
    //maior tamanho possivel do array
    int maxsize;
    int size;


    public Heap(int maxsize){
        this.maxsize = maxsize;
        heap = new int[this.maxsize + 1];
        this.size = 0;
        heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int position){
        return (position / 2);
    }
    private int leftChild(int position){
        return (2*position);
    }
    private int rightChild(int position){
        return ((2*position) + 1);
    }

    private void swap(int firstPosition,int secondPosition){
        int temp;
        temp = heap[firstPosition];
        heap[firstPosition] = heap[secondPosition];
        heap[secondPosition] = temp;
    }

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

    public void insert(int element){
        heap[++size] = element;
        int current = size;
        while(heap[current] > heap[parent(current)]){
            swap(current,parent(current));
            current = parent(current);
        }
    }

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
