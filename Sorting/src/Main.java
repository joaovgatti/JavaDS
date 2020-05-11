public class Main {


    public static void main(String[] args){

        int lista[] = {10,9,111,222,1,32,3,43,4,2};
        Selection s1 = new Selection();
        s1.selectionsort(lista);
        System.out.println("Lista ordenada");
        s1.printList(lista);


    }
}
