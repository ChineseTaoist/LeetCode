public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isAddOne = false;
        ListNode res = new ListNode();
        ListNode head = res;
        while(true){
            int val = 0;
            if (l1 != null){
                val = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if (isAddOne){
                val += 1;
                isAddOne = false;
            }
            res.val = val % 10;
            if (val >= 10){
                isAddOne = true;
            }
            if (l1 == null && l2 == null && !isAddOne){
                break;
            }
            ListNode temp = new ListNode();
            res.next = temp;
            res = temp;
        }
        return head;
    }
}
