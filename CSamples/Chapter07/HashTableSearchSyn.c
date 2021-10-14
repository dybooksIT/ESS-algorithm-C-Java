#include <stdio.h>
#define LENGTH 10
#define TRUE -1

// 해시 테이블의 실체가 되는 배열(요소 수를 10개로 함)
int hashTable[] = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

// 해시 함수
int hashFunc(int data) {
  return data % 10;
}

// 프로그램의 시작점인 main 함수
int main() {
  int data, hashValue;
  int pos;    // 저장 위치, 검색 위치

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

    // 데이터의 저장 위치를 정함
    pos = hashValue;
    while (hashTable[pos] != -1) {
      // 다음 배열 요소에서 데이터를 저장할 수 있는지 확인
      pos++;

      // 배열 마지막 요소까지 데이터 저장 가능 여부를
      // 확인하면 배열 첫 번째 요소를 지정
      if (pos >= LENGTH) {
        pos = 0;
      }

      // 해시값의 배열 요소 위치까지 돌아오면,
      // 해시 테이블에 데이터가 가득 찬 것이므로 반복을 종료
      if (pos == hashValue) {
        break;
      }
    }

    if (hashTable[pos] == -1) {
      // 해시 테이블에 데이터가 가득 차지 않았다면 데이터를 저장
      hashTable[pos] = data;
    }
    else {
      // '해시 테이블이 가득 찼습니다'를 표시
      printf("해시 테이블이 가득 찼습니다.\n");
    }
  } while (TRUE);

  // 해시 테이블에서 데이터를 탐색
  do {
    // 키보드로 탐색할 데이터를 입력
    printf("\n탐색할 데이터 = ");
    scanf("%d", &data);

    // 음숫값이 입력되면 데이터 탐색을 종료
    if (data < 0) {
      break;
    }

    // 해시값을 구함
    hashValue = hashFunc(data);

    // 데이터를 탐색
    pos = hashValue;
    while (hashTable[pos] != -1 && hashTable[pos] != data) {
      // 다음 배열 요소로 탐색 위치를 이동
      pos++;

      // 배열 마지막 요소까지 탐색하면 배열 첫 번째 요소를 지정
      if (pos >= LENGTH) {
        pos = 0;
      }

      // -1을 찾았거나, 해시값의 인덱스 위치로 돌아오면,
      // 데이터를 찾을 수 없는 것이므로 반복을 종료
      if (hashTable[pos] == -1 || pos == hashValue) {
        break;
      }
    }

    // 탐색한 결과를 표시
    if (hashTable[pos] == data) {
      printf("%d번째에서 발견되었습니다.\n", pos);
    }
    else {
      printf("찾을 수 없습니다.\n");
    }
  } while (TRUE);

  return 0;
}