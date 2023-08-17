import java.util.Arrays;

// Rotate Matrix
// Leetcode 48 -  https://leetcode.com/problems/rotate-image/
public class RotateMatrix {
    // Brute Force Approach
    static int[][] rotateMatrix(int[][] matrix){
        int n = matrix.length;
        int[][] ans = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans[j][n - 1 - i] = matrix[i][j];
            }
        }

        return ans;
    }

    // Optimal Approach
    static void swap(int[][] matrix, int a, int b){
        int temp = matrix[a][b];
        matrix[a][b] = matrix[b][a];
        matrix[b][a] = temp;
    }

    static void rotate(int[][] matrix){
        int n = matrix.length;

        // Transpose the matrix first
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                swap(matrix, i, j);
            }
        }

        // Reverse every row of the matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};

        rotate(matrix);

        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
