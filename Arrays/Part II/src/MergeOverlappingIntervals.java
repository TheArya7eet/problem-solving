import java.util.ArrayList;
import java.util.Arrays;

// Merge Overlapping Intervals
// Leetcode 56 - https://leetcode.com/problems/merge-intervals/
public class MergeOverlappingIntervals {
    // Brute Force Approach
    static int[][] merge(int[][] arr){
        int n = arr.length;
        // Declare an ArrayList of type int[] which will store our result
        ArrayList<int[]> ans = new ArrayList<>();

        // Sort the 'arr'
        Arrays.sort(arr, (int[] a,int[] b) -> a[0] - b[0]);

        // Run a loop i from 0 to n (exclusive)
        for(int i = 0; i < n; i++){
            // Declare and initialise 2 variables
            // 'start' which will store the first element of the ith (current) interval
            int start = arr[i][0];
            // 'end' which will store the last element of the ith (current) interval
            int end = arr[i][1];

            // If the 'ans' list is not empty AND the last element of the ith (current) interval is less than or equal to the last element of the previous interval in the 'ans' list
            // That means the ith interval already overlaps in the previous interval of the list
            if(!ans.isEmpty() && end <= ans.get(ans.size() - 1)[1]){
                continue;
            }

            // For each interval i, run a loop j and check the rest of the intervals (i.e. from i + 1 to n - 1) that can be merged with the selected/current interval
            for(int j = i + 1; j < n; j++){
                // If the first element of the jth interval is less than the last element of the current interval (i.e. start)
                if(arr[j][0] <= end){
                    // Update end as the maximum value between the two -  end and the last element of the jth interval
                    end = Math.max(end, arr[j][1]);
                }
                // Else
                else{
                    // No need to merge and break out of the loop
                    break;
                }
            }
        // Add the 'start' and 'end' as array elements to the ans list.
        ans.add(new int[] {start, end});
        }

        return ans.toArray(new int[0][]);
    }

    // Optimal Approach
    static int[][] mergeIntervals(int[][] arr){
        int n = arr.length;
        // Declare an ArrayList of type int[] which will store our result
        ArrayList<int[]> ans = new ArrayList<>();

        // Sort the 'arr'
        Arrays.sort(arr, (int[] a,int[] b) -> Integer.compare(a[0], b[0]));

        // Run a loop i from 0 to n (exclusive)
        for(int i = 0; i < n; i++){
            // If the 'ans' list is empty OR the ith (current) interval's first element is greater than the last element of the previous interval in the list
            // That means either there has occurred no merging OR the current interval cannot be merged with the
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1)[1]){
                // Add the interval to the 'ans' list
                ans.add(arr[i]);
            }
            // Else
            // If the current interval can be added to the previous interval of the list
            else{
                // Set the value of last element of the previous interval in the 'ans' list as the maximum of the last element of the previous interval and the last element of the ith (current) interval
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], arr[i][1]);
            }
        }

        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2}, {2,6}, {8,9}, {8,11}, {2,4}, {8,10}, {15,18}, {16,17}};
        arr = mergeIntervals(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
