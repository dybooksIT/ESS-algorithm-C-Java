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
  int ins, cmp, min, temp;
 
  // 정렬 전 배열 내용을 표시
  printf("정렬 전 배열\n");
  printArray(a, LENGTH);
  printf("\n");

  // 배열 요소의 수 -1 만큼 반복
  for (ins = 0; ins < LENGTH - 1; ins++) {
    min = ins;

    // ins번째와 비교해 더 작은 값이 있다면 min 수정
    for (cmp = ins + 1; cmp < LENGTH; cmp++) {
      if (a[cmp] < a[ins]) {
        min = cmp;

        // min이 변경되었다면 자리 교환
        temp = a[ins];
        a[ins] = a[min];
        a[min] = temp;
      }
    }
  }
  
  // 정렬 후 배열 내용을 표시
  printf("정렬 후 배열\n");
  printArray(a, LENGTH);
    
  return 0;
}