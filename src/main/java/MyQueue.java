import java.util.Stack;

public class MyQueue {

    Stack<Integer> store;
    Stack<Integer> temp;

    public MyQueue() {
        store = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        while (!store.empty()){
            temp.push(store.pop());
        }
        store.push(x);
        while (!temp.empty()){
            store.push(temp.pop());
        }
    }

    public int pop() {
        return store.pop();
    }

    public int peek() {
        return store.peek();
    }

    public boolean empty() {
        return store.empty();
    }
}
