package 代码随想录.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0142.环形链表II.md
 * 相同的题目：剑指offer 23
 */
public class Solution142 {


    /**
     * 哈希表
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
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
     *  2、快指针最多走两圈（pHead就是环入口的情况），最少走一圈。
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // 有环
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
