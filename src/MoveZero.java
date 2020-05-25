import java.util.Arrays;

public class MoveZero {

    public static void main(String[] args) {
        int[] arr = {4, 0, 7, 6, 0, 9, 3, 8, 5};
        //int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 10, 11};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            //第一种
            if (nums[i] == 0) {
                continue;
            }
            nums[count++] = nums[i];
            //第二种
			/*if (nums[i] != 0) {
				nums[count++] = nums[i];
			}*/
        }
        while (count < nums.length) {
            nums[count++] = 0;
        }
    }
}
