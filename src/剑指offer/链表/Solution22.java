package 剑指offer.链表;

/**
 * 链表中倒数第 K 个结点
 */
public class Solution22 {

    /**
     * 笨方法
     * 思路是先遍历一遍链表，计算n
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        int n = 0;
        ListNode i = pHead;
        while (i != null) {
            i = i.next;
            n++;
        }
        int m = 0;
        i = pHead;
        while (i != null) {
            if (m == n - k) {
                return i;
            }
            i = i.next;
            m++;
        }
        return null;
    }

    /**
     * 解题思路：
     * 设链表的长度为 N。设置两个指针 P1 和 P2，先让 P1 移动 K 个节点，则还有 N - K 个节点可以移动。
     * 此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，P2 移动到第 N - K 个节点处，该位置就是倒数第 K 个节点。
     * 像这类倒数第几个节点的问题，一前一后的问题，就要想起来用双指针！
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail1 (ListNode pHead, int k) {
        // write code here
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
