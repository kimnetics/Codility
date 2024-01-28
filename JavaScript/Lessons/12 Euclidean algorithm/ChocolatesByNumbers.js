// https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/
function solution(N, M) {
  function gcd (a, b) {
    if (b === 0) return a
    return gcd(b, a % b)
  }

  return N / gcd(N, M)
}