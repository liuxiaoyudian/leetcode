package 剑指offer.树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的下一个节点（采用中序遍历LDR）。
 * 注意，这道题的意思并不是说采用中序遍历遍历二叉树，而是给定二叉树的任意一个节点，求下一个节点（中序遍历）。
 * <p>
 * 分析一下有两种情况：
 * 1、如果一个节点的右子树不为空，那么该节点的下一个节点是其右子树的最左节点。
 * 2、无右子树，则找第一个当前节点是父节点左孩子的节点。
 * <p>
 * 第二张情况又有两种细分：
 * 1、该节点是父节点的左孩子，那么下一个节点就是其父节点
 * 2、该节点是父节点的右孩子，一直找其父节点，直到当前节点是其父节点的左孩子
 */
public class Solution8 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right; // 不要漏了这一句
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }

    /**
     * 中序遍历迭代法，先找到根结点，然后从根结点开始中序便利
     */
    public TreeLinkNode GetNext1(TreeLinkNode pNode) {
        TreeLinkNode root = pNode; // 找到根结点
        while (root.next != null) {
            root = root.next;
        }
        Deque<TreeLinkNode> deque = new LinkedList<>();
        TreeLinkNode cur = root;
        boolean flag = false;
        while (cur != null || !deque.isEmpty()) {
            if (cur != null) {
                deque.push(cur);
                cur = cur.left;
            } else {
                cur = deque.pop();
                if (flag) {
                    return cur;
                }
                if (cur == pNode) {
                    flag = true;
                }
                cur = cur.right;
            }
        }
        return null;
    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}