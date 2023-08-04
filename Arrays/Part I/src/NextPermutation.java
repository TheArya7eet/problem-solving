import java.util.Arrays;

// Leetcode 31 - Next Permutation
public class NextPermutation {
    static void reverseArray(int[] arr, int start, int end){
        int i = start, j = end - 1;
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void nextPermutation(int[] arr){
        // Declare a variable ind which will store the break point index, initialised with -1
        int ind = -1;

        // Traverse the array in order to find the break point
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] < arr[i + 1]){
                // Index i is the break point
                ind = i;
                break;
            }
        }

        // If, after the above traversal, ind = -1
        // That means no arr[i + 1] is greater than arr[i]
        // That means no break point exists, and it is the last possible permutation
        // Hence, the next permutation of this array will be the array reversed
        if(ind == -1){
            // Reverse the whole array
            reverseArray(arr, 0, arr.length);
            return;
        }

        // Find the element which is just greater than the break point element and swap them
        for(int i = arr.length - 1; i > ind; i--){
            if(arr[i] > arr[ind]){
                swap(arr, i, ind);
                break;
            }
        }

        // Finally, reverse the sub-array from index (ind + 1) to (arr.length - 1)
        // Hence we will get the next permutation of the given array
        reverseArray(arr, ind + 1, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,4,3,0,0};
        nextPermutation(arr);

        System.out.println(Arrays.toString(arr));
    }
}
