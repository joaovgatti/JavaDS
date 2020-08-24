/**
 * This is the implementation of the Mergesort algorithm.
 * Mergesort is a optimal divide-and-conquer algorithm that runs in O(n * log n).
 * @author João Vitor Gatti Teixeira, joaogatti17@gmail.com
 */




public class Merge {

    /**
     *
     * @param arr is the array we want to order.
     */
    public void mergeSort(int arr[]){

        if(arr.length > 1){

            int meio = arr.length / 2;
            int[] left = new int[meio];
            int[] right = new int[arr.length - meio];
            for(int i=0;i<meio;i++){
                left[i] = arr[i];
            }
            for(int i=meio;i<arr.length;i++){
                right[i-meio] = arr[i];
            }
            mergeSort(left);
            mergeSort(right);
            merge(left,right,arr);
        }

    }

    /**
     *
     * @param l an ordered array.
     * @param r an ordered array.
     * @param a the array merged.
     * This method is responsible for given two ordered arrays,merges them in a new
     * sorted array.
     *
     */
        private void merge(int[] l,int[] r,int[] a){
        int i = 0;
        int j = 0;
        int k = 0;
        while( i < l.length && j < r.length){
            if(l[i] < r[j]){
                a[k] = l[i];
                i = i+1;
            }else{
                a[k] = r[j];
                j = j+1;
            }
            k = k+1;
        }
        while(i<l.length){
            a[k] = l[i];
            i = i+1;
            k = k+1;
        }
        while(j<r.length){
            a[k] = r[j];
            j = j+1;
            k = k+1;
        }
    }

    /**
     *
     * @param arr to be printed.
     * This method just print the array.
     */
    public void printlist(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+ " ");
        }
    }
}
