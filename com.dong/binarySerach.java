import java.nio.charset.MalformedInputException;

public class binarySerach {
    public static void main(String[] args) {
         int[] arr = {10, 14, 21, 38, 45, 47, 53, 81, 87, 99};
        int index = binarySerachon(arr, 38);
        System.out.println(index);
    }

    private static int binarySerachon(int[] arr, int i) {
        //start end
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int mid=(start+ end)/2;
        }
        return -1;
    }
}
