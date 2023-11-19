// https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        if (A.length == 3) {
            return A[0] * A[1] * A[2];
        }

        Arrays.sort(A);

        int lastIndex = A.length - 1;
        int option1 = A[lastIndex - 2] * A[lastIndex - 1] * A[lastIndex];
        int option2 = A[0] * A[1] * A[lastIndex];

        return Math.max(option1, option2);
    }
}