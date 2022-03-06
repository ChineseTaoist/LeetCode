public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode tail = head.next;
        ListNode tailFront = head;
        while (tail != null){
            ListNode current = head;
            ListNode front = null;
            while (current != tail){
                // 如果tail小于current的值，则将tail塞到current前面
                if (current.val >= tail.val){
                    // 当front为null时，head改变，塞到current前面
                    if (front == null){
                        ListNode temp = tail.next;
                        head = tail;
                        tail.next = current;
                        tail = temp;
                        tailFront.next = tail;
                    }
                    // 当front不为null，塞到front后面current前面
                    else {
                        ListNode temp = tail.next;
                        front.next = tail;
                        tail.next = current;
                        tail = temp;
                        tailFront.next = tail;
                    }
                    break;
                }
                // 如果大于，则将current往后移
                else {
                    front = current;
                    current = current.next;
                }
            }
            if (current == tail){
                tailFront = tail;
                tail =tail.next;
            }
        }
        return head;
    }
}
