// https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        Set<Integer> nums = new HashSet<>();

        int num;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            num = A[i];
            if (num < 0 || num > len) {
                return 0;
            }
            if (nums.contains(num)) {
                return 0;
            }
            nums.add(num);
        }
        return 1;
    }
}