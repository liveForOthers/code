package code.code_151_200.code_155;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    /*
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     *
     * Example:
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> Returns -3.
     * minStack.pop();
     * minStack.top();      --> Returns 0.
     * minStack.getMin();   --> Returns -2.
     *
     * */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        int curMin = minStack.isEmpty() ? x : Math.min(x, minStack.peek());
        stack.push(x);
        minStack.push(curMin);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()){
            throw new IllegalArgumentException("栈为空");
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()){
            throw new IllegalArgumentException("栈为空");
        }
        return minStack.peek();
    }
    Deque<Integer> stack;
    Deque<Integer> minStack;

}
