import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse Right (Top row)
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move top boundary down

            // 2. Traverse Down (Rightmost column)
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move right boundary left

            // 3. Traverse Left (Bottom row, if top boundary hasn't passed bottom)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move bottom boundary up
            }

            // 4. Traverse Up (Leftmost column, if left boundary hasn't passed right)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move left boundary right
            }
        }

        return result;
    }
}