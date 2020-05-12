public class Main {


    public static void main(String[] args){

        int lista[] = {13,2,3,5};

        Selection s1 = new Selection();
        Insertion s2 = new Insertion();
        //s1.selectionsort(lista);
        s2.insertionSort(lista);
        System.out.println("Lista ordenada");
        s2.printList(lista);


    }
}
