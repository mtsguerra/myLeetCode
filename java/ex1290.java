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
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int sz = list.size();
        int ans = 0;
        for (int i = 0; i < sz; i++) {
            ans += list.get(i) * Math.pow(2, sz - i - 1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}