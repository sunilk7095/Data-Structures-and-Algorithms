import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // Push -1 onto the stack as a base index for calculating valid substring lengths
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // Store the index of '('
                stack.push(i);
            } else {
                // Pop the last unmatched '(' index or the last base boundary index
                stack.pop();

                if (stack.isEmpty()) {
                    // If stack becomes empty, the current ')' acts as a new base boundary
                    stack.push(i);
                } else {
                    // Current valid length is current index minus top of stack
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}