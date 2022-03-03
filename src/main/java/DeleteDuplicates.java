public class DeleteDuplicates {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode node1 = null;
        ListNode node2 = head;
        head = null;
        while (node2 != null){
            boolean isRepeat = false;
            while (node2.next != null && node2.val == node2.next.val){
                node2 = node2.next;
                isRepeat = true;
            }
            if (!isRepeat){
                if(node1 == null){
                    head = node2;
                }
                node1 = node2;
                node2 = node2.next;
            }else {
                if (node1 != null){
                    node1.next = node2.next;
                }
                node2 = node2.next;
            }
        }
        return head;
    }
}
