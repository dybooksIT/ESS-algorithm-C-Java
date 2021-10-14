import java.util.Scanner;

public class SequentialSearch {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int[] a = { 72, 68, 92, 88, 41, 53, 97, 84, 39, 55 };
    int x, pos, i;

    System.out.print("x = ");
    x = scn.nextInt();
    pos = -1;
    scn.close();

    for (i = 0; i < a.length && pos == -1; i++) {
      if (a[i] == x) {
        pos = i;
      }
    }

    System.out.printf("pos = %d\n", pos);
  }
}