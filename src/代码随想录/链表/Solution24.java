package 代码随想录.链表;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0024.两两交换链表中的节点.md
 */
public class Solution24 {

    /**
     * 迭代法
     * 直接按顺序进行模拟即可
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead; // cur指向的是需要交换的两个节点的前一个节点
        while (cur.next != null && cur.next.next != null) { // 这两个节点要存在才能交换，否则不做任何操作
            ListNode temp1 = cur.next;  // 记录临时节点
            ListNode temp2 = cur.next.next.next; // 记录临时节点
            cur.next = cur.next.next;
            cur.next.next = temp1;
            cur.next.next.next = temp2;
            cur = cur.next.next;
        }
        return dummyHead.next;
    }

    /**
     * 递归
     * head表示原始链表的头节点
     * newHead表示新的链表的头节点
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) { // 递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
