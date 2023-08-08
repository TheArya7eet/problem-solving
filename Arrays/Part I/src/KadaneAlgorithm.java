// Leetcode 53 - Maximum Sub-array
// https://leetcode.com/problems/maximum-subarray/
public class KadaneAlgorithm {
    // Brute Force Approach
    static int maxSubArraySum(int[] arr){
        // Declare a maxSum variable which will store the maximum sub-array sum, initialized with Integer.MIN_VALUE
        int maxSum = Integer.MIN_VALUE;

        // Run a loop i that will select every possible starting index of the sub-array
        for(int i = 0; i < arr.length; i++){
            // Run a loop j that will signify the ending index of the sub-array (ending index might vary from i to arr.length - 1)
            for(int j = i; j < arr.length; j++){
                // Declare a variable sum initialized with 0
                int sum = 0;
                // Run a loop k from i to j which will signify each sub-array starting from index i and ending at index j
                for(int k = i; k <= j; k++){
                    sum += arr[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }

    // Better Approach
    static int maxSubArraySumBetter(int[] arr){
        // Declare a maxSum variable which will store the maximum sub-array sum, initialized with Integer.MIN_VALUE
        int maxSum = Integer.MIN_VALUE;

        // Run a loop i that will select every possible starting index of the sub-array
        for(int i = 0; i < arr.length; i++){
            // Declare a variable sum initialized with 0
            int sum = 0;

            // Run a loop j that will signify the ending index of the sub-array (ending index might vary from i to arr.length - 1)
            for(int j = i; j < arr.length - 1; j++){
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }

    // Optimal Approach - Kadane's Algorithm
    static int KadanesAlgorithm(int[] arr){
        // Declare a maxSum variable which will store the maximum sub-array sum, initialized with Integer.MIN_VALUE
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            // If sum > maxSum, set value of sum in maxSum
            maxSum = Math.max(sum, maxSum);
            // If sum < 0, we will set the value of sum again to 0 as we will not consider its negative value in our answer
            if(sum < 0){
                sum = 0;
            }
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(maxSubArraySumBetter(arr));
    }
}
