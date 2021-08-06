package 代码随想录.链表;

/**
 * 面试题 02.07. 链表相交
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/面试题02.07.链表相交.md
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/52.%20两个链表的第一个公共结点.md
 */
public class 两个链表的第一个公共结点 {

    /**
     * 暴力法
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode cur = headB;
            while (cur != null) {
                if (cur == headA) {
                    return cur;
                }
                cur = cur.next;
            }
            headA = headA.next;
        }
        return null;
    }

    /**
     *
     * 例子
     * a链：a1 -> a2 -> c1 -> c2 -> c3
     * b链：b1 -> b2 -> b3 -> c1 -> c2 -> c3
     * a+b：a1 -> a2 -> c1 -> c2 -> c3 -> b1 -> b2 -> b3 -> c1 -> c2 -> c3
     * b+a：b1 -> b2 -> b3 -> c1 -> c2 -> c3 -> a1 -> a2 -> c1 -> c2 -> c3
     * a+b和b+a的长度是相同的，如果两个链有共同的尾巴，则会在a+b链和b+a链中对齐
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }

}
