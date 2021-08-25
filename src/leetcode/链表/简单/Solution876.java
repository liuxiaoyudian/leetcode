package leetcode.链表.简单;

import leetcode.ListNode;

/**
 * 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/submissions/
 */
public class Solution876 {

    /**
     * 数组
     */
    public ListNode middleNode(ListNode head) {
        ListNode[] arr = new ListNode[100]; // 题目的限制条件：给定链表的结点数介于 1 和 100 之间
        int t = 0;
        while (head != null) {
            arr[t++] = head;
            head = head.next;
        }
        return arr[t / 2];
    }

    /**
     * 先遍历链表获得长度
     */
    public ListNode middleNode1(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while (k < n / 2) {
            cur = cur.next;
            k++;
        }
        return cur;
    }

    /**
     * 快慢指针（最优解法）
     */
    public ListNode middleNode2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
