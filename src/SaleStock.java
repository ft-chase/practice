import java.util.Arrays;

public class SaleStock {
    public static void main(String[] args) {
        int[] arr = {7,3,5,1,6,4};
        //int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 10, 11};
        int i = maxProfit(arr);
        System.out.println(i);
    }
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0];
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > result) {
                result = prices[i] - min;
            }
        }
        return result;

		/*if (prices.length == 0) return 0;
		int min = prices[0];
		int result = 0;
		for (int i = 1; i < prices.length; i++) {
			result = Math.max(result, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return result;*/
    }
}
