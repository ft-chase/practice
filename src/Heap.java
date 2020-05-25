import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 6, 1, 9, 3, 8, 5};
        //int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 10, 11};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        int len = arr.length-1;
        for (int i = len / 2 ; i >= 0; i--) {
            //堆构造 (n/2-1)~0的节点才有子节点,每次都是局部最大堆，从下往上
            heapAdjust(arr, i, len);
        }
        System.out.println(Arrays.toString(arr));
        while (len >= 0) {
            swap(arr, 0, len--);    //将堆顶元素与尾节点交换后，长度减1，尾元素最大
            heapAdjust(arr, 0, len);    //再次对堆进行调整
            //System.out.println(Arrays.toString(arr));
        }
    }


    public static void heapAdjust(int[] arr, int i, int len) {
        int left, right, j;
        while ((left = 2 * i + 1) <= len) {    //判断当前父节点有无左节点（即有无孩子节点，left为左节点）
            right = left + 1;  //右节点
            j = left;   //j"指针指向左节点"
            if (j < len  && arr[left] < arr[right]) {  //右节点大于左节点
                j++;
            }    //当前把"指针"指向右节点
            if (arr[i] < arr[j]) {  //将父节点与孩子节点交换（如果上面if为真，则arr[j]为右节点，如果为假arr[j]则为左节点）
                swap(arr, i, j);
                i = j; //如果发生调换，则子节点以下不一定满足最大堆
            } else {        //说明比孩子节点都大，直接跳出循环语句
                break;
            }


        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}