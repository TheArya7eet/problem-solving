import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Merge Sorted Arrays
// Leetcode 88 - https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArrays {
    // Brute Force Approach
    static ArrayList<Integer> mergeSortedArrays(int[] arr1, int n, int[] arr2, int m){
        // Sort the two arrays first
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Declare a List of type int[] which will be the final result
        ArrayList<Integer> ans = new ArrayList<>();

        // Declare two pointers left and right
        // left will point the elements of arr1
        // right will point the elements of arr2
        int left = 0, right = 0;
        while(left < n && right < m){
            if(arr1[left] < arr2[right]){
                ans.add(arr1[left]);
                left++;
            }
            else{
                ans.add(arr2[right]);
                right++;
            }
        }

        // After adding the elements in order, if any of the pointers i or j is not equal to n - 1 or m - 1 respectively,
        // Add the rest of them
        while(left < n){
            ans.add(arr1[left]);
            left++;
        }
        while(right < m){
            ans.add(arr2[right]);
            right++;
        }

        // Fill back the elements in sorted order from arr3 to arr1 and arr2
        for(int i = 0; i < ans.size(); i++){
            if(i < n){
                arr1[i] = ans.get(i);
            }
            else{
                arr2[i - n] = ans.get(i);
            }
        }

        return ans;
    }

    // Optimal Approach 1 -  Using two pointers
    static void swap(int[] arr1, int[] arr2, int a, int b){
        int temp = arr1[a];
        arr1[a] = arr2[b];
        arr2[b] = temp;
    }

    static void merge(int[] arr1, int n, int[] arr2, int m){
        // Declare 2 pointers 'left' and 'right'
        // 'left' will point to the last element of arr1
        int left = n - 1;
        // 'right' will  point to the first element of arr2
        int right = 0;

        while(left >= 0 && right < n){
            if(arr1[left] > arr2[right]){
                swap(arr1, arr2, left, right);
                left--;
                right++;
            }
            else{
                break;
            }
        }

        // Sort the 2 arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // Optimal Approach 2 - If any of the array contains empty spaces as 0s
    static void merge2SortedArrays(int[] arr1, int n, int[] arr2, int m){
        // End index of arr1
        int i = n - 1;
        // End index of arr2
        int j = m - 1;
        // End index of the merged and sorted array
        int k = m + n - 1;

        // Run a loop j until j becomes less than or equal to 0
        while (j >= 0) {
            // If i >= 0 and the ith element of arr1 is greater than the jth element of arr2
            if (i >= 0 && arr1[i] > arr2[j]) {
                // Assign the ith element in the kth index of arr1
                // And decrement both k and i
                arr1[k--] = arr1[i--];
            } else {
                // Assign the jth element in the kth index of arr1
                // And decrement both k and j
                arr1[k--] = arr2[j--];
            }
        }
    }

    // Optimal Approach 3 - Gap Method
    static void swapIfGreater(int[] arr1, int[] arr2, int left, int right){
        if(arr1[left] > arr2[right]){
            swap(arr1, arr2, left, right);
        }
    }
    static void mergeUsingGap(int[] arr1, int n, int[] arr2, int m){
        int len = (n + m);
        int gap = (len / 2) + (len % 2);
        while(gap > 0){
            int left = 0;
            int right = left + gap;

            while(right < len){
                // arr1 and arr2
                if(left < n && right >= n){
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // arr2 and arr2
                else if(left >= n){
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // arr1 and arr1
                else if(right < n){
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) {
                break;
            }
            else{
                gap = (gap / 2) + (gap % 2);
            }
        }
    }

    public static void main(String[] args) {

        int[] arr1 = new int[] {1,3,5,7,0,0,0,0};

        int[] arr2 = new int[] {2,6,8,9};

        merge2SortedArrays(arr1, 4, arr2, 4);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
    }
}
