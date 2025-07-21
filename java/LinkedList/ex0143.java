import java.util.*;

class ex0143{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Reorders a linked list in a specific pattern.
     * The pattern is such that the first node is followed by the last node,
     * then the second node, followed by the second last node, and so on.
     *
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * Space Complexity: O(1), as we are using only a few pointers.
     *
     * @param head the head of the linked list
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null;
        ListNode firstHalf = head;
        while (secondHalf != null && firstHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

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