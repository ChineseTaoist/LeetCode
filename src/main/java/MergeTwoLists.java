public class MergeTwoLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode start = new ListNode();
        ListNode last = start;
        while (temp1 != null || temp2 != null){
            int val1 = temp1 != null ? temp1.val : 101;
            int val2 = temp2 != null ? temp2.val : 101;
            if (val1 > val2){
                last.next = temp2;
                temp2 = temp2.next;
            }else{
                last.next = temp1;
                temp1 = temp1.next;
            }
            last = last.next;
        }
        return start.next;
    }
}
