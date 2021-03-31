package 剑指offer.链表;

import java.util.ArrayList;
import java.util.Stack;

public class Solution6 {


    /**
     * 自己的实现
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            ret.add(list.get(i));
        }
        return ret;
    }

    /**
     * 使用栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }

    /**
     * 使用递归，这里递归并不一定是个好解法，重点是理解思想
     * 思想部分（重要，体会下为什么这样写！）：
     * 要逆序打印链表 1->2->3（3,2,1)，可以先逆序打印链表 2->3(3,2)，最后再打印第一个节点 1。
     * 而链表 2->3 可以看成一个新的链表，要逆序打印该链表可以继续使用求解函数，也就是在求解函数中调用自己，这就是递归函数。
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead2(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    /**
     * 使用头插法
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        // 为了能将一个节点插入头部，我们引入了一个叫头结点的辅助节点，该节点不存储值，只是为了方便进行插入操作。
        // 不要将头结点与第一个节点混起来，第一个节点是链表中第一个真正存储值的节点。
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            // 体会下面两步
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        // 不要忘记这一步！
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
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
