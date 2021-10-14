#include <stdio.h>
#define LENGTH 5

void printArray(int a[], int len) {
  for (int i = 0; i < len; i++) {
    printf("[%d]", a[i]);
  }
  printf("\n");
}

int main() {
  int a[] = { 90, 34, 78, 12, 56 };
  int ins, cmp, temp;

  // 정렬 전의 배열 내용을 표시
  printf("정렬 전 배열\n");
  printArray(a, LENGTH);
  printf("\n");

  // 삽입 정렬로 오름차순 정렬
  for (ins = 1; ins < LENGTH; ins++) {
    temp = a[ins];
    for (cmp = ins - 1; cmp >= 0; cmp--) {
      if (a[cmp] > temp) {
        a[cmp + 1] = a[cmp];
      }
      else {
        break;
      }
    }
    a[cmp + 1] = temp;
  }

  // 정렬 후의 배열 내용을 표시
  printf("정렬 후 배열\n");
  printArray(a, LENGTH);

  return 0;
}