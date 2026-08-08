class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n =nums.length;
        int count=0;
        int maxCount=0;
        for(int i =0; i< n;i++){
            if(nums[i]==0){
                count=0;
                continue;
            }
            count++;
            maxCount=Math.max(maxCount,count);
            
            
        }
        return maxCount;
    }
}