// https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        long left = A[0];
        long right = Arrays.stream(A).sum() - left;
        long min = Math.abs(right - left);

        for (int i = 1; i < A.length - 1; i++) {
            left += A[i];
            right -= A[i];
            min = Math.min(min, Math.abs(right - left));
        }

        return (int) min;
    }
}