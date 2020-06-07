package code.code_201_250.code_225;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {

    Deque<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Deque<Integer> tempQueue = new LinkedList<>();
        tempQueue.offer(x);
        while (!queue.isEmpty()) {
            tempQueue.offer(queue.poll());
        }
        queue = tempQueue;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peekFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
