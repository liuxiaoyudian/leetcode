package 剑指offer.链表;

import java.util.*;

/**
 * 6. 从尾到头打印链表
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/6.%20从尾到头打印链表.md
 */
public class Solution6 {

    /**
     * 自己的实现
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }


    /**
     * 栈
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.poll());
        }
        return list;
    }


    ArrayList<Integer> list = new ArrayList();
    /**
     * 递归
     * 并不是一个好方法，但是会导致栈溢出
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    /**
     * 头插法
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        ArrayList<Integer> list = new ArrayList<>();
        head = head.next;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

}

/**
 * 牢记链表的数据结构
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
