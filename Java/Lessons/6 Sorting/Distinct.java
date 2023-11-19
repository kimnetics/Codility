// https://app.codility.com/programmers/lessons/6-sorting/distinct/
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        Set<Integer> nums = new HashSet<>();
        for (int num : A) {
            nums.add(num);
        }

        return nums.size();
    }
}