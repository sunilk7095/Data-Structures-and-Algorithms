import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftRem = 0, rightRem = 0;

        // Calculate the minimum number of '(' and ')' that must be removed
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--; // Valid pair matched
                } else {
                    rightRem++; // Unmatched closing bracket
                }
            }
        }

        Set<String> result = new HashSet<>();
        backtrack(s, 0, 0, 0, leftRem, rightRem, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private void backtrack(String s, int index, int openCount, int closeCount, 
                           int leftRem, int rightRem, StringBuilder current, Set<String> result) {
        
        // Base case
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                result.add(current.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int length = current.length();

        // Option 1: Ignore/Remove current character if allowed
        if (c == '(' && leftRem > 0) {
            backtrack(s, index + 1, openCount, closeCount, leftRem - 1, rightRem, current, result);
        } else if (c == ')' && rightRem > 0) {
            backtrack(s, index + 1, openCount, closeCount, leftRem, rightRem - 1, current, result);
        }

        // Option 2: Keep current character
        current.append(c);

        if (c != '(' && c != ')') {
            // Non-parenthesis characters are always included
            backtrack(s, index + 1, openCount, closeCount, leftRem, rightRem, current, result);
        } else if (c == '(') {
            backtrack(s, index + 1, openCount + 1, closeCount, leftRem, rightRem, current, result);
        } else if (c == ')' && openCount > closeCount) {
            // Only add ')' if it balances a preceding '('
            backtrack(s, index + 1, openCount, closeCount + 1, leftRem, rightRem, current, result);
        }

        // Backtrack
        current.setLength(length);
    }
}