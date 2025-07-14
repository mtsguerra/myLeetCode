import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ex1290{

    public int getDecimalValue(ListNode head) {

        // Iterative approach to convert binary linked list to decimal
        int ans = 0;
        while (head != null) {
            ans = ans * 2 + head.val;
            head = head.next;
        }
        return ans;

        // Bit manipulation approach (commented out)
        /*
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) | head.val; // Shift left and add the current value
            head = head.next; // Move to the next node
        }
        return ans;
        */
        // Alternative approach using a list (commented out)

        /*List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int sz = list.size();
        int ans = 0;
        for (int i = 0; i < sz; i++) {
            ans += list.get(i) * Math.pow(2, sz - i - 1);
        }
        return ans;*/
    }

    public static void main(String[] args) {

    }
}