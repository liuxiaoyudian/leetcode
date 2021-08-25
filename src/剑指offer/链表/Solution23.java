package 剑指offer.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * 23. 链表中环的入口结点
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/23.%20链表中环的入口结点.md
 */
public class Solution23 {


    /**
     * Set
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (set.contains(pHead)) {
                return pHead;
            }
            set.add(pHead);
            pHead = pHead.next;

        }
        return null;
    }


    /**
     * 快慢指针
     * 慢指针1次走1步，快指针1次走2步
     * 推导公式：a = (n-1) * (b + c) + c
     * 公式含义：从快慢指针相遇点和head分别出发，1次走一步，相遇点就是环形入口
     *
     * 题目的两个隐藏条件：
     *  1、慢指针最多最多绕着环走一圈（pHead就是环入口的情况）
     *  2、快指针最多走两圈（pHead就是环入口的情况），最少走一圈
     */
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        ListNode fast = pHead, slow = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode cur = pHead;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }

}
