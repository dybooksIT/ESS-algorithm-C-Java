import java.util.Scanner;

public class KnapsackGA {
  public static final int KNAP_MAX = 6;    // 배낭의 최대 무게
  public static final int ITEM_NUM = 5;    // 물건의 종류

  public static final int IND_NUM = 8;             // 개체 수
  public static final double MUTATE_RATE = 0.1;    // 돌연변이 확률(10%)

  public static char[] itemName = { 'A', 'B', 'C', 'D', 'E' };    // 물건의 이름
  public static int[] itemWeight = { 1, 2, 3, 4, 5 };             // 물건의 무게
  public static int[] itemValue = { 100, 300, 350, 500, 650 };    // 물건의 가치

  public static int indGeneration;                               // 개체의 세대
  public static int[][] indGene = new int[IND_NUM][ITEM_NUM];    // 개체의 유전자
  public static int[] indWeight = new int[IND_NUM];              // 개체의 무게
  public static int[] indValue = new int[IND_NUM];               // 개체의 가치
  public static int[] indFitness = new int[IND_NUM];             // 개체의 적응도

  // 개체를 무작위로 생성하는 메서드
  public static void createIndividual() {
    int ind, item;    // 루프 카운터

    // 0 또는 1을 무작위로 저장
    for (ind = 0; ind < IND_NUM; ind++) {
      for (item = 0; item < ITEM_NUM; item++) {
        indGene[ind][item] = Math.random() > 0.5 ? 0 : 1;
      }
    }
  }

  // 개체의 무게, 가치, 적응도를 계산하는 메서드
  public static void calcIndividual() {
    int ind, item;    // 루프 카운터

    for (ind = 0; ind < IND_NUM; ind++) {
      // 무게와 가치를 계산
      indWeight[ind] = 0;
      indValue[ind] = 0;
      for (item = 0; item < ITEM_NUM; item++) {
        if (indGene[ind][item] == 1) {
          indWeight[ind] += itemWeight[item];
          indValue[ind] += itemValue[item];
        }
      }

      // 적응도를 계산
      if (indWeight[ind] <= KNAP_MAX) {
        // 최대 무게 이하면 가치를 그대로 적응도로 삼음
        indFitness[ind] = indValue[ind];
      }
      else {
        // 최대 무게를 초과하면 적응도를 0으로 함
        indFitness[ind] = 0;
      }
    }
  }

  // 개체의 정보를 표시하는 메서드
  public static void showIndividual() {
    int ind, item;    // 루프 카운터

    // 세대를 표시
    System.out.printf("\n<%d세대>\n", indGeneration);

    // 유전자, 무게, 가치, 적응도를 표시
    System.out.printf("유전자\t\t무게\t가치\t적응도\n");
    for (ind = 0; ind < IND_NUM; ind++) {
      for (item = 0; item < ITEM_NUM; item++) {
        System.out.printf("[%d]", indGene[ind][item]);
      }
      System.out.printf("\t%2dkg\t%4d원\t%4d\n", indWeight[ind], indValue[ind], indFitness[ind]);
    }
    System.out.printf("\n");
  }

  // 적응도가 큰 순서대로 개체를 정렬하는 메서드
  public static void sortIndividual() {
    int pos;     // 삽입할 요소
    int ins;     // 삽입할 위치
    int item;    // 루프 카운터
    int tmp;     // 임시 변수

    // 삽입 정렬로 정렬
    for (pos = 1; pos < IND_NUM; pos++) {
      ins = pos;
      while (ins >= 1 && indFitness[ins - 1] < indFitness[ins]) {
        for (item = 0; item < ITEM_NUM; item++) {
          tmp = indGene[ins - 1][item];
          indGene[ins - 1][item] = indGene[ins][item];
          indGene[ins][item] = tmp;
        }

        tmp = indWeight[ins - 1];
        indWeight[ins - 1] = indWeight[ins];
        indWeight[ins] = tmp;

        tmp =  indValue[ins - 1];
        indValue[ins - 1] = indValue[ins];
        indValue[ins] = tmp;

        tmp = indFitness[ins - 1];
        indFitness[ins - 1] = indFitness[ins];
        indFitness[ins] = tmp;

        ins--;
      }
    }
  }

  // 도태를 수행하는 메서드
  public static void selectIndividual() {
    int ind, item;    // 루트 카운터

    // 적응도 상위 50%를 하위 50%로 복사(하위 50%를 도태시킴)
    for (ind = 0; ind < IND_NUM / 2; ind++) {
      for (item = 0; item < ITEM_NUM; item++) {
        indGene[ind + IND_NUM / 2][item] = indGene[ind][item];
      }
    }
    System.out.printf("하위 50％를 도태시켰습니다.\n");
  }

  // 교차를 수행하는 메서드
  public static void crossoverIndividual() {
    int ind, item;         // 루프 카운터
    int crossoverPoint;    // 교차 수행 위치
    int tmp;               // 임시 변수

    // 하위 50%를 복사한 개체를 대상으로 함
    for (ind = IND_NUM / 2; ind < (IND_NUM - 1); ind += 2) {
      // 교차할 위치를 임의로 결정
      crossoverPoint = (int)(Math.random() * 10000) % (ITEM_NUM - 1) + 1;
      for (item = crossoverPoint; item < ITEM_NUM; item++) {
        // 이웃 개체와 교차 수행
        tmp = indGene[ind][item];
        indGene[ind][item] = indGene[ind + 1][item];
        indGene[ind + 1][item] = tmp;
      }
      System.out.printf("개체 %d와 %d를 %d의 위치에서 교차했습니다.\n", ind, ind + 1, crossoverPoint);
    }
  }

  // 돌연변이를 만드는 메서드
  public static void mutateIndividual() {
    int ind, item;    // 루프 카운터

    // 하위 50%를 복사한 개체를 대상으로 함
    for (ind = IND_NUM / 2; ind < IND_NUM; ind++) {
      for (item = 0; item < ITEM_NUM; item++) {
        // 미리 정해진 확률로 돌연변이 만들기
        if (Math.random() <= MUTATE_RATE) {
          // 유전자 패턴을 반전함
          indGene[ind][item] ^= 1;
          System.out.printf("개체 %d의 %d 위치에서 돌연변이를 만들었습니다.\n", ind, item);
        }
      }
    }
  }

  // 프로그램의 실행의 시작점인 main 메서드
  public static void main(String[] args) {
    int genMax;    // 최대 세대
    int item;      // 루프 카운터

    // 키보드로 최대 세대를 입력
    Scanner scn = new Scanner(System.in);
    System.out.printf("최대의 세대 = ");
    genMax = scn.nextInt();
    scn.close();

    // 1세대 개체를 생성
    indGeneration = 1;
    createIndividual();

    // 적응도를 계산
    calcIndividual();

    // 적응도가 큰 순서로 개체를 정렬
    sortIndividual();

    // 개체를 표시
    showIndividual();

    // 1세대씩 진화시키기
    indGeneration++;
    while (indGeneration <= genMax) {
      // 적응도가 큰 순서로 개체를 정렬
      sortIndividual();

      // 도태시킴
      selectIndividual();

      // 교차시킴
      crossoverIndividual();

      // 돌연변이시킴
      mutateIndividual();

      // 적응도를 계산
      calcIndividual();

      // 적응도가 큰 순서로 개체를 정렬
      sortIndividual();

      // 개체를 표시
      showIndividual();

      // 다음 세대로 나아감
      indGeneration++;
    }

    // 적응도가 가장 높은 개체를 정답으로 표시
    System.out.printf("<배낭에 들어 있는 물건을 표시합니다.>\n");
    for (item = 0; item < ITEM_NUM; item++) {
      if (indGene[0][item] == 1) {
        System.out.printf("%c, %dkg, %d원\n", itemName[item], itemWeight[item], itemValue[item]);
      }
    }
    System.out.printf("\n<정답을 표시>\n");
    System.out.printf("무게의 합계 = %dkg\n", indWeight[0]);
    System.out.printf("가치의 최댓값 = %d원\n", indValue[0]);
  }
}