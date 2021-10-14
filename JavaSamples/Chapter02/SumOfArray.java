public class SumOfArray {
  public static void main(String[] args) {
    int[] a = { 72, 68, 92, 88, 41, 53, 97, 84, 39, 55 };
    int sum, i;
    sum = 0;

    for (i = 0; i < a.length; i++) {
      sum += a[i];
    }
    System.out.printf("sum = %d\n", sum);
  }
}