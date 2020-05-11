public class Selection {


    public void selectionsort(int lista[]){
        int n = lista.length;
        for(int i=0;i<n-1;i++){
            int min = i;
            for(int j = i+1;j<n;j++){
                if(lista[j] < lista[min]){
                    min = j;
                }
            }
            int temp = lista[min];
            lista[min] = lista[i];
            lista[i] = temp;
        }
    }


    void printList(int list[]){
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]+" ");
        }
    }


}
