public class SumOfArrayTrace {
  public static void main(String[] args) {
    int[] a = { 72, 68, 92, 88, 41, 53, 97, 84, 39, 55 };
    int sum, i;
    sum = 0;
    System.out.printf("반복 실행 전: sum = %d\n", sum);

    for (i = 0; i < a.length; i++) {
      sum += a[i];
      System.out.printf("반복 실행 중: sum = %d, i = %d\n", sum, i);
    }

    System.out.printf("sum = %d\n", sum);
    System.out.printf("반복 실행 후: sum = %d, i = %d\n", sum, i);
  }
}