public class ex0021 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //--------------------------------------------------------------------//
    // utilizing a dummyHead to we can keep track of the beginning of the ListNode, and
    // int the loop that will iterate through the l1 and l2 until one of them run out of
    // values, we call the value of both and compare them and retrieve the smallest value
    // and append it to the final list, returning in the end the dummyHead that represents
    // the beginning of the list
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode dummyHead = new ListNode();
        ListNode fnl = dummyHead;
        
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                fnl.next = list1;
                list1 = list1.next;
            }
            else{
                fnl.next = list2;
                list2 = list2.next;
            }
            fnl = fnl.next;
        }
        if (list1!=null){
            fnl.next = list1;
        }
        else {
            fnl.next = list2;
        }
        return dummyHead.next;    
    }


    //--------------------------------------------------------------------//
}
