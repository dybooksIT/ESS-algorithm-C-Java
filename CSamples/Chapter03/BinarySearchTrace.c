#include <stdio.h>
#define LENGTH 10

int main() {
    int a[] = { 39, 41, 53, 55, 68, 72, 84, 88, 92, 97 };
    int x, pos, left, right, middle;

    printf("x = ");
    scanf("%d", &x);
    pos = -1;
    left = 0;
    right = LENGTH - 1;
    printf("반복 실행 전: x = %d\n", x);
    printf("반복 실행 전: pos = %d, left = %d, middle = ?, right = %d\n", pos, left, right);

    while (pos == -1 && left <= right) {
      middle = (left + right) / 2;
      if (a[middle] == x) {
        pos = middle;
      }
      else if (a[middle] > x) {
        right = middle - 1;
      }
      else {
        left = middle + 1;
      }
      printf("반복 실행 중: pos = %d, left = %d, middle = %d, right = %d\n", pos, left, middle, right);
    }

    printf("pos = %d\n", pos);

  return 0;
}
