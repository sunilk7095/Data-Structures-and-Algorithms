class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;       // Rows
        int m = matrix[0].length;    // Columns

        boolean firstColHasZero = false;

        // Step 1: Mark zeroes in the first row and first column
        for (int i = 0; i < n; i++) {
            // Check if 1st column originally has a 0
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
            }

            // Check remaining columns and mark flags in 1st row and 1st col
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Use flags to update the inner matrix (excluding row 0 and col 0)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Handle 1st row based on matrix[0][0]
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Handle 1st column based on our boolean flag
        if (firstColHasZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}