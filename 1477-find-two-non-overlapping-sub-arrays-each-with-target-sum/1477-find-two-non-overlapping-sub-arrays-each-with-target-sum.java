
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        
        // Initialize with a sentinel value larger than any possible answer
        int INF = Integer.MAX_VALUE / 2;
        int minCombined = INF;
        int currentMinLen = INF;
        
        int sum = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            
            // Shrink window while sum exceeds target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            
            // Valid sub-array found
            if (sum == target) {
                int currentLen = right - left + 1;
                
                // If a valid non-overlapping sub-array exists prior to 'left'
                if (left > 0 && minLen[left - 1] != INF) {
                    minCombined = Math.min(minCombined, currentLen + minLen[left - 1]);
                }
                
                currentMinLen = Math.min(currentMinLen, currentLen);
            }
            
            // Track the minimum sub-array length seen so far up to index 'right'
            minLen[right] = currentMinLen;
        }
        
        return minCombined >= INF ? -1 : minCombined;
    }
}