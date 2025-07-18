public class ex0019 {
    /**
     * Removes the nth node from the end of a linked list.
     *
     * This method uses a two-pointer technique to find the node to be removed.
     * The first pointer traverses the list to find its length,
     * and the second pointer traverses the list again
     * to find the node to be removed.
     *
     * Time Complexity: O(n), where n is the length of the linked list.
     * Space Complexity: O(1), since we are using a constant amount of space.
     *
     * @param head the head of the linked list
     * @param n the position from the end of the list to remove
     * @return the head of the modified linked list
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode last = null;
        int i =0;
        int siz = 0;
        while (current != null){
            siz++;
            current = current.next;
        }
        current = head;
        while (i<siz-n){
            last = current;
            current = current.next;
            i++;
        }
        if (last == null){
            return head.next;
        }
        last.next = current.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}