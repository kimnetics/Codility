// https://app.codility.com/programmers/lessons/6-sorting/triangle/
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);
        for (int i = 0; i <= A.length - 3; i++) {
            if ((long) A[i] + A[i + 1] > A[i + 2]) {
                return 1;
            }
        }

        return 0;
    }
}