import java.util.Arrays;

public class Program {
  public static void main(String[] args) {
    int[] a = { 1, 5, 1, -3, 6, 2, 3, 4,12 };
    System.out.printf("Исходный массив: " + Arrays.toString(a) + "\n");
    mergeSort(a, a.length);
    System.out.printf("Отсортированный массив: " + Arrays.toString(a));
  }

  public static void mergeSort(int[] a, int n) {      //2, 3
    if (n < 2)
      return; 
    int mid = n / 2;  // 8/2 = 4      2
    int[] l = new int[mid];
    int[] r = new int[n - mid];

    for (int i = 0; i < mid; i++) {
      l[i] = a[i];
    }
    for (int i = mid; i < n; i++) {
      r[i - mid] = a[i];
    }
    mergeSort(l, mid);  //1, 5,     1, 6
    mergeSort(r, n - mid);  //2, 3, 4,12

    merge(a, l, r, mid, n - mid); //23
  }

  public static void merge(int[] a, int[] l, int[] r, int left, int right) {

    int i = 0, j = 0, k = 0;

    while (i < left && j < right) { 

      if (l[i] <= r[j])   
        a[k++] = l[i++];        // 1 2 2 3 4 4 5
      else
        a[k++] = r[j++];

    }

    while (i < left)  ///  1 2 3 4          2 4 5
      a[k++] = l[i++];

    while (j < right)
      a[k++] = r[j++];
  }
}