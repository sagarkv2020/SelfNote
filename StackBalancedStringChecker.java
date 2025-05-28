package acn;

import java.util.Stack;

public class StackBalancedStringChecker {

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Check closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false; // No opening bracket to match

                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false; // Mismatched pair
                }
            }
        }

        return stack.isEmpty(); // All brackets matched
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String test = "{[()]}";
        System.out.println("Is Balanced: " + isBalanced(test)); // true

        String test2 = "[(])";
        System.out.println("Is Balanced: " + isBalanced(test2)); // false

        String test3 = "abcd()[]{}{}";
        System.out.println("Is Balanced: " + isBalanced(test3)); // false
    }
}
