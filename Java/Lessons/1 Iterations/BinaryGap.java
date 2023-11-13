// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
class Solution {
    public int solution(int N) {
        String binary = Integer.toBinaryString(N);

        int maxCount = 0;

        int start = -1;
        int zeroEnd = -1;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                if (start > -1) {
                    zeroEnd = i;
                }
            } else {
                if (zeroEnd > -1) {
                    maxCount = Math.max(maxCount, zeroEnd - start);
                    zeroEnd = -1;
                }
                start = i;
            }
        }

        return maxCount;
    }
}