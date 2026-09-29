class Solution {
    private Boolean[][][] memo;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Total path length must be even
        if ((m + n - 1) % 2 != 0) return false;
        // Start must be '(' and end must be ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        memo = new Boolean[m][n][(m + n) / 2 + 1];
        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int open) {
        // Adjust open count for current cell
        if (grid[r][c] == '(') {
            open++;
        } else {
            open--;
        }

        // Invalid path state
        if (open < 0 || open > (m + n) / 2) return false;

        // Base case: Reached bottom-right
        if (r == m - 1 && c == n - 1) {
            return open == 0;
        }

        if (memo[r][c][open] != null) {
            return memo[r][c][open];
        }

        boolean result = false;
        // Move Down
        if (r + 1 < m) {
            result = result || dfs(grid, r + 1, c, open);
        }
        // Move Right
        if (c + 1 < n) {
            result = result || dfs(grid, r, c + 1, open);
        }

        return memo[r][c][open] = result;
    }
}