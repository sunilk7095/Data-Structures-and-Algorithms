import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<Character> opStack = new Stack<>();
        Stack<Set<String>> valStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Handle implicit concatenation when a expression term ends and another begins
            if (i > 0) {
                char prev = expression.charAt(i - 1);
                if ((Character.isLetter(prev) || prev == '}') && (Character.isLetter(c) || c == '{')) {
                    // Precedence check for implicit concatenation '.' vs ','
                    while (!opStack.isEmpty() && opStack.peek() == '.') {
                        evaluate(opStack, valStack);
                    }
                    opStack.push('.');
                }
            }

            if (Character.isLetter(c)) {
                Set<String> set = new HashSet<>();
                set.add(String.valueOf(c));
                valStack.push(set);
            } else if (c == '{') {
                opStack.push('{');
            } else if (c == ',') {
                while (!opStack.isEmpty() && opStack.peek() != '{') {
                    evaluate(opStack, valStack);
                }
                opStack.push(',');
            } else if (c == '}') {
                while (!opStack.isEmpty() && opStack.peek() != '{') {
                    evaluate(opStack, valStack);
                }
                opStack.pop(); // Remove matching '{'
            }
        }

        // Evaluate any remaining operators
        while (!opStack.isEmpty()) {
            evaluate(opStack, valStack);
        }

        // Convert the final Set into a sorted List
        List<String> result = new ArrayList<>(valStack.pop());
        Collections.sort(result);
        return result;
    }

    private void evaluate(Stack<Character> opStack, Stack<Set<String>> valStack) {
        char op = opStack.pop();
        Set<String> set2 = valStack.pop();
        Set<String> set1 = valStack.pop();
        Set<String> res = new HashSet<>();

        if (op == ',') {
            // Union of two sets
            res.addAll(set1);
            res.addAll(set2);
        } else if (op == '.') {
            // Cartesian product (Concatenation)
            for (String s1 : set1) {
                for (String s2 : set2) {
                    res.add(s1 + s2);
                }
            }
        }
        valStack.push(res);
    }
}