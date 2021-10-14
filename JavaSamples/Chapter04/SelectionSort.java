public class SelectionSort {
  public static void printArray(int[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.printf("[" + a[i] + "]");
    }
    System.out.printf("\n");
  }

  public static void main(String[] args) {
    int[] a = { 90, 34, 78, 12, 56 };
    int ins, cmp, min, temp;
      
    // 정렬 전 배열 내용을 표시
    System.out.printf("정렬 전 배열\n");
    printArray(a);
    System.out.printf("\n");

    // 배열 요소 수 -1만큼 반복
    for (ins = 0; ins < a.length - 1; ins++) {
      min = ins;

      // ins번째와 비교해 더 작은 값이 있다면 min값 수정
      for (cmp = ins + 1; cmp < a.length; cmp++) {
        if (a[cmp] < a[ins]) {
          min = cmp;

          // min값이 변경되었다면 자리를 교환
          temp = a[ins];
          a[ins] = a[min];
          a[min] = temp;
        }
      }
    }

    // 정렬 후 배열 내용을 표시
    System.out.printf("정렬 후 배열\n");
    printArray(a); 
  }
}