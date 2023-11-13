// https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 1; i <= A.length; i++) {
            if (A[i - 1] != i) {
                return i;
            }
        }

        return A.length + 1;
    }
}