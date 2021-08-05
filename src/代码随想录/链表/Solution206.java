package 代码随想录.链表;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/submissions/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0206.翻转链表.md
 */
public class Solution206 {

    /**
     * 双指针法
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // 保存前一个节点
        ListNode cur = head; // 当前节点
        ListNode temp = null; // 保存下一个节点
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

}
