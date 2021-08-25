package 剑指offer.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * 18.2 删除链表中重复的结点
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/18.2%20删除链表中重复的结点.md
 */
public class Solution18_2 {


    /**
     * 暴力解法
     * 第一次遍历，找出所有的重复的值，然后存入set
     * 第二次遍历，删除重复值
     * 重点掌握 prev + cur，两个指针一前一后的这种思想
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        Set<Integer> set = new HashSet<>(); // 重复的值存入set
        ListNode prev = pHead;
        ListNode cur = pHead.next;
        while (cur != null) {
            if (prev.val == cur.val) {
                set.add(prev.val);
            }
            prev = prev.next;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        prev = dummy;
        cur = pHead;
        while (cur != null) {
            if (set.contains(cur.val)) {
                cur = cur.next;
                prev.next = cur;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 暴力解法的改进
     * 同样是两个指针，prev + cur
     */
    public ListNode deleteDuplication1(ListNode pHead) {
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode prev = dummy;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                while (cur.next != null && cur.val == cur.next.val) { // 如果重复超过2次就会进入这个循环
                    cur = cur.next;
                }
                cur = cur.next;
                prev.next = cur;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 递归
     */
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication2(next);
        } else {
            pHead.next = deleteDuplication2(next);
            return pHead;
        }
    }

}
