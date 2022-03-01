import java.util.Stack;

public class ReorderList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode tail = head;
        while (tail != null){
            nodeStack.push(tail);
            tail = tail.next;
        }
        while (head != null && !nodeStack.empty()){
            if (nodeStack.peek() == head){
                head.next = null;
                break;
            }else if (head.next == nodeStack.peek()){
                head.next.next = null;
                break;
            }
            ListNode temp = head.next;
            head.next = nodeStack.pop();
            head.next.next = temp;
            head = temp;
        }
    }
}
