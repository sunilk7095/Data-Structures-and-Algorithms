class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int lastEnd = -1; // End index of the last chosen palindrome

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + (center % 2);

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;

                if (left > lastEnd) {
                    if (len == k || len == k + 1) {
                        count++;
                        lastEnd = right;
                        break; 
                    }
                } else {
                    break;
                }
                left--;
                right++;
            }
        }

        return count;
    }
}