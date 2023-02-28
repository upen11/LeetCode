package Top100Liked;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    // {1, 2, 3 ,4 ,5}
    // T.C : O(n)
    // S.C : O(1)

    public static int[] productExceptSelf(int[] arr) {

        int[] output = new int[arr.length];

        // first output stores the left product of array expect the ith element
        output[0] = 1;
        for(int i=1; i<arr.length; i++) {
            output[i] = arr[i-1] * output[i-1];
        }

        // we move from right and with the help of rightProduct and output arr(which stores left arr product) find the output
        int rightProduct = 1;
        for(int i=arr.length-1; i>=0; i--) {
            output[i] = output[i] * rightProduct;
            rightProduct *= arr[i];
        }

        return output;
    }

    // T.C : O(n)
    // S.C : O(n)
    public static int[] productExceptSelf2(int[] arr) {

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        int[] output = new int[arr.length];

        int product = 1;
        for(int i=0; i<arr.length; i++) {
            product *= arr[i];
            left[i] = product;
        }

        product = 1;
        for(int i=arr.length-1; i>=0; i--) {
            product *= arr[i];
            right[i] = product;
        }

        output[0] = right[1];
        output[arr.length-1] = left[arr.length-2];

        for(int i=1; i<arr.length-1; i++) {
            output[i] = left[i-1] * right[i+1];
        }

        return output;
    }

    public static void main(String[] args) {

        int[] arr1 = {1,2, 1, 2, 1}; // O/P: [4, 2, 4, 2, 4]
        int[] arr2 = {1, 2, 2, 3, 1};   // O/P: [12, 6, 6, 4, 12]
//        int[] arr3 = {1,2,2,3,1,4,2};   // O/P: [96, 48, 48, 32, 96, 24, 48]
        int[] arr3 = {1, 2, 3 ,4 ,5};   // O/P: [120, 60, 40, 30, 24]
//        int[] arr3 = {-1, 1, 0, -3, 3}; // O/P: [0, 0, 9, 0, 0]

        System.out.println(Arrays.toString(productExceptSelf(arr1)));
        System.out.println(Arrays.toString(productExceptSelf(arr2)));
        System.out.println(Arrays.toString(productExceptSelf(arr3)));
    }
}
