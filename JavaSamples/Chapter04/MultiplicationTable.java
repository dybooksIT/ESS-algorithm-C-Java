public class MultiplicationTable {
  public static void main(String[] args) {
    int step, num;

    for (step = 1; step <= 9; step++) {
      System.out.printf("%d단", step);

      for (num = 1; num <= 9; num++) {
        System.out.printf("\t%2d", step * num);
      }

      System.out.printf("\n");
    }
  }
}