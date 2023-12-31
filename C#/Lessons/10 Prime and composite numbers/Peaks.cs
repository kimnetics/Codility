// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/
using System;
using System.Collections.Generic;

class Solution {
    public int solution(int[] A) {
        int N = A.Length;
        List<int> peaks = new List<int>();

        // Find peaks.
        for (int i = 1; i < N - 1; i++)
        {
            if (A[i - 1] < A[i] && A[i] > A[i + 1])
            {
                peaks.Add(i);
            }
        }

        // Exit quickly if less than two peaks.
        int peakCount = peaks.Count;
        if (peakCount < 2)
        {
            return peakCount;
        }

        // Loop through potential block counts.
        for (int blockCount = peakCount; blockCount > 0; blockCount--)
        {
            // Blocks must be the same size.
            if (N % blockCount == 0)
            {
                int blockSize = N / blockCount;

                int blockNumber = 0;
                foreach (int peak in peaks)
                {
                    if ((int)Math.Floor((double)peak / blockSize) == blockNumber)
                    {
                        blockNumber++;
                    }
                }

                if (blockNumber == blockCount)
                {
                    return blockCount;
                }
            }
        }

        return 1;
    }
}