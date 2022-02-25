import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class MergeKLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class SortedStack{
        private Stack<ListNode> nodeStack;
        private Stack<ListNode> tempStack;
        SortedStack(){
            nodeStack = new Stack<>();
            tempStack = new Stack<>();
        }
        public void push(ListNode node){
            while (true){
                if (nodeStack.empty() || nodeStack.peek().val >= node.val){
                    nodeStack.push(node);
                    while (!tempStack.empty()){
                        nodeStack.push(tempStack.pop());
                    }
                    break;
                }else {
                    tempStack.push(nodeStack.pop());
                }
            }
        }
        public ListNode pop(){
            return nodeStack.empty() ? null : nodeStack.pop();
        }
        public ListNode peek(){
            return nodeStack.empty() ? null : nodeStack.peek();
        }
        public boolean empty(){
            return nodeStack.empty();
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        SortedStack sortedStack = new SortedStack();
        int numNull = 0;
        for (ListNode list : lists) {
            if (list == null){
                numNull ++;
                continue;
            }
            sortedStack.push(list);
        }
        ListNode head = sortedStack.peek();
        if(head == null){
            return head;
        }

        ListNode tail = null;
        while (true){
            ListNode temp = sortedStack.pop();
            if (temp == null){
                numNull++;
                if (numNull == lists.length){
                    break;
                }
                continue;
            }
            if (tail != null){
                tail.next = temp;
            }
            tail = temp;
            temp = temp.next;
            if (temp != null) sortedStack.push(temp);

        }
        return head;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        int numNull = 0;
        for (ListNode list : lists) {
            if (list == null){
                numNull ++;
                continue;
            }
            priorityQueue.offer(list);
        }
        if (priorityQueue.size() == 0){
            return null;
        }
        ListNode head = priorityQueue.peek();

        ListNode tail = null;
        while (true){
            ListNode temp = priorityQueue.poll();
            if (temp == null){
                numNull++;
                if (numNull == lists.length){
                    break;
                }
                continue;
            }
            if (tail != null){
                tail.next = temp;
            }
            tail = temp;
            temp = temp.next;
            if (temp != null) priorityQueue.offer(temp);
        }
        return head;
    }


    public static void main(String[] args){
        int[][] l1 = new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] lists = new ListNode[3];
        for (int i = 0; i < 3; i++){
            ListNode past = null;
            for (int val: l1[i]){
                ListNode temp = new ListNode(val);
                if (past == null){
                    past = temp;
                    lists[i] = temp;
                }else {
                    past.next = temp;
                }
            }
        }
        MergeKLists mergeKLists = new MergeKLists();
        mergeKLists.mergeKLists2(lists);

    }
}
