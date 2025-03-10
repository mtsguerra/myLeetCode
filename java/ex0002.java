public class ex0002 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //--------------------------------------------------------------------//
    // on this one i will be using a head to be the start of the new listNode, so i can
    // access it later on to get the whole list, and will also being using a exceeded boolean
    // to track if the last sum that i did exceeded the number 10, if so i will be adding 1
    // to the current sum, the loop revolves around the l1 and l2 not being ==null

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

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
            ListNode nxt = new ListNode(currentSum);
            current.next = nxt;
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
            ListNode nxt = new ListNode(currentSum);
            current.next = nxt;
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
            ListNode nxt = new ListNode(currentSum);
            current.next = nxt;
            l2 = l2.next;
            current = current.next;
        }

        if (exceeded){
            ListNode nxt = new ListNode(1);
            current.next = nxt;
            current = current.next;
        }

        return head.next;
    }

    //--------------------------------------------------------------------//

}
