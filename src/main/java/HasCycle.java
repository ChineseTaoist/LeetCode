import java.util.HashSet;

public class HasCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // Set求解
    public boolean hasCycle(ListNode head) {
        HashSet<Integer> nodeSet = new HashSet<Integer>();
        ListNode temp = head;
        while (temp != null){
            if (nodeSet.contains(temp.hashCode())){
                return true;
            }
            nodeSet.add(temp.hashCode());
            temp = temp.next;
        }
        return false;
    }
    // 快慢指针实现，一个一次走一步，一个一次走两步
    public boolean hasCycle2(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
