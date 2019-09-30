public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        ListNode temp1 = head;
        ListNode temp2 = head;
        ListNode past = null;
        int count = 1;
        while (temp1.next != null){
            temp1 = temp1.next;
            count ++;
            if (count > n){
                past = temp2;
                temp2 = temp2.next;
            }
        }
        if (count < n){
            return null;
        }
        if (past != null) {
            past.next = temp2.next;
        }else {
            return temp2.next;
        }
        return head;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
