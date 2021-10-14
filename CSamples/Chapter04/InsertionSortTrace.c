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

  // 정렬 전 배열 내용을 표시
  printf("정렬 전 배열\n");
  printArray(a, LENGTH);
  printf("\n");

  // 삽입 정렬로 오름차순 정렬
  for (ins = 1; ins < LENGTH; ins++) {
    printf("외부 반복문: temp ← a[%d] = %d\n", ins, a[ins]);
    temp = a[ins];
    for (cmp = ins - 1; cmp >= 0; cmp--) {
      printf("내부 반복문: ins = %d, cmp = %d, temp = %d\n", 
      ins, cmp, temp);
      if (a[cmp] > temp) {
        a[cmp + 1] = a[cmp];
      }
      else {
        printf("break로 중단\n");
        break;
      }

      // 내부 반복문 1회 실행 후 정렬 중간 결과 내용을 표시
      printArray(a, LENGTH);
    }

    printf("외부 반복문: ins = %d, cmp = %d, temp = %d\n", ins, cmp, temp);
    printf("외부 반복문: 확정된 삽입 위치 = a[%d] ← temp\n\n", cmp + 1);
    a[cmp + 1] = temp;

    // 삽입 위치 확정 후 정렬 중간 결과 내용을 표시 
    printf("삽입 위치 확정 후 중간 결과\n");
    printArray(a, LENGTH);
    printf("\n");
  }

  // 정렬 후 배열 내용을 표시
  printf("정렬 후 배열\n");
  printArray(a, LENGTH);

  return 0;
}
