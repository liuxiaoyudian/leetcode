package 剑指offer.链表;

/**
 * 链表中倒数第 K 个结点
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/22.%20链表中倒数第%20K%20个结点.md
 */
public class Solution22 {

    /**
     * 先遍历一遍链表，获得链表的长度
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        int n = 0;
        ListNode cur = pHead;
        while (cur != null) {
            cur = cur.next;
            n++;
        }

        if (pHead == null || n < k) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        n -= k;
        while (n-- >= 0) {
            dummy = dummy.next;
        }
        return dummy;
    }

    /**
     * 双指针
     * 解题思路：
     * 设链表的长度为 N。设置两个指针 P1 和 P2，先让 P1 移动 K 个节点，则还有 N - K 个节点可以移动。
     * 此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，P2 移动到第 N - K 个节点处，该位置就是倒数第 K 个节点。
     */
    public ListNode FindKthToTail1 (ListNode pHead, int k) {
        if (pHead == null) {
            return null;
        }
        ListNode p1 = pHead;
        while (p1 != null && k-- > 0) {
            p1 = p1.next;
        }
        if (k > 0) {  //  如果该链表长度小于k，返回空。
            return null;
        }
        ListNode p2 = pHead;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

}
