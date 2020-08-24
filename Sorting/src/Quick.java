/**
 * This is the implementation of the QuickSort algorithm.
 * Quicksort is a optimal divide-and-conquer algorithm that runs in place in O(n * log n).
 * @author João Vitor Gatti Teixeira, joaogatti17@gmail.com
 */




public class Quick {

    /**
     *
     * @param a array to be ordered.
     */
    public void quickSort(int[] a){

        quickSort(a,0,a.length-1);
    }

    /**
     *
     * @param a array to be ordered.
     * @param start first element in the array.
     * @param end last element in the array.
     */
    private void quickSort(int[] a,int start,int end){
        if(start < end){
            int pindex = partition(a,start,end);
            quickSort(a,start,pindex-1);
            quickSort(a,pindex+1,end);
        }
    }

    /**
     *
     * @param a array to be portioned.
     * @param start first element in the array.
     * @param end last element in the array.
     * @return the location of the pivot.
     */
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

    /**
     *
     * @param arr array to be printed.
     */
    public void printList(int[] arr){
        for (int j : arr) {
            System.out.println(j + " ");
        }
    }
}
