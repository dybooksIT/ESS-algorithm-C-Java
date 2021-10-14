#include <stdio.h>

int main() {
  int step, num;

  for (step = 1; step <= 9; step++) {
    printf("%d단", step);

    for (num = 1; num <= 9; num++) {
      printf("\t%2d", step * num);
    }

    printf("\n");
  }

  return 0;
}
