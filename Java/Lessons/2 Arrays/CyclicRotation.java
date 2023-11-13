// https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
class Solution {
    public int[] solution(int[] A, int K) {
        if (A.length == 0) {
            return A;
        }

        int shift = K % A.length;
        if (shift == 0) {
            return A;
        }

        int[] shifted = new int[A.length];

        System.arraycopy(A, A.length - shift, shifted, 0, shift);
        System.arraycopy(A, 0, shifted, shift, A.length - shift);

        return shifted;
    }
}