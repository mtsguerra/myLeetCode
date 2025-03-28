public class ex0002 {

    /**
     * Constructor for singly-linked list node.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Adds two numbers represented by linked lists.
     * Each node contains a single digit, and digits are stored in reverse order.
     *
     * Time Complexity: O(max(n,m)) where n and m are lengths of lists
     * Space Complexity: O(max(n,m)) for the result list
     *
     * @param l1 First number as a linked list
     * @param l2 Second number as a linked list
     * @return The sum of the two numbers as a linked list
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head for the result list
        ListNode head = new ListNode();
        ListNode current = head;

        boolean exceeded = false;

        while (l1!=null && l2!=null){
            int currentSum = l1.val + l2.val;
            if (exceeded) currentSum++;

            if (currentSum >=10){
                currentSum %= 10;
                exceeded = true;
            }
            else exceeded = false;

            current.next = new ListNode(currentSum);

            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }
        while (l1!=null){
            int currentSum=0;
            if (exceeded){
                currentSum++;
            }
            currentSum += l1.val;
            if (currentSum >= 10){
                currentSum %= 10;
                exceeded = true;
            }
            else exceeded = false;
            current.next = new ListNode(currentSum);
            l1 = l1.next;
            current = current.next;
        }
        while (l2!=null){
            int currentSum=0;
            if (exceeded){
                currentSum++;
            }
            currentSum += l2.val;
            if (currentSum >= 10){
                currentSum %= 10;
                exceeded = true;
            }
            else exceeded = false;
            current.next = new ListNode(currentSum);
            l2 = l2.next;
            current = current.next;
        }

        if (exceeded){
            current.next = new ListNode(1);
        }

        return head.next;
    }

    //--------------------------------------------------------------------//

}
