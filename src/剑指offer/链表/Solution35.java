package 剑指offer.链表;

/**
 * 复杂链表的复制
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/35.%20复杂链表的复制.md
 * 该题目有一个隐含条件，random指针指还是该链表内的节点。
 */
public class Solution35 {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 建立 random 链接
        cur = pHead;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 拆分（拆分完成后，两个链表都是独立的，完整的，并没有破坏原本的结构）
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;  // 先保留next
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }

}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
