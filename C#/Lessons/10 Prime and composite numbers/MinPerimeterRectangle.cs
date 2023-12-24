// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
using System;

class Solution {
    public int solution(int N) {
        int minPerimeter = Int32.MaxValue;

        double max = Math.Sqrt(N);

        for (int i = 1; i <= max; i++)
        {
            if (N % i == 0)
            {
                int perimeter = 2 * (i + N / i);
                minPerimeter = Math.Min(minPerimeter, perimeter);
            }
        }

        return minPerimeter;
    }
}