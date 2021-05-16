package leetcode.中等;

import leetcode.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
 *
 * 删除链表倒数第N个节点，怎么删？:https://mp.weixin.qq.com/s/gxu65X1343xW_sBrkTz0Eg
 *
 * 这个题和剑指offer中链表中倒数第k个结点类似
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        // fast首先走n+1步，这样同时移动的时候slow才能指向删除节点的上一个节点（方便做删除操作）
        while (n-- >= 0) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        // fast首先走了n步，当fast == null时，slow指向的就是需要删除的哪个节点
        while (n-- > 0) {
            fast = fast.next;
        }
        // 记住待删除节点slow的上一节点
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        // 上一节点的next指针绕过 待删除节点slow 直接指向slow的下一节点
        prev.next = slow.next;
        return dummy.next;
    }

}
