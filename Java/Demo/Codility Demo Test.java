// https://app.codility.com/demo/take-sample-test/
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        if (A[A.length - 1] < 1) {
            return 1;
        }

        int number = 0;
        int i = 0;
        while (i < A.length) {
            if (A[i] <= number) {
                i++;
            } else if (A[i] == number + 1) {
                number++;
                i++;
            } else {
                break;
            }
        }
        return number + 1;
    }
}
