
public class FibonacciRecDP {
  // 피보나치 수를 저장하는 배열(최대 100번째까지)
  public static int[] fibonacciNumbers = new int[100];

  // 피보나치 수를 저장하는 배열을 초기화
  public static void initFibonacciNumbers() {
    for (int i = 0; i < fibonacciNumbers.length; i++) {
      fibonacciNumbers[i] = -1;
    }
  }

  // 인수 n의 피보나치 수를 반환하는 메서드
  public static int fibonacci(int n) {
    // 메서드가 호출된 것을 확인
    System.out.printf("fibonacci(%d)가 호출되었습니다.\n", n);

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

  // 프로그램 실행의 시작점인 main 메서드
  public static void main(String[] args) {
    // 피보나치 수를 저장하는 배열을 초기화
    initFibonacciNumbers();

    // 5번째 피보나치 수를 표시
    System.out.printf("5번째 피보나치 수 = %d\n", fibonacci(5));
  }
}