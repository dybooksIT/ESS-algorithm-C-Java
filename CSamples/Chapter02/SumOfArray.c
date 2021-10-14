#include <stdio.h>
#define LENGTH 10

int main() {
  int a[] = { 72, 68, 92, 88, 41, 53, 97, 84, 39, 55 };
  int sum, i;

  sum = 0;
  for (i = 0; i < LENGTH; i++) {
    sum += a[i];
  }
  printf("sum = %d\n", sum);

  return 0;
}
