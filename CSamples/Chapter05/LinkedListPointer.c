#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// StationList 구조체 정의
struct StationList {
  char name[20];            // 역 이름
  struct StationList *prev, *next;    // 포인터
};

void printStationList(struct StationList *head) {
  struct StationList *cur = head->next;

  while (cur != NULL) {
    printf("[%s] → ", cur->name);
    cur = cur->next;
  }

  printf("\n");
}

void insStationList(struct StationList *pNode, struct StationList *nNode, char newName[]) {
  struct StationList *insNode = malloc(sizeof(struct StationList));
  strcpy(insNode->name, newName);

  pNode->next = insNode;
  insNode->next = nNode;
}

void delStationList(struct StationList *pNode) {
  struct StationList *delNode = pNode->next;
  pNode->next = delNode->next;

  free(delNode);
}

void freeMemory(struct StationList *head) {
  struct StationList *cur = head->next;

  while (cur != NULL) {
    struct StationList *next = cur->next;
    free(cur);
    cur = next;
  }

  free(head);
}

// 프로그램 실행의 시작점인 main 함수
int main() {
  // 헤드 포인터 선언
  struct StationList *head = malloc(sizeof(struct StationList));


  struct StationList *sta0 = malloc(sizeof(struct StationList));
  strcpy(sta0->name, "부산");

  struct StationList *sta1 = malloc(sizeof(struct StationList));
  strcpy(sta1->name, "대전");

  struct StationList *sta2 = malloc(sizeof(struct StationList));
  strcpy(sta2->name, "서울");

  struct StationList *sta3 = malloc(sizeof(struct StationList));
  strcpy(sta3->name, "동대구");

  struct StationList *sta4 = malloc(sizeof(struct StationList));
  strcpy(sta4->name, "천안아산");

  head->next = sta2;
  sta2->next = sta4;
  sta4->next = sta1;
  sta1->next = sta3;
  sta3->next = sta0;
  sta0->next = NULL;

  printStationList(head);
  insStationList(sta2, sta4, "광명");
  printStationList(head);
  delStationList(sta2);
  printStationList(head);
  // printf("\n%s\n", head->name);
  freeMemory(head);
  //printf("%s\n", head->name);

  return 0;
}