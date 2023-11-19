// https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
class Solution {
    public int solution(int A, int B, int K) {
        int first = K * (int) Math.ceil((double) A / K);
        int last = K * (int) Math.floor((double) B / K);

        return (last - first) / K + 1;
    }
}