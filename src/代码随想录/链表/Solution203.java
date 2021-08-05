package 代码随想录.链表;

import leetcode.ListNode;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * 虚拟头节点：https://mp.weixin.qq.com/s/L5aanfALdLEwVWGvyXPDqA
 */
public class Solution203 {

    /**
     * 普通的处理方法，要有处理头节点和非头节点的逻辑
     */
    public ListNode removeElements(ListNode head, int val) {
        // 删除头节点
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 删除非头节点
        ListNode cur = head;
        // cur != null这个判断不能少，否则如果head为null或者链表中所有的值都和val一样的时候，会报错
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    /**
     * 使用了虚拟头节点的实现，只有一种处理逻辑（此处是把头节点也当成了非头节点来处理）
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }


}
