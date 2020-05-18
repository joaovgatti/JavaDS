public class Merge {


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

    public void printlist(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+ " ");
        }
    }
}
