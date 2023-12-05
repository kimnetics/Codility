// https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
import java.util.Stack;

class Solution {
    public int solution(int[] A, int[] B) {
        int alive = 0;

        Stack<Integer> down = new Stack<>();
        for (int i = 0; i < B.length; i++) {
            // Is fish going up?
            if (B[i] == 0) {
                // Are there no fishes upstream?
                if (!down.empty()) {
                    boolean eaten = false;
                    while (!down.empty()) {
                        int fish = down.pop();
                        if (fish > A[i]) {
                            down.push(fish);
                            eaten = true;
                            break;
                        }
                    }
                    if (!eaten) {
                        alive++;
                    }
                } else {
                    alive++;
                }
            } else {
                down.push(A[i]);
            }
        }
        alive += down.size();

        return alive;
    }
}