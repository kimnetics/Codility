// https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/
function solution(N, P, Q) {
  function getPrimes (N) {
    const primes = new Array(N + 1).fill(true)
    primes[0] = false
    primes[1] = false
    const end = Math.sqrt(N)
    for (let i = 2; i <= end; i++) {
      if (primes[i]) {
        for (let j = i * i; j <= N; j += i) {
          primes[j] = false
        }
      }
    }
    return primes
  }

  function getSemiprimes (N) {
    const primes = getPrimes(N)
    const semiprimes = new Array(N + 1).fill(false)
    const end = Math.sqrt(N)
    for (let i = 2; i <= end; i++) {
      if (primes[i]) {
        for (let j = i; i * j <= N; j++) {
          if (primes[j]) {
            semiprimes[i * j] = true
          }
        }
      }
    }
    return semiprimes
  }

  function getSemiprimeCounts (semiprimes) {
    const semiprimeCounts = new Array(semiprimes.length + 1).fill(0)
    for (let i = 1; i < semiprimeCounts.length; i++) {
      semiprimeCounts[i] = semiprimeCounts[i - 1] + (semiprimes[i - 1] ? 1 : 0)
    }
    return semiprimeCounts
  }

  const semiprimes = getSemiprimes(N)
  const semiprimeCounts = getSemiprimeCounts(semiprimes)
  const M = P.length
  const result = []
  for (let i = 0; i < M; i++) {
    result.push(semiprimeCounts[Q[i] + 1] - semiprimeCounts[P[i]])
  }
  return result
}