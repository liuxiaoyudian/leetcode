package 剑指offer.链表;

public class Solution18_2 {

    /**
     * 这个题稍微有点绕，使用递归解决！
     * deleteDuplication(ListNode pHead)，即传入一个节点，返回一个没有重复值的链表
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (next.val == pHead.val) {
            while (next != null && next.val == pHead.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

}
