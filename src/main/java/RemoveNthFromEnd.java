public class RemoveNthFromEnd {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode nodeN = head;
        for (int i = 0; i < n; i++){
            if (temp == null){
                if (i == n - 1){
                    return head.next;
                }else {
                    return head;
                }
            }
            temp = temp.next;
        }
        if(temp == null){
            return head.next;
        }
        while (temp.next != null){
            temp = temp.next;
            nodeN = nodeN.next;
        }
        if (nodeN.next != null) {
            nodeN.next = nodeN.next.next;
        }
        return head;
    }
}
