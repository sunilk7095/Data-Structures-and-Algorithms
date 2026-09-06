class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0;
        int sumLeft = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            // Right sum = totalSum - sumLeft - nums[i]
            if (sumLeft == totalSum - sumLeft - nums[i]) {
                return i;
            }
            sumLeft += nums[i];
        }

        return -1;
    }
}