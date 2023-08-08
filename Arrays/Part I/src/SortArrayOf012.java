import java.util.Arrays;

// Sort Array of 0s, 1s and 2s
// Leetcode 75 - https://leetcode.com/problems/sort-colors/
public class SortArrayOf012 {
    // Better Approach -
    static void sort(int[] arr){
        // Initialize 3 variables count0, count1 and count2 with 0, 1 and 2 respectively
        int count0 = 0, count1 = 1, count2 = 2;

        for(int i = 0; i < arr.length; i++){
            // If arr[i] = 0
            if(arr[i] == 0){
                // Increment count0 by 0
                count0++;
            }
            // If arr[i] = 1
            else if(arr[i] == 1){
                // Increment count1 by 1
                count1++;
            }
            // If arr[i] = 2
            else if(arr[i] == 2){
                // Increment count2 by 1
                count2++;
            }
        }

        // Traverse the array from index 0 to count0 (exclusive) and set value of arr[i] to 0
        for(int i = 0; i < count0; i++){
          arr[i] = 0;
        }
        // Traverse the array from index count0 to count1 (exclusive) and set value of arr[i] to 1
        for(int i = count0; i < count1; i++){
            arr[i] = 1;
        }
        // Traverse the array from index count1 to arr.length (exclusive) and set value of arr[i] to 2
        for(int i = count1; i < arr.length; i++){
            arr[i] = 2;
        }
    }

    // Optimal Approach - Dutch National Flag Algorithm
    // In this algorithm, these are the points to remember
    // (0 -> low - 1) elements are all 0s
    // (low -> mid - 1) elements are all 1s
    // (mid -> high) elements are 0s, 1s and 2s in unsorted manner
    // (high + 1 -> arr.length - 1) elements are all 2s

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int[] sortArray(int[] arr){
        int low = 0, mid = 0, high = arr.length - 1;

        while(mid <= high){
            // If arr[mid] = 0
            if(arr[mid] == 0){
                // Swap arr[low] and arr[mid]
                swap(arr, low, mid);
                // Increment both low and mid by 1
                low++;
                mid++;
                // Now the sub-array from index 0 to (low-1) contains only 0s
            }

            else if(arr[mid] == 1){
                // Don't swap
                // Increment mid by 1
                mid++;
                // Now the sub-array from low to (mid - 1) contains only 1s
            }

            else if(arr[mid] == 2){
                // Swap arr[mid] and arr[high]
                swap(arr, mid, high);
                // Decrement high by 1
                high--;
                // Now the sub-array from (high + 1) to (arr.length - 1) contains only 2s
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2,1,2,0,0,0,1};

        System.out.println(Arrays.toString(sortArray(arr)));
    }
}
