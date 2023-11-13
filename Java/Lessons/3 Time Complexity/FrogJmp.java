// https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
import java.lang.Math;

class Solution {
    public int solution(int X, int Y, int D) {
        return (int) Math.ceil((double) (Y - X) / D);
    }
}
