/*public class ex019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = head;
        ListNode current = head;
        ListNode last = null;
        int sz = head.size;
        int i =0;
        while (i < sz-n){
            last = current;
            current = current.next;
        }
        if (current.next==null){
            last.next = null;
        }
        else {
            last.next = current.next;
        }
        return dummyHead;
    }
}

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
*/