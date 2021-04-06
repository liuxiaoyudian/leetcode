package 剑指offer.树;

/**
 * 二叉搜索树与双向链表
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/36.%20二叉搜索树与双向链表.md
 */
public class Solution36 {

    private TreeNode head = null;

    private TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);  // 这个代码会直接跑到二叉搜索树的最左边
        node.left = pre;  // 无论pre是否为null，当前节点的left都应该设置为pre
        if (pre != null) {   // 如果pre不为null，就将pre的right设为当前节点
            pre.right = node;
        }
        pre = node;
        if (head == null) {  // 这里只会执行一次
            head = node;
        }
        inOrder(node.right);
    }

}
