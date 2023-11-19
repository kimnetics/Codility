// https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
class Solution {
    public int solution(int[] A) {
        int passingCars = 0;

        int zeroCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zeroCount++;
            } else {
                passingCars += zeroCount;
                if (passingCars > 1_000_000_000) {
                    return -1;
                }
            }
        }

        return passingCars;
    }
}