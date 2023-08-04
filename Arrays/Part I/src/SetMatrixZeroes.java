import java.util.Arrays;

// Leetcode 73 - Set Matrix Zeroes
// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroes {
    // Brute Force
    static void markCol(int[][] matrix, int n, int c){
        for(int r = 0; r < n; r++){
            if(matrix[r][c] != 0) {
                matrix[r][c] = -1;
            }
        }
    }
    static void markRow(int[][] matrix, int m, int r){
        for(int c = 0; c < m; c++){
            if(matrix[r][c] != 0) {
                matrix[r][c] = -1;
            }
        }
    }
    static void setZero(int[][] matrix, int n, int m){
        // Traverse the matrix
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(matrix[r][c] == 0){
                    // Set the value of the non-zero elements of the rth row of the matrix to -1
                    markRow(matrix,  m, r);
                    // Set the value of the non-zero elements of the cth col of the matrix to -1
                    markCol(matrix, n, c);
                }
            }
        }

        // Traverse the matrix
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                // Set the values of all the -1 elements of the matrix to 0
                if(matrix[r][c] == -1){
                    matrix[r][c] = 0;
                }
            }
        }
    }

    // Better Approach
    static void setZeroBetter(int[][] matrix, int n, int m){
        // Declare two arrays - a row array of size n and a ool array of size m, both initialized with 0
        int[] row = new int[n];
        int[] col = new int[m];

        // Traverse the matrix
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                // If the [r][c]th element of the matrix is 0
                if(matrix[r][c] == 0){
                    // Set the rth element of the row array to 1
                    row[r] = 1;
                    // Set the cth element of the col array to 1
                    col[c] = 1;
                }
            }
        }

        // Traverse the matrix
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                // If the rth element of row is 1 or the cth element of col is 1
                if(row[r] == 1 || col[c] == 1) {
                    // Set the value of the [r][c]th element of the matrix to 0
                    matrix[r][c] = 0;
                }
            }
        }
    }

    // Optimal Approach
    static void setZeroOptimal(int[][] matrix, int n, int m){
        // In this approach, the 0th column of the matrix will serve the purpose of the row array
        // And the 0th row of the matrix will serve the purpose of the col array

        // Initialize a variable col0 with 1, which will serve the purpose of the col array
        int col0 = 1;

        // Traverse the array
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                // If the [r][c]th element of the matrix is 0
                if(matrix[r][c] == 0){
                    // Set the rth element of the row array, i.e. matrix[r][0] to 0
                    matrix[r][0] = 0;

                    // When c = 0, i.e. you are at the 0th column of the matrix
                    if(c != 0){
                        // Set the cth element of the col array, i.e. matrix[0][c] to 0
                        matrix[0][c] = 0;
                    }
                    else{
                        // Set the value of the col0 variable to 0
                        col0 = 0;
                    }
                }
            }
        }

        // Traverse the matrix from (1, 1) to (n - 1, m - 1)
        for(int r = 1; r < n; r++){
            for(int c = 1; c < m; c++){
                // If the rth element of the row array, i.e. matrix[r][0] is 0 or the cth element of the col array, i.e. matrix[0][c] is 0
                if(matrix[r][0] == 0 || matrix[0][c] == 0){
                    // Set the value of the [r][c]th element of the matrix to 0
                    matrix[r][c] = 0;
                }
            }
        }

        // If the value of matrix[0][0] is 0
        if(matrix[0][0] == 0){
            for(int  c = 0; c < m; c++){
                // Set the values of all the elements of the 1st row, i.e. matrix[0][c] to 0
                matrix[0][c] = 0;
            }
        }

        // If the value of col0 is 0
        if(col0 == 0){
            for(int r = 0; r < n; r++){
                // Set the values of all the elements of the 1st column, i.e. matrix[r][0] to 0
                matrix[r][0] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,1}, {1,0,1,1}, {1,1,0,1}, {0,1,1,1}};

        setZeroBetter(matrix, 4, 4);

        for(int r = 0; r < 4; r++) {
            System.out.println(Arrays.toString(matrix[r]));
        }
    }
}
