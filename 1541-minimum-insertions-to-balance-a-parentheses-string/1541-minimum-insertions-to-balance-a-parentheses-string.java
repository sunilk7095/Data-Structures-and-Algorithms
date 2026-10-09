class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int openCount = 0; // Tracks unmatched '('
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openCount++;
            } else { // c == ')'
                // Check if the next character is also ')'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++; // Consume the consecutive ')'
                } else {
                    // Only a single ')' was found, need to insert one missing ')'
                    insertions++;
                }

                // Match with an existing '(' or insert a missing '('
                if (openCount > 0) {
                    openCount--;
                } else {
                    insertions++; // Insert '('
                }
            }
        }

        // Each unmatched '(' needs two ')' to be balanced
        insertions += openCount * 2;

        return insertions;
    }
}