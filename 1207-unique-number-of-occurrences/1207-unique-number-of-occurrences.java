class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> countSet = new HashSet<>();
        
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (!countSet.add(count)) return false; // Duplicate count found
                count = 1;
            }
        }
        return countSet.add(count); // Check final group count
    }
}