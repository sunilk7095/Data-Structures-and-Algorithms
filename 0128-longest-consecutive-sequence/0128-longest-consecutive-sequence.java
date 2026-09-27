class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n < 1) return 0;
        Arrays.sort(nums);
        int lastSmallest =Integer.MIN_VALUE;
        int count =0;
        int largest = 1;
        for(int i =0; i< n; i++){
            if((nums[i] -1) == lastSmallest){
                count++;
                lastSmallest = nums[i];
            }else if(lastSmallest != nums[i]){
                count=1;
                lastSmallest = nums[i];
            }
            largest = Math.max(largest,count);
        }
        return largest;
    }
}