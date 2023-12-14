// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
using System;

class Solution {
    public int solution(int[] A) {
        if (A.Length == 0)
        {
            return 0;
        }

        int minPrice = Int32.MaxValue;
        int maxProfit = Int32.MinValue;

        foreach (var price in A)
        {
            if (price < minPrice)
            {
                minPrice = price;
            }

            int profit = price - minPrice;
            if (profit > maxProfit)
            {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}