// https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
class Solution {
    public int solution(int[] A) {
        double low = Double.MAX_VALUE;
        double average;
        int lowI = 0;

        for (int i = 0; i < A.length - 1; i++) {
            average = (A[i] + A[i + 1]) / 2.0;
            if (average < low) {
                low = average;
                lowI = i;
            }
            if (i < A.length - 2) {
                average = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                if (average < low) {
                    low = average;
                    lowI = i;
                }
            }
        }

        return lowI;
    }
}