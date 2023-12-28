// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/
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

        int peakCount = peaks.Count;
        if (peakCount == 0)
        {
            return 0;
        }

        int maxFlags = Math.Min((int)Math.Ceiling(Math.Sqrt(N)), peakCount);

        // Determine maximum flags.
        for (int flags = maxFlags; flags > 0; flags--)
        {
            int usedFlags = 1;
            int lastFlag = peaks[0];

            for (int i = 1; i < peakCount; i++)
            {
                if (peaks[i] - lastFlag >= flags)
                {
                    usedFlags++;
                    lastFlag = peaks[i];
                }
            }

            if (usedFlags >= flags)
            {
                return flags;
            }
        }

        return 0;
    }
}