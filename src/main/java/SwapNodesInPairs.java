public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null){
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }else {
            return head;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
