import java.util.ArrayList;

public class PascalTriangle {
    // Variation 1 - Given r and c, find the element at the rth row and cth column of the Pascal's Triangle
    static int findElement(int r, int c){
        int ans = 1;

        for(int i = 0; i < c; i++){
            ans  = ans * (r - i);
            ans = ans / (i + 1);
        }

        return ans;
    }

    // Variation 2 - Given r, print the rth row of the Pascal's Triangle
    // Leetcode 119 - Pascal's Triangle II
    static ArrayList<Integer> printRow(int r){

        ArrayList<Integer> row = new ArrayList<Integer>();
        long ans = 1;
        row.add((int)ans); // Add 1 to the row just after declaring it, because the first element in each row of the Pascal Triangle is always 1

        // If you are asked to find the 0th row
        if(r == 0){
            // Print the ArrayList
            return row;
        }

        for(int i = 1; i <= r; i++){
            ans = ans * (r - i + 1);
            ans = ans / i;
            row.add((int)ans);
        }
        return row;
    }

    // Variaton 3 - Given number of rows, print the Pascal's Triangle
    // Leetcode 118 - Pascal's Triangle
    static ArrayList<ArrayList<Integer>> printPascalTriangle(int numberOfRows){
        // Declare an ArrayList of type ArrayList<Integer> which will store all the rows of the Pascal's Triangle
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();

        for(int i = 1; i <= numberOfRows; i++){
            // Declare an ArrayList of type Integer which will store one row at a time
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            long ans = 1;
            tempList.add((int)ans);
            for(int j = 1; j < i; j++){
                ans = ans * (i - j);
                ans = ans / j;
                // Add the element of the row to the tempList
                tempList.add((int)ans);
            }
            // After each inner iteration, add the tempList to the finalList
            finalList.add(tempList);
        }

        return finalList;
    }

    public static void main(String[] args) {
        System.out.println(printPascalTriangle(6));
    }
}
