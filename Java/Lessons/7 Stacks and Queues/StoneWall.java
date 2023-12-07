// https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
import java.util.Stack;

class Solution {
    // 9         d
    // 8 a a     d e     g
    // 7 a a   c c c c   g
    // 6 a a   c c c c   g
    // 5 a a b b b b b   g
    // 4 a a b b b b b f g
    // 3 a a b b b b b f g
    // 2 a a b b b b b f g
    // 1 a a b b b b b f g
    public int solution(int[] H) {
        int rectangles = 0;

        Stack<Integer> stack = new Stack<>();

        int height = 0;
        for (int i = 0; i < H.length; i++) {
            if (H[i] > height) {
                stack.push(H[i]);
            } else if (H[i] < height) {
                while (!stack.empty()) {
                    int stackHeight = stack.pop();
                    if (stackHeight == H[i]) {
                        break;
                    } else if (stackHeight < H[i]) {
                        stack.push(stackHeight);
                        break;
                    } else {
                        rectangles++;
                    }
                }
                stack.push(H[i]);
            }
            height = H[i];
        }

        return rectangles + stack.size();
    }
}