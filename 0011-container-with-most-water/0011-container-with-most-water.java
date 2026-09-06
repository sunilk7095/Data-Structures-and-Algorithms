class Solution {
    public int maxArea(int[] height) {
        int i =0;
        int j =height.length-1;
        int max=0;
        while(i<j){
            int min = Math.min(height[i], height[j]);
            int ans = min * (j-i);
            max = Math.max(ans, max);
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return max;
    }
}