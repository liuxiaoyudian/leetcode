package 代码随想录.栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0225.用队列实现栈.md
 */
public class Solution225 {

    /**
     * 队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
     * LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
     * Queue接口与List、Set同一级别，都是继承了Collection接口。LinkedList实现了Deque接口。
     * 注意：
     * 虽然LinkedList没有禁止添加null，但是一般情况下Queue的实现类都不允许添加null元素。
     * 因为poll，peek方法在异常的时候会返回null，你添加了null以后，当获取时不好分辨究竟是否正确返回。
     *
     * 常用方法：
     * 队列尾增加一个元素 - 移除并返回队列头元素 - 返回队列头元素
     * add() - remove() - element() - 出现队列满或空的情况会抛出异常
     * offer() - poll() - peek() - 不会抛出异常，返回false或者null
     * isEmpty();
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
    }

}

/**
 * 使用2个队列实现
 */
class MyStack {

    Queue<Integer> queue1; // 存储栈内的元素

    Queue<Integer> queue2; // 入栈操作的辅助队列

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }


    /** Push element x onto stack. */
    public void push(int x) {
        // 思路：每次入栈操作都确保queue1的前端元素为栈顶元素
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * 使用1个队列实现
 */
class MyStack1 {

    Queue<Integer> queue;

    int size;

    /** Initialize your data structure here. */
    public MyStack1() {
        queue = new LinkedList<>();
        size = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
        size++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

