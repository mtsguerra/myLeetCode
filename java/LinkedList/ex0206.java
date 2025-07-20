/**
 * Definition for singly-linked list.
 *
 */
class ex0206 {

    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Reverses a singly linked list.
     *
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * Space Complexity: O(1), as we are using only a few pointers.
     *
     * @param head the head of the linked list
     * @return the new head of the reversed linked list
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}