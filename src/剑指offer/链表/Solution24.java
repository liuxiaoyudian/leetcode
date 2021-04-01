package 剑指offer.链表;

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
     * @param head
     * @return
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
     * 使用头插法，这个才是最简单的！！！！
     * @param head
     * @return
     */
    public ListNode ReverseList1(ListNode head) {
        ListNode ret = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = ret.next;
            ret.next = head;
            head = next;
        }
        return ret.next;
    }

}
