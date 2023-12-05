// https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
import java.util.Stack;

class Solution {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            // Are we on an open character?
            char sChar = S.charAt(i);
            if ("({[".indexOf(sChar) >= 0) {
                stack.push(sChar);
            } else {
                // Not properly nested if no open character on stack.
                if (stack.empty()) {
                    return 0;
                }
                // Get character from stack.
                char stackChar = stack.pop();
                // Is stack character not the proper open character?
                int sCharType = ")}]".indexOf(sChar);
                if ((sCharType < 0) || ("({[".charAt(sCharType) != stackChar)) {
                    return 0;
                }
            }
        }
        // Not properly nested if there are still items on stack.
        if (!stack.empty()) {
            return 0;
        }

        return 1;
    }
}