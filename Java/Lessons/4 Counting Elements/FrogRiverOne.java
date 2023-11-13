// https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int X, int[] A) {
        Set<Integer> path = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] < (X + 1)) {
                path.add(A[i]);
                if (path.size() == X) {
                    return i;
                }
            }
        }

        return -1;
    }
}