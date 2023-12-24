// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
using System;

class Solution {
    public int solution(int N) {
        int factors = 0;

        double max = Math.Sqrt(N);
        if ((max % 1) == 0)
        {
            factors--;
        }

        for (int i = 1; i <= max; i++)
        {
            if (N % i == 0)
            {
                factors += 2;
            }
        }

        return factors;
    }
}