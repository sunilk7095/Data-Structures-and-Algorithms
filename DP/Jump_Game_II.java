class Solution {
    public int jump(int[] arr) {
        int n = arr.length;

        if (n <= 1) return 0;

        // If the first element is 0, you can't move anywhere
        if (arr[0] == 0) return -1;

        int maxReach = arr[0]; 
        int steps = arr[0];    
        int jumps = 1;         // Take the first jump from index 0

        for (int i = 1; i < n; i++) {
            // If we've reached the last element, return the total jumps
            if (i == n - 1) return jumps;

            // Update the maximum reach possible from the current position
            maxReach = Math.max(maxReach, i + arr[i]);

            // Use up a step to move to the next index
            steps--;

            // If no more steps are left in our current jump window
            if (steps == 0) {
                jumps++; // We must make another jump

                // If the current index meets or exceeds maxReach, we are stuck
                if (i >= maxReach) return -1;

                // Reinitialize steps for the next jump territory
                steps = maxReach - i;
            }
        }

        return -1;
    }
}