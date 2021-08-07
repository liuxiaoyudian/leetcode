package 代码随想录.栈与队列;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0232.用栈实现队列.md
 *
 * Stack常用方法push(int x), pop(), peek(), isEmpty() (empty()也行)
 * 其中pop和peek如果不存在，则会报EmptyStackException
 */
public class Solution232 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

}

class MyQueue {

    Stack<Integer> stack1;

    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        dumpStack();
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        dumpStack();
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void dumpStack() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */