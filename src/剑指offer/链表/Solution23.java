package 剑指offer.链表;

import java.util.HashSet;
import java.util.Set;

public class Solution23 {


    /**
     * 自己想的方法，虽然简单但是使用了额外的空间
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (set.contains(pHead)) {
                return pHead;
            }
            set.add(pHead);
            pHead = pHead.next;

        }
        return null;
    }


    /**
     * 快慢指针，fast一次两步，slow一次一步
     * 两个结论：
     * 1、如果有环，两者一定相遇
     * 2、快指针从链表头，慢指针从相遇点继续出发，每次各走一步，最后一定相遇与环入口。
     * 还有两个隐藏条件：
     * 1、慢指针最多最多绕着环走一圈（pHead就是环入口的情况）
     * 2、快指针最多走两圈（pHead就是环入口的情况），最少走一圈。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead, slow = pHead;
        // do-while，先执行，再check
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
