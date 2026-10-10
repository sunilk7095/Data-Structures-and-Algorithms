import java.util.TreeMap;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long totalOps = (long) k1 + k2;
        TreeMap<Integer, Long> map = new TreeMap<>();
        
        // Step 1: Compute absolute differences and store frequencies
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > 0) {
                map.put(diff, map.getOrDefault(diff, 0L) + 1L);
            }
        }
        
        // Step 2: Greedily reduce the largest differences
        while (totalOps > 0 && !map.isEmpty()) {
            int maxDiff = map.lastKey();
            long count = map.get(maxDiff);
            
            // Number of operations needed to reduce all 'maxDiff' elements down to the next lower difference
            Integer nextDiff = map.lowerKey(maxDiff);
            long targetDiff = (nextDiff == null) ? 0 : nextDiff;
            
            long diffSpan = maxDiff - targetDiff;
            long opsNeeded = diffSpan * count;
            
            if (totalOps >= opsNeeded) {
                // We have enough operations to reduce all elements at maxDiff down to targetDiff
                map.remove(maxDiff);
                totalOps -= opsNeeded;
                if (targetDiff > 0) {
                    map.put((int) targetDiff, map.getOrDefault((int) targetDiff, 0L) + count);
                }
            } else {
                // We run out of operations partway through reducing maxDiff
                long steps = totalOps / count;
                long remainder = totalOps % count;
                
                map.remove(maxDiff);
                int reducedDiff = (int) (maxDiff - steps);
                map.put(reducedDiff, map.getOrDefault(reducedDiff, 0L) + count - remainder);
                
                int smallerDiff = reducedDiff - 1;
                if (smallerDiff > 0 && remainder > 0) {
                    map.put(smallerDiff, map.getOrDefault(smallerDiff, 0L) + remainder);
                }
                
                totalOps = 0; // Budget exhausted
            }
        }
        
        // Step 3: Calculate the final sum of squared differences
        long minSumSquaredDiff = 0;
        for (var entry : map.entrySet()) {
            long diff = entry.getKey();
            long count = entry.getValue();
            minSumSquaredDiff += diff * diff * count;
        }
        
        return minSumSquaredDiff;
    }
}