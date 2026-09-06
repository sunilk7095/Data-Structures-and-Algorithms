class Solution {
    public void moveZeroes(int[] nums) {
        int idx=0;
        int i = 0;
        while( i < nums.length){
            if(nums[i] != 0){
                nums[idx] =nums[i];
                idx++;
                
            }
            i++;
        }

        while(idx < nums.length){
            nums[idx] = 0;
            idx++;
        }
    }
}