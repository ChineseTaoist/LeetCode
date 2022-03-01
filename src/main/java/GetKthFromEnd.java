public class GetKthFromEnd {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 0; i < k; i++){
            if (head == null){
                return null;
            }
            temp = temp.next;
        }
        while (temp.next == null){
            temp = temp.next;
            head = head.next;
        }
        return head;
    }
}
