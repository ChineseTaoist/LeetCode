import java.util.ArrayList;
import java.util.Map;

public class GetIntersectionNode {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        if (headA == headB){
            return headA;
        }
        ArrayList<ListNode> listA = new ArrayList<ListNode>();
        ArrayList<ListNode> listB = new ArrayList<ListNode>();
        listA.add(headA);
        listB.add(headB);
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA.next != null || tempB.next != null){
            if (tempA.next != null){
                tempA = tempA.next;
                listA.add(tempA);
            }
            if (tempB.next != null){
                tempB = tempB.next;
                listB.add(tempB);
            }
        }
        if (tempA != tempB){
            return null;
        }
        int posA = listA.size() - 1;
        int posB = listB.size() - 1;
        while (posA >=0 && posB >= 0){
            if (listA.get(posA) != listB.get(posB)){
                return listA.get(posA + 1);
            }else {
                posA--;
                posB--;
            }
        }
        return posA >= 0 ? listB.get(0) : listA.get(0);
    }
}
