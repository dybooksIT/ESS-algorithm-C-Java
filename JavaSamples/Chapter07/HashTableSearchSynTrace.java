import java.util.Scanner;

public class HashTableSearchSynTrace {
  // 해시 테이블의 실체가 되는 배열(요소 수를 10개로 함)
  public static int[] hashTable = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

  // 해시 함수 역할을 하는 메서드
  public static int hashFunc(int data) {
    return data % 10;
  }

  // 프로그램 실행의 시작점인 main 메서드
  public static void main(String[] args) {
    int data, hashValue;
    int pos;    // 저장 위치, 검색 위치

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
      System.out.printf("해시값 = %d %% 10 = %d\n", data, hashValue);

      // 데이터의 저장 위치를 정함
      pos = hashValue;
      System.out.printf("저장 위치 pos = %d\n", pos);
      while (hashTable[pos] != -1) {
        // 다음 배열 요소에서 데이터를 저장할 수 있는지 확인
        pos++;

        // 배열 마지막 요소까지 데이터 저장 가능 여부를
        // 확인하면 배열 첫 번째 요소를 지정
        if (pos >= hashTable.length) {
          pos = 0;
        }
        System.out.printf("저장 위치 pos = %d\n", pos);

        // 해시값의 배열 요소 위치까지 돌아오면,
        // 해시 테이블에 데이터가 가득 찬 것이므로 반복을 종료
        if (pos == hashValue) {
          break;
        }
      }

      if (hashTable[pos] == -1) {
        // 해시 테이블이 가득 차지 않았다면 데이터를 저장
        hashTable[pos] = data;
        System.out.printf("hashTable[%d]에 %d을(를) 저장합니다.\n", pos, data);
      }
      else {
        // '해시 테이블이 가득 찼습니다'를 표시
        System.out.printf("해시 테이블이 가득 찼습니다.\n");
      }
    } while (true);

    // 해시 테이블에서 데이터를 탐색
    do {
      // 검색할 데이터의 키를 입력
      System.out.printf("\n검색할 데이터 = ");
      data = scn.nextInt();

      // 음숫값이 입력되면 데이터 검색을 종료
      if (data < 0) {
        break;
      }

      // 해시값을 구함
      hashValue = hashFunc(data);
      System.out.printf("해시값 = %d %% 10 = %d\n", data, hashValue);

      // 데이터를 탐색
      pos = hashValue;
      System.out.printf("탐색 위치 pos = %d\n", pos);
      while (hashTable[pos] != -1 && hashTable[pos] != data) {
        // 다음 배열 요소로 탐색 위치를 이동
        pos++;

        // 배열 마지막 요소까지 탐색하면 배열 첫 번째 요소를 지정
        if (pos >= hashTable.length) {
          pos = 0;
        }
        System.out.printf("탐색 위치 pos = %d\n", pos);

        // -1을 찾았거나, 해시값의 인덱스 위치로 돌아오면,
        // 데이터를 찾을 수 없는 것이므로 반복을 종료
        if (hashTable[pos] == -1 || pos == hashValue) {
          break;
        }
      }

      // 탐색한 결과를 표시
      if (hashTable[pos] == data) {
        System.out.printf("hashTable[%d]값은 %d이므로, 발견한 위치를 표시합니다.\n", pos, data);
        System.out.printf("%d번째에서 발견되었습니다.\n", pos);
      }
      else {
        System.out.printf("hashTable[%d]값은 %d이므로, '찾을 수 없습니다.'를 표시합니다.\n", pos, hashTable[pos]);
        System.out.printf("찾을 수 없습니다.\n");
      }
    } while (true);

    scn.close();
  }
}