package 代码随想录.链表;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://cn.com/problems/remove-nth-node-from-end-of-list/submissions/
 *
 * https://github.com/liuxiaoyudian/master/blob/master/problems/0019.删除链表的倒数第N个节点.md
 */
public class Solution19 {

    /**
     * 循环2遍，第一遍确认长度，第二遍删除
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        ListNode dummyHead = new ListNode(-1, head);
        cur = dummyHead;
        int index = len - n; // 下标
        while (index-- > 0) {  // 在有dummyHead的情况下，index-- > 0找的就是前一个node
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }

    /**
     * 双指针法（快慢指针）
     * 快指针先走n+1步，然后快慢指针同时移动
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;
        while (n-- >= 0) { // fast首先走n+1步，这样同时移动的时候slow才能指向删除节点的上一个节点（方便做删除操作）
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 双指针法（快慢指针）
     * 快指针先走n步，然后快慢指针同时移动
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n-- > 0) { // fast首先走了n步，当fast == null时，slow指向的就是需要删除的哪个节点
            fast = fast.next;
        }
        ListNode prev = null; // 记住待删除节点slow的上一节点
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return dummy.next;
    }

}
