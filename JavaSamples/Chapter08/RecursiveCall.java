public class RecursiveCall {
  // 인수 n의 계승을 구하는 메서드
  public static int factorial(int n) {
    if (n == 0) {
      // 0의 계승은 1이므로 1을 반환해 재귀 호출을 종료
      return 1;
    }
    else {
      // n의 계승은 n * (n - 1)의 계승이므로,
      // 재귀 호출로 (n - 1)의 계승을 구함
      return n * factorial(n - 1);
    }
  }

  // 프로그램 실행의 시작점인 main 메서드
  public static void main(String[] args) {
    int ans;

    // 5의 계승을 구함
    ans = factorial(5);
    System.out.printf("%d\n", ans);
  }
}
