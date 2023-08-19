import java.util.Arrays;

// Find a duplicate number in an array of N + 1 integers
// Leetcode 287 - https://leetcode.com/problems/find-the-duplicate-number/
public class FindDuplicateNumber {
    // Brute Force Approach
    static int findDuplicateBrute(int[] arr){
        // Sort the array
        Arrays.sort(arr);

        // Traverse the array
        for(int i = 0; i < arr.length; i++){
            // At any point while traversing the array, if the current element is equal to the next element
            if(arr[i] == arr[i + 1]){
                // We have found the duplicate element, return it
                return arr[i];
            }
        }

        // If there is no duplicate element, return -1
        return -1;
    }

    // Better Approach
    static int findDuplicateBetter(int[] arr){
        // Create an array of the same size as that of arr, initialised with 0
        int[] tempArr = new int[arr.length];

        // Traverse the given array arr
        for(int i = 0; i < arr.length; i++){
            // At each traversal, if the arr[i]th index element of tempArr is initially 0
            if(tempArr[arr[i]] == 0) {
                // update the value of the (arr[i])th of the tempArr to 1
                tempArr[arr[i]] = 1;
            }
            else{
                // if the arr[i]th index element of tempArr is not 0, that means it has been already updated
                // Hence, we have found the duplicate element, return it
                return arr[i];
            }
        }

        // If there is no duplicate element, return -1
        return -1;
    }

    // Optimal Approach - Linked List Cycle Method
    static int findDuplicate(int[] arr){
        // Declare two pointers - slow and fast, both initialised with the first element of the arr
        int slow = arr[0], fast = arr[0];

        do{
            // Move the slow pointer by 1
            slow = arr[slow];
            // Move the fast pointer by 2
            fast = arr[arr[fast]];
        } while( slow != fast);

        // Move the fast pointer to the first position, i.e. the 0th index
        fast = arr[0];
        // Until slow is not equal to fast, move both of the pointers by 1
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }

        // When slow and fast pointers become equal, the loop will end
        // This means that the duplicate number has been found
        // Hence, return either the slow or the fast pointer

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,9,6,9,3,8,9,7,1};

        System.out.println(findDuplicate(arr));
    }

}
