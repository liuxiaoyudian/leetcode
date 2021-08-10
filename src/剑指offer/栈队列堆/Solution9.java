package 剑指offer.栈队列堆;

import java.util.Stack;

/**
 * 9. 用两个栈实现队列
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/9.%20用两个栈实现队列.md
 */
public class Solution9 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
