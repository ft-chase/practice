import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 6, 1, 9, 3, 8, 5};
        //int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 10, 11};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }
    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot - 1);                   //递归排序左子数组
            qsort(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int p = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && arr[j] >= p) {
                j--;
            }
            while (i < j && arr[i] <= p) {
                i++;
            }
            swap(arr, i, j);
        }
        arr[low] = arr[i];
        arr[i] = p;
        return i;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}