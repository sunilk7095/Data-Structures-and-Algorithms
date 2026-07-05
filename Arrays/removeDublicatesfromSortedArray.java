/**
 * Problem No: 26
 * Problem Title: Remove Duplicates from Sorted Array
 * URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * - Time Complexity: O(n)
 * - Where 'n' is the length of the array. We iterate through the array exactly once.
 * - Space Complexity: O(1)
 * - Constant extra space is used since we modify the array in-place.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: if the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }
        
        // 'i' keeps track of the index of the last unique element found
        int i = 0;
        
        // 'j' scans through the array to look for new unique elements
        for (int j = 1; j < nums.length; j++) {
            // If we find a value different from the current unique element
            if (nums[j] != nums[i]) {
                i++;             // Move the unique pointer forward
                nums[i] = nums[j]; // Update the next position with the new unique value
            }
        }
        
        // The number of unique elements is the index 'i' + 1
        return i + 1;
    }
}