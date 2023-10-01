import java.lang.reflect.Array;
import java.util.ArrayList;

// Repeat and Missing Number Array
// InterviewBit - https://www.interviewbit.com/problems/repeat-and-missing-number-array/
public class RepeatAndMissingNumberArray {
    // Brute Force Approach
    static int[] findRepeatingAndMissingBrute(int[] arr){
        int repeating = -1, missing = -1;

        for(int i = 1; i <= arr.length; i++){
            // Declare a 'count' variable which will keep a track of an element if it is repeated in the array
            int count = 0;

            for(int j = 0; j < arr.length; j++){
                if(arr[i] == i){
                    count++;
                }
            }

            // If count = 2, after the j loop ends
            if(count == 2){
                // Repeated Element has been found
                repeating = i;
            }
            // If count = 0, after the j loop ends
            else if(count == 0){
                // Missing Element has been found
                missing = i;
            }
            if(repeating != -1 && missing != -1){
                break;
            }
        }

        return new int[] {repeating, missing};
    }

    // Better Approach
    static ArrayList<Integer> findRepeatingAndMissingBetter(int[] arr){
        // Create a temporary frequency array
        int[] tempArr = new int[arr.length + 1];

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            tempArr[arr[i]]++;
        }

        for(int i=1; i < tempArr.length; i++){
            if(tempArr[i] == 2){
                // Repeating number found
                ans.add(i);
            }
            if(tempArr[i] == 0){
                // Missing number found
                ans.add(i);
            }
        }

        return ans;
    }

    // Optimal Approach 1
    static int[] findRepeatAndMissing(int[] arr){
        long n = arr.length;

        // Find Sn and S2n
        long Sn = (n * (n + 1))/2;
        long S2n = (n * (n + 1) * (2 * n + 1))/6;

        // Calculate S and S2
        long S = 0, S2 = 0;
        for(int i = 0; i < arr.length; i++){
            S += (long)arr[i];
            S2 += (long)arr[i] * (long)arr[i];
        }

        // S - Sn = x - y
        long val1 = S - Sn;

        // S2 - S2n = x^2 - y^2
        long val2 = S2 - S2n;

        // Find x + y = (x^2 - y^2) / (x - y)
        val2 = val2 / val1;

        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[] {(int)x, (int)y};
    }

    public static void main(String[] args) {
        int[] arr = {4,3,6,2,1,1};

        System.out.println(findRepeatingAndMissingBetter(arr));
    }
}
