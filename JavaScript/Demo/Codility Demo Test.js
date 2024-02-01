// https://app.codility.com/demo/take-sample-test/
function solution (A) {
  A.sort((a, b) => a - b)

  let expectedInt = 1

  for (let i = 0; i < A.length; i++) {
    if (A[i] > expectedInt) {
      break
    } else if (A[i] === expectedInt) {
      expectedInt++
    }
  }

  return expectedInt
}