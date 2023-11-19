// https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        int[] response = new int[P.length];

        // Build change detection array.
        int[][] change = new int[S.length()][4];
        //
        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case 'A':
                    change[i][0] = 1;
                    break;
                case 'C':
                    change[i][1] = 1;
                    break;
                case 'G':
                    change[i][2] = 1;
                    break;
                default:
                    change[i][3] = 1;
            }
        }
        //
        for (int i = 1; i < S.length(); i++) {
            for (int j = 0; j < 4; j++) {
                change[i][j] += change[i - 1][j];
            }
        }

        // Build response array.
        int start;
        int end;
        for (int i = 0; i < P.length; i++) {
            start = P[i] - 1;
            end = Q[i];
            for (int j = 0; j < 4; j++) {
                if (start < 0) {
                    if (change[end][j] != 0) {
                        response[i] = j + 1;
                        break;
                    }
                } else if (change[end][j] != change[start][j]) {
                    response[i] = j + 1;
                    break;
                }
            }
        }

        return response;
    }
}