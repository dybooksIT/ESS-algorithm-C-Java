public class KnapsackDP {
  // 배낭의 최대 무게
  public static final int KNAP_MAX = 6;

  // 물건의 종류
  public static final int ITEM_NUM = 5;

  // 물건의 명칭
  public static char[] name = { 'A', 'B', 'C', 'D', 'E' };

  // 물건의 무게
  public static int[] weight = { 1, 2, 3, 4, 5 };

  // 물건의 가치
  public static int[] value = { 100, 300, 350, 500, 650 };

  // 물건을 넣을지 판단한 직후의 최대 가치
  public static int[][] maxValue = new int[ITEM_NUM][KNAP_MAX + 1];

  // 마지막에 넣은 물건
  public static int[] lastItem = new int[KNAP_MAX + 1];

  // item번째 물건을 넣을지 판단한 직후 배낭의 내용을 표시하는 메서드
  public static void showKnap(int item) {
    int knap;    // 0~6kg의 배낭을 가리킴

    // 넣을지 말지 판단할 물건의 정보를 표시
    System.out.printf("<%c, %dkg, %d원을 고려한 결과>\n", name[item], weight[item], value[item]);

    // 각 배낭의 무게를 표시
    for (knap = 0; knap <= KNAP_MAX; knap++) {
      System.out.printf("%dkg\t", knap);
    }
    System.out.printf("\n");

    // 배낭에 담긴 상품 가치의 합계를 표시
    for (knap = 0; knap <= KNAP_MAX; knap++) {
      System.out.printf("%d원\t", maxValue[item][knap]);
    }
    System.out.printf("\n");

    // 배낭에 마지막으로 넣은 물건을 표시
    for (knap = 0; knap <= KNAP_MAX; knap++) {
      if (lastItem[knap] != -1) {
        System.out.printf("%c\t", name[lastItem[knap]]);
      }
      else {
        System.out.printf("없음\t");
      }
    }
    System.out.printf("\n\n");
  }

  // 프로그램 실행의 시작점인 main 메서드
  public static void main(String[] args) {
    int item;           // 물건 번호
    int knap;           // 0~6kg의 배낭을 가리킴
    int selVal;         // 임시로 물건을 선택한 경우의 가치 합계
    int totalWeight;    // 중량의 합계

    // 0번째 물건을 넣을지 판단
    item = 0;
    // 0~KNAP_MAX kg의 배낭을 고려
    for (knap = 0; knap <= KNAP_MAX; knap++) {
      // 최대 무게 이하면 선택
      if (weight[item] <= knap) {
        maxValue[item][knap] = value[item];
        lastItem[knap] = item;
      }
      // 최대 무게 이하가 아니면 선택하지 않음
      else {
        maxValue[0][knap] = 0;
        lastItem[knap] = -1;
      }
    }
    showKnap(item);

    // 1번째~ITEM_NUM-1번째 물건을 고려
    for (item = 1; item < ITEM_NUM; item++) {
      // 0kg~KNAP_MAXkg의 배낭을 고려
      for (knap = 0; knap <= KNAP_MAX; knap++) {
        // 최대 무게 이하의 경우
        if (weight[item] <= knap) {
          // 선택한 경우의 가치를 구함
          selVal = maxValue[item - 1][knap - weight[item]] + value[item];
          // 가치가 크면 선택
          if (selVal > maxValue[item - 1][knap]) {
            maxValue[item][knap] = selVal;
            lastItem[knap] = item;
          }
          // 가치가 크지 않으면 선택하지 않음
          else {
            maxValue[item][knap] = maxValue[item - 1][knap];
          }
        }
        // 최대 무게 이하가 아니면 선택하지 않음
        else {
          maxValue[item][knap] = maxValue[item - 1][knap];
        }
      }
      showKnap(item);
    }

    // 배낭에 들어 있는 물건을 조사하여 정답을 표시
    System.out.printf("<배낭에 들어 있는 물건을 조사>\n");
    totalWeight = 0;
    for (knap = KNAP_MAX; knap > 0; knap -= weight[item]) {
      item = lastItem[knap];
      System.out.printf("%dkg의 배낭에 마지막으로 넣은 물건은 %c입니다.\n", knap, name[item]);
      totalWeight += weight[item];
      System.out.printf(" %c, %dkg, %d원\n", name[item], weight[item], value[item]);
      System.out.printf(" %dkg - %dkg = %dkg입니다.\n", knap, weight[item], knap - weight[item]);
    }
    System.out.printf("\n<정답을 표시>\n");
    System.out.printf("무게의 합계 = %dkg\n", totalWeight);
    System.out.printf("가치의 최댓값 = %d원\n", maxValue[ITEM_NUM - 1][KNAP_MAX]);
  }
}