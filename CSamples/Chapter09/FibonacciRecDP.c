#include <stdio.h>
#define LENGTH 100

// 피보나치 수를 저장하는 배열(최대 100번째까지)
int fibonacciNumbers[LENGTH];

// 피보나치 수를 저장하는 배열을 초기화
void initFibonacciNumbers() {
  for (int i = 0; i < LENGTH; i++) {
    fibonacciNumbers[i] = -1;
  }
}

// 인수 n의 피보나치 수를 반환하는 함수
int fibonacci(int n) {
  // 함수가 호출된 것을 확인
  printf("fibonacci(%d)가 호출되었습니다.\n", n);

  if (fibonacciNumbers[n] == -1) {
    if (n == 0) {
      // 0번째 피보나치 수 0을 저장
      fibonacciNumbers[n] = 0;
    }
    else if (n == 1) {
      // 1번째 피보나치 수 1을 저장
      fibonacciNumbers[n] = 1;
    }
    else {
      // 재귀 호출에서 피보나치 수를 찾고 저장
      fibonacciNumbers[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  // 피보나치 수를 반환
  return fibonacciNumbers[n];
}

// 프로그램 실행의 시작점인 main 함수
int main() {
  // 피보나치 수를 저장하는 배열을 초기화
  initFibonacciNumbers();

  // 5번째 피보나치 수를 표시
  printf("5번째 피보나치 수 = %d\n", fibonacci(5));

  return 0;
}