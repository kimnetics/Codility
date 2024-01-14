// https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/
function solution(A) { 
  const N = A.length
  let maxValue = 2 * N

  let result = new Array(N).fill(0)

  // Count occurrences of each number in A.
  let occurrenceCount = new Array(maxValue + 1).fill(0)
  for (let i = 0; i < N; i++) {
    occurrenceCount[A[i]]++
  }

  // For each number in A, calculate number of non-divisors.
  for (let i = 0; i < N; i++) {
    let current = A[i]
    let end = Math.sqrt(current)

    // Count divisors
    let divisorCount = 0
    for (let j = 1; j <= end; j++) {
      if (current % j === 0) {
        divisorCount += occurrenceCount[j]
        const otherDivisor = current / j
        if (otherDivisor !== j) {
          divisorCount += occurrenceCount[otherDivisor]
        }
      }
    }

    // Subtract divisor count from element count to get non-divisor count.
    result[i] = N - divisorCount
  }

  return result
}