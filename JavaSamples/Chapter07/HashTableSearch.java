import java.util.Scanner;

public class HashTableSearch {
  // 해시 테이블의 실체가 되는 배열(요소 수를 10개로 함)
  public static int[] hashTable = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

  // 해시 함수 역할을 하는 메서드
  public static int hashFunc(int data) {
    return data % 10;
  }

  // 프로그램 실행의 시작점인 main 메서드
  public static void main(String[] args) {
    int data, hashValue;

    // 키보드로 데이터를 입력하여 해시 테이블에 저장
    Scanner scn = new Scanner(System.in);
    do {
      // 저장할 데이터 입력
      System.out.printf("\n저장할 데이터 = ");
      data = scn.nextInt();

      // 음숫값이 입력되면 데이터 저장을 종료
      if (data < 0) {
        break;
      }

      // 해시값을 구함
      hashValue = hashFunc(data);

      // 해시 테이블에 저장
      hashTable[hashValue] = data;
    } while (true);

    // 해시 테이블에서 데이터를 탐색
    do {
      // 검색할 데이터를 키보드로 입력
      System.out.printf("\n탐색할 데이터 = ");
      data = scn.nextInt();

      // 음숫값이 입력되면 데이터 탐색을 종료
      if (data < 0) {
        break;
      }

      // 해시값을 구함
      hashValue = hashFunc(data);

      // 검색한 결과를 표시
      if (hashTable[hashValue] == data) {
        System.out.printf("%d번째에서 발견되었습니다.\n", hashValue);
      }
      else {
        System.out.printf("찾을 수 없습니다.\n");
      }
    } while (true);

    scn.close();
  }
}