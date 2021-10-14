public class FibonacciRec {
  // 인수 n의 피보나치 수를 반환하는 메서드
  public static int fibonacci(int n) {
    // 함수가 호출된 것을 확인
    // System.out.printf("fibonacci(%d)가 호출되었습니다.\n", n);

    if (n == 0) {
      // 0번째 피보나치 수는 0
      return 0;
    }
    else if (n == 1) {
      // 1번째 피보나치 수는 1
      return 1;
    }
    else {
      // 이후는 앞의 두 수를 더한 값
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  // 프로그램 실행의 시작점인 main 메서드
  public static void main(String[] args) {
    int n;

    // 0~8번째 피보나치 수를 표시
    for (n = 0; n <= 8; n++) {
      System.out.printf("%d, ", fibonacci(n));

      // 함수 호출 회수를 확인할 때 아래 코드의 주석을 해제하고 윗 코드를 주석 처리
      // System.out.printf("%d,\n", fibonacci(n));
    }
    System.out.printf("\n");
  }
}
