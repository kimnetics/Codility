# https://app.codility.com/programmers/lessons/8-leader/dominator/
using System;
using System.Collections.Generic;

class Solution {
    public int solution(int[] A) {
        var numbers = new Dictionary<int, int>();

        int threshold = A.Length / 2 + 1;

        for (int i = 0; i < A.Length; i++)
        {
            if (numbers.ContainsKey(A[i]))
            {
                numbers[A[i]]++;
            }
            else
            {
                numbers.Add(A[i], 1);
            }

            if (numbers[A[i]] >= threshold)
            {
                return i;
            }
        }

        return -1;
    }
}