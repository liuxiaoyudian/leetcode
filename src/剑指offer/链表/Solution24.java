package 剑指offer.链表;

/**
 * 24. 反转链表
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/24.%20反转链表.md
 */
public class Solution24 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        ListNode h =  ReverseList(n1);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

    /**
     * 递归法
     * 每一个栈帧中都存了一个Head，并且Head.next==null
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseList(next);
        next.next = head;
        return newHead;
    }

    /**
     * 头插法
     */
    public ListNode ReverseList1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }

    /**
     * 迭代法（最优解法）
     */
    public ListNode ReverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
