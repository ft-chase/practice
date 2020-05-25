import java.util.Arrays;

public class Reverse {

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 6, 1, 9, 3, 8, 5};
        String ss = "aaass";
        String dd="dsa";
        //int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 10, 11};
        System.out.println('a'-'b');
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverse(ListNode head) {

        ListNode temp;
        ListNode pre = null;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
