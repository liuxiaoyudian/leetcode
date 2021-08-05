package 代码随想录.链表;

/**
 * 707.设计链表
 * https://leetcode-cn.com/problems/design-linked-list/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0707.设计链表.md
 */
public class Solution707 {

    class MyLinkedList {

        int size;

        ListNode dummyHead;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            this.size = 0;
            this.dummyHead = new ListNode(-1);
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = dummyHead;
            while (index-- >= 0) { // 注意这个等于号，有等号就是找到这个index的node，没有就是找到这个index的前一个node
                cur = cur.next;
            }
            return cur.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            ListNode node = new ListNode(val);
            ListNode cur = dummyHead;
            while (index-- > 0) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
            size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode cur = dummyHead;
            while (index-- > 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            size--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

}
