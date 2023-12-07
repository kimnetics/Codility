// https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
import java.util.Stack;

class Solution {
    // Stack contains heights and each entry is the top left corner of a rectangle.
    // Every stack entry represents a rectangle to add to count.
    //
    // Loop through heights.
    //   If current height > last height:
    //     Push current height to stack as the start of a new rectangle.
    //   Else:
    //     Pop rectangles off of stack until we get to a rectangle with a height <= current height.
    //       For each popped rectangle with a height > current height, increment count.
    //       If last popped rectangle has a height < current height, put it back on stack.
    //     Push current height to stack as the start of a new rectangle.
    //   Update last height.
    //
    // The logic produces rectangles that look like the following:
    //
    //   9 |          d
    // h 8 |  a a     d e     g
    // e 7 |  a a   c c c c   g
    // i 6 |  a a   c c c c   g
    // g 5 |  a a b b b b b   g
    // h 4 |  a a b b b b b f g
    // t 3 |  a a b b b b b f g
    // s 2 |  a a b b b b b f g
    //   1 |  a a b b b b b f g
    //     +-------------------
    //             columns
    public int solution(int[] H) {
        int count = 0;

        Stack<Integer> rectangles = new Stack<>();

        int lastHeight = 0;
        for (int i = 0; i < H.length; i++) {
            if (H[i] > lastHeight) {
                rectangles.push(H[i]);
            } else if (H[i] < lastHeight) {
                while (!rectangles.empty()) {
                    int stackHeight = rectangles.pop();
                    if (stackHeight < H[i]) {
                        rectangles.push(stackHeight);
                        break;
                    } else if (stackHeight == H[i]) {
                        break;
                    } else {
                        count++;
                    }
                }
                rectangles.push(H[i]);
            }
            lastHeight = H[i];
        }

        return count + rectangles.size();
    }
}