// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
using System;

class Solution {
    public int solution(int[] A) {
        int maxRunningTotal = 0;
        int maxSlice = Int32.MinValue;

        foreach (var number in A)
        {
            maxRunningTotal = Math.Max(number, maxRunningTotal + number);
            maxSlice = Math.Max(maxSlice, maxRunningTotal);
        }

        return maxSlice;
    }
}