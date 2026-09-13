class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;
        
        // Try every possible shift in row and column directions
        for (int rowShift = -n + 1; rowShift < n; rowShift++) {
            for (int colShift = -n + 1; colShift < n; colShift++) {
                maxOverlap = Math.max(maxOverlap, countOverlap(img1, img2, rowShift, colShift));
            }
        }
        
        return maxOverlap;
    }
    
    private int countOverlap(int[][] img1, int[][] img2, int rowShift, int colShift) {
        int n = img1.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = i + rowShift;
                int y = j + colShift;
                
                // If the shifted coordinate lands inside img2
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (img1[i][j] == 1 && img2[x][y] == 1) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}