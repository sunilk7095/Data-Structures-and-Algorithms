class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;  // Tracks unmatched '('
        int closeCount = 0; // Tracks unmatched ')'

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    openCount--; // Matched with a previous '('
                } else {
                    closeCount++; // Unmatched ')' needing a '('
                }
            }
        }

        return openCount + closeCount;
    }
}