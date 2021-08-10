package 剑指offer.栈队列堆;

import java.util.Stack;

/**
 * JZ20 包含min函数的栈
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/30.%20包含%20min%20函数的栈.md
 *
 * 使用一个额外的 minStack，栈顶元素为当前栈中最小的值。
 * 在对栈进行 push 入栈和 pop 出栈操作时，同样需要对 minStack 进行入栈出栈操作，从而使 minStack 栈顶元素一直为当前栈中最小的值。
 * 在进行 push 操作时，需要比较入栈元素和当前栈中最小值，将值较小的元素 push 到 minStack 中。
 */
public class Solution30 {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();


    /**
     * 记住Stack都有哪些方法：isEmpty(), peek()
     */
    public void push(int node) {
        dataStack.push(node);
        // 理解这个思想！！！
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
