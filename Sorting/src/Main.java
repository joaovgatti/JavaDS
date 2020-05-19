public class Main {


    public static void main(String[] args){

        int lista[] = {3};
        int lista2[] = {102,33,273,11,3,283,44,22,293,945,1,45};

        Quick quick = new Quick();
        quick.quickSort(lista2);
        quick.printList(lista2);

    }
}
