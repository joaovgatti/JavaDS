public class Insertion {


    public void insertionSort(int a[]){
        int n = a.length;
        for(int i=1;i<n;i++){
            int valor = a[i];
            int h = i;
            while(h > 0 && a[h-1] > valor){
                a[h] = a[h-1];
                h = h-1;
            }
            a[h] = valor;
        }
    }

    void printList(int list[]){
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]+" ");
        }
    }
}
