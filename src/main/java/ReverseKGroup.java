import java.util.Stack;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        for (int i = 0;i < k;i ++){
            stack.push(temp);
            if (temp.next == null && i < k - 1){
                return head;
            }
            temp = temp.next;
        }
        head.next = reverseKGroup(stack.peek().next, k);
        ListNode newHead = stack.peek();
        while (stack.size() > 1){
            temp = stack.pop();
            temp.next = stack.peek();
        }
        return newHead;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
