package 剑指offer.栈队列堆;

import java.util.Stack;

public class Solution30 {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();


    /**
     * 记住Stack都有哪些方法：isEmpty(), peek()
     * @param node
     */
    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
