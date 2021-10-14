#include <stdio.h>
#define KNAP_MAX 6    // 배낭의 최대 무게
#define ITEM_NUM 5    // 물건의 종류

int main() {
  int totalWeight = 0;    // 무게의 합계
  int totalValue = 0;     // 가치의 합계

  // 물건의 정보(가치가 큰 순서로 정렬)
  char name[] = { 'E', 'D', 'C', 'B', 'A' };
  int weight[] = { 5, 4, 3, 2, 1 };
  int value[] = { 650, 500, 350, 300, 100};

  // 가치가 큰 순서로 고르기
  for (int i = 0; i < ITEM_NUM; i++) {
    if (totalWeight + weight[i] <= KNAP_MAX) {
      printf("물건 %c를 선택\n", name[i]);
      totalWeight += weight[i];
      totalValue += value[i];
    }
    else {
      break;
    }
  }

  // 결과를 표시
  printf("무게의 합계 = %dkg\n", totalWeight);
  printf("가치의 합계 = %d원\n", totalValue);

  return 0;
}