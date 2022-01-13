import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {

    class DoubleChain{
        DoubleChain next;
        DoubleChain front;
        int key;
        int value;
        public void away(){
            if (next != null){
                next.front = front;
            }
            if (front != null){
                front.next = next;
            }
        }
        public void insert(DoubleChain node){
            this.next.front = node;
            node.next = this.next;
            this.next = node;
            node.front = this;
        }
    }

    private HashMap<Integer, DoubleChain> cacheMap;
    // 可以创建一个链表使得首尾相连
    private DoubleChain last;
    private int usedSpace;
    private int capacity;

    public LRUCache(int capacity) {
        this.cacheMap = new HashMap<Integer, DoubleChain>(capacity);
        this.capacity = capacity;
        this.usedSpace = 0;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)){
            DoubleChain node = cacheMap.get(key);
            if (last.key != node.key){
                node.away();
                last.insert(node);
                last = node;
            }
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)){
            DoubleChain node = cacheMap.get(key);
            node.value = value;
            if (last.key != node.key){
                node.away();
                last.insert(node);
                last = node;
            }
        } else {
            DoubleChain node = new DoubleChain();
            node.key = key;
            node.value = value;
            if (last != null){
                node.front = last;
                node.next = last.next;
                last.next.front = node;
                last.next = node;
                last = node;
            }else {
                last = node;
                last.next = last;
                last.front = last;
            }
            cacheMap.put(key, node);
            this.usedSpace ++;
        }

        if (usedSpace > capacity){
            DoubleChain head = last.next;
            head.away();
            cacheMap.remove(head.key);
            usedSpace --;
        }
    }

    public static void main(String[]args){
        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.get(2);
//        lRUCache.put(2, 6);
//        lRUCache.get(1);
//        lRUCache.put(1, 5);
//        lRUCache.put(1, 2);
//        lRUCache.get(1);
//        lRUCache.get(2);

        lRUCache.put(2,1);
        lRUCache.put(3,2);
        lRUCache.get(3);
        lRUCache.get(2);
        lRUCache.put(4,3);
        lRUCache.get(2);
        lRUCache.get(3);
        lRUCache.get(4);

//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        lRUCache.get(1);    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        lRUCache.get(2);    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        lRUCache.get(1);    // 返回 -1 (未找到)
//        lRUCache.get(3);    // 返回 3
//        lRUCache.get(4);    // 返回 4

    }
}

//if (cacheMap.containsKey(key)){
//            if (this.last.key == key){
//                return this.cacheMap.get(key).value;
//            }
//            DoubleChain temp = this.head;
//            while (temp != null){
//                if (temp.key == key){
//                    if (temp.front != null) {
//                        temp.front.next = temp.next;
//                    }
//                    if (temp.next != null) {
//                        temp.next.front = temp.front;
//                    }
//                    break;
//                }
//                temp = temp.next;
//            }
//            if (temp.key == this.head.key){
//                //如果head与last是同一个节点
//                if (temp.key == this.last.key){
//                    this.head = temp;
//                }else {
//                    this.head = this.head.next;
//                    temp.front = this.last;
//                    temp.next = null;
//                    this.last.next = temp;
//                    this.last = temp;
//                }
//            } else if (temp.key != this.last.key) {
//                temp.front = this.last;
//                temp.next = null;
//                this.last.next = temp;
//                this.last = temp;
//            }
//            return this.cacheMap.get(key).value;
//        }else {
//            return -1;
//        }


//// 如果已经有该key
//        if (this.cacheMap.containsKey(key)){
//                this.cacheMap.get(key).value = value;
//                if (this.last.key == key){
//                return;
//                }
//                DoubleChain temp = this.head;
//                while (temp != null){
//                if (temp.key == key){
//                if (temp.front != null) {
//                temp.front.next = temp.next;
//                }
//                if (temp.next != null) {
//                temp.next.front = temp.front;
//                }
//                break;
//                }
//                temp = temp.next;
//                }
//                if (temp.key == this.head.key){
//                //如果head与last是同一个节点
//                if (temp.key == this.last.key){
//                this.head = temp;
//                }else {
//                this.head = this.head.next;
//                temp.front = this.last;
//                temp.next = null;
//                this.last.next = temp;
//                this.last = temp;
//                }
//                } else if (temp.key != this.last.key) {
//                temp.front = this.last;
//                temp.next = null;
//                this.last.next = temp;
//                this.last = temp;
//                }
//                return;
//                }
//                // 如果存储空间已用尽，把最前面的一个删掉
//                if (this.usedSpace == this.capacity){
//                this.cacheMap.remove(this.head.key);
//                this.head = this.head.next;
//                if (this.head != null) {
//                this.head.front = null;
//                }
//                this.usedSpace --;
//                }
//
//                // 没有这个key，加一个新key
//                DoubleChain newNode = new DoubleChain();
//                newNode.key = key;
//                newNode.value = value;
//                this.cacheMap.put(key, newNode);
//                if (this.head == null){
//                this.head = newNode;
//                }
//                if (last != null){
//                newNode.front = last;
//                last.next = newNode;
//                }
//                this.last = newNode;
//                this.usedSpace ++;