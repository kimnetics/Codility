// https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
class Solution {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0;
        int lastMax = 0;
        int counter;

        for (int i = 0; i < A.length; i++) {
            counter = A[i];
            if (counter > N) {
                lastMax = max;
            } else {
                counters[counter - 1] = Math.max(counters[counter - 1], lastMax);
                counters[counter - 1]++;
                max = Math.max(max, counters[counter - 1]);
            }
        }

        for (int i = 0; i < N; i++) {
            counters[i] = Math.max(counters[i], lastMax);
        }

        return counters;
    }
}