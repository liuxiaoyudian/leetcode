package 剑指offer.链表;

/**
 * 两个链表的第一个公共结点
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/52.%20两个链表的第一个公共结点.md
 */
public class Solution52 {

    /**
     * 暴力法
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        while (pHead1 != null) {
            ListNode cur = pHead2;
            while (cur != null) {
                if (cur == pHead1) {
                    return cur;
                }
                cur = cur.next;
            }
            pHead1 = pHead1.next;
        }
        return null;
    }

    /**
     * 长度相同有公共结点，第一次就遍历到；没有公共结点，走到尾部NULL相遇，返回NULL
     * 长度不同有公共结点，第一遍差值就出来了，第二遍一起到公共结点；没有公共，一起到结尾NULL。
     * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
     *
     * 另外一种理解方式：
     * 假设两个链标分别是l1和l2，在l1后面拼上l2组成新的l1，在l2的后面拼上l1组成新的l2。此时l1和l2的长度相同。
     * 然后同时遍历l1和l2。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = l1 == null ? pHead2 : l1.next;
            l2 = l2 == null ? pHead1 : l2.next;
        }
        return l1;
    }

}
