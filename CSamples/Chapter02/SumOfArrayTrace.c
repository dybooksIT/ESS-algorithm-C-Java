#include <stdio.h>
#define LENGTH 10

int main() {
  int a[] = { 72, 68, 92, 88, 41, 53, 97, 84, 39, 55 };
  int sum, i;

  sum = 0;
  printf("반복 실행 전: sum = %d\n", sum);

  for (i = 0; i < LENGTH; i++) {
    sum += a[i];
    printf("반복 실행 중: sum = %d, i = %d\n", sum, i);
  }

  printf("sum = %d\n", sum);
  printf("반복 실행 후: sum = %d, i = %d\n", sum, i);

  return 0;
}