import java.util.Arrays;

public class Main {


    public static void main(String[] args){

        int[] arr = {10,2,3,23,1,7,4,5,9,0};
        Quick quick = new Quick();
        quick.quickSort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
