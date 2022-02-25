import java.util.HashSet;

public class DetectCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (true){
            if (head == null){
                return null;
            }
            if (listNodes.contains(head)){
                return head;
            }else {
                listNodes.add(head);
            }
            head = head.next;
        }
    }
}
