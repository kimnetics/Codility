// https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        Set<Integer> nums = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (nums.contains(A[i])) {
                nums.remove(A[i]);
            } else {
                nums.add(A[i]);
            }
        }

        return nums.iterator().next();
    }
}