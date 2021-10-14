#include <stdio.h>
#define LENGTH 10
#define TRUE -1

// 해시 테이블의 실체가 되는 배열(요소 수를 10개로 함)
int hashTable[LENGTH] = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

// 해시 함수
int hashFunc(int data) {
  return data % 10;
}

// 프로그램 실행의 시작점인 main 함수
int main() {
  int data, hashValue;

  // 키보드로 데이터를 입력하여 해시 테이블에 저장
  do {
    // 저장할 데이터 입력
    printf("\n저장할 데이터 = ");
    scanf("%d", &data);

    // 음숫값이 입력되면 데이터 저장을 종료
    if (data < 0) {
      break;
    }

    // 해시값을 구함
    hashValue = hashFunc(data);

    // 해시 테이블에 데이터 저장
    hashTable[hashValue] = data;
  } while (TRUE);

  // 해시 테이블에서 데이터를 탐색
  do {
    // 탐색할 데이터를 키보드로 입력
    printf("\n탐색할 데이터 = ");
    scanf("%d", &data);

    // 음숫값이 입력되면 데이터 탐색을 종료
    if (data < 0) {
      break;
    }

    // 해시값을 구함
    hashValue = hashFunc(data);

    // 탐색한 결과를 표시
    if (hashTable[hashValue] == data) {
      printf("%d번째에서 발견되었습니다.\n", hashValue);
    }
    else {
      printf("찾을 수 없습니다.\n");
    }
  } while (TRUE);

  return 0;
}

