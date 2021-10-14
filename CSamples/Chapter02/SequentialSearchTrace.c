#include <stdio.h>
#define LENGTH 10

int main() {
  int a[] = { 72, 68, 92, 88, 41, 53, 97, 84, 39, 55 };
  int x, pos, i;

  printf("x = ");
  scanf("%d", &x);
  pos = -1;
  printf("반복 실행 전: x = %d\n", x);
  printf("반복 실행 전: pos = %d\n", pos);

  for (i = 0; i < LENGTH && pos == -1; i++) {
    if (a[i] == x) {
      pos = i;
    }
    printf("반복 실행 중: pos = %d, i = %d\n", pos, i);
  }

  printf("pos = %d\n", pos);
  printf("반복 실행 후: pos = %d, i = %d\n", pos, i);

  return 0;
}