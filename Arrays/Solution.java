public package leetcode;

/**
 * LeetCode 11: Container With Most Water
 * URL: https://leetcode.com/problems/container-with-most-water/
 * * Strategy: Two-Pointer Approach
 * Time Complexity: O(n) - Single pass through the array.
 * Space Complexity: O(1) - Constant auxiliary space.
 */
public class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            // Calculate width between the boundaries
            int width = right - left;
            
            // Water level is restricted by the shorter vertical line
            int currentHeight = Math.min(height[left], height[right]);
            
            // Calculate current area and update global maximum
            int currentArea = width * currentHeight;
            maxWater = Math.max(maxWater, currentArea);
            
            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
} containerWithMostofWater {
    
}
