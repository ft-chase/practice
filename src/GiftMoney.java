
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GiftMoney {

    //1,2,3,4,5,6,7,8,9
    //(10-9)+(9-8)+(...)+(2-1)+1=10
    List<Integer> hongbao1(int totalAmount, int totalNumber) {
        List<Integer> list = new ArrayList<>();
        if (totalAmount <= 0 || totalNumber <= 0) {
            return list;
        }
        Set<Integer> set = new HashSet<>();
        while (set.size() < totalNumber - 1) {
            int random = ThreadLocalRandom.current().nextInt(1, totalAmount);
            System.out.print(random + "~");
            set.add(random);
        }
        System.out.println("-----------------------------");
        Integer[] amounts = set.toArray(new Integer[0]);
        Arrays.sort(amounts);
        for (int i = 0; i < amounts.length; i++) {
            System.out.print(amounts[i] + "-");
        }
        System.out.println("-----------------------------");
        list.add(amounts[0]);
        for (int i = 1; i < amounts.length; i++) {
            System.out.println("amounts[" + i + "]- amounts[" + (i - 1) + "]:" + amounts[i] + "-" + amounts[i - 1] + "=" + (amounts[i] - amounts[i - 1]));
            list.add(amounts[i] - amounts[i - 1]);
        }
        list.add(totalAmount - amounts[amounts.length - 1]);
        return list;
    }

    List<Integer> hongbao(int totalAmount, int totalNumber) {
        List<Integer> list = new ArrayList<>();
        if (totalAmount <= 0 || totalNumber <= 0) {
            return list;
        }
        for (int i = totalNumber; i >= 2; i--) {
            int x = (totalAmount << 1) / i;
            int random = ThreadLocalRandom.current().nextInt(1, x);
            list.add(random);
            totalAmount -= random;
        }
        list.add(totalAmount);
        return list;
    }


    public void test() {
        List<Integer> list = hongbao(20, 10);
        System.out.println(list);
        System.out.println(list.parallelStream().mapToInt(x -> x).sum());
    }


}
