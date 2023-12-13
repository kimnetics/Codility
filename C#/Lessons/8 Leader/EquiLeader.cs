# https://app.codility.com/programmers/lessons/8-leader/equi_leader/
using System;
using System.Collections.Generic;

class Solution {
    public int solution(int[] A) {
        // Get count for each number.
        var numberCounts = new Dictionary<int, int>();
        foreach (var number in A)
        {
            if (numberCounts.ContainsKey(number))
            {
                numberCounts[number]++;
            }
            else
            {
                numberCounts.Add(number, 1);
            }
        }

        // Find leader.
        int threshold = A.Length / 2 + 1;
        int leader = -1;
        int leaderCount = 0;
        foreach (KeyValuePair<int, int> pair in numberCounts)
        {
            if (pair.Value >= threshold)
            {
                leader = pair.Key;
                leaderCount = pair.Value;
                break;
            }
        }

        // Exit if no leader.
        if (leader == -1)
        {
            return 0;
        }

        // Count equi leaders.
        int equiLeaderCount = 0;
        int leftLeaderCount = 0;
        int rightLeaderCount = leaderCount;
        for (int i = 0; i < A.Length - 1; i++)
        {
            if (A[i] == leader)
            {
                leftLeaderCount++;
                rightLeaderCount--;
            }

            // Do left and right counts indicate leadership on both left and right sides?
            if (leftLeaderCount > (i + 1) / 2 && rightLeaderCount > (A.Length - i - 1) / 2)
            {
                equiLeaderCount++;
            }
        }

        return equiLeaderCount;
    }
}