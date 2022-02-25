import java.util.List;

// 92
public class ReverseBetween {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null){
            return head;
        }
        // 首先让temp跑到left前一个
        ListNode currentNode = head;
        for (int i = 0; i < left - 2; i++){
            currentNode = currentNode.next;
        }
        ListNode leftPast = null;
        ListNode leftNode = head;
        if (left - 2 >= 0 && right - left > 0){
            leftPast = currentNode;
            leftNode = currentNode.next;
        }
        ListNode past = leftPast;
        currentNode = leftNode;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode temp = currentNode.next;
            if (past != leftPast) currentNode.next = past;
            past = currentNode;
            currentNode = temp;
        }
        if (leftPast != null) leftPast.next = past;
        leftNode.next = currentNode;
        return left > 1 ? head : past;
    }
}
