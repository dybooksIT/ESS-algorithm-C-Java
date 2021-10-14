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
  }

    printf("pos = %d\n", pos);

  return 0;
}