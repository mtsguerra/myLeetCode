public class ex0019 {
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