public class Quick {

    public void quickSort(int[] a){
        quickSort(a,0,a.length-1);
    }

    private void quickSort(int[] a,int start,int end){
        if(start < end){
            int pindex = partition(a,start,end);
            quickSort(a,start,pindex-1);
            quickSort(a,pindex+1,end);
            //printList(a);
        }
    }
    private int partition(int[] a,int start,int end){
        int pivot = a[end];
        int pindex = start;
        for(int i=start;i<end;i++){
            if(a[i] <= pivot){
                int temp = a[i];
                a[i] = a[pindex];
                a[pindex] = temp;
                pindex = pindex + 1;
            }
        }
        int temp2 = a[pindex];
        a[pindex] = a[end];
        a[end] = temp2;
        return pindex;
    }

    public void printList(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+ " ");
        }
    }
}
