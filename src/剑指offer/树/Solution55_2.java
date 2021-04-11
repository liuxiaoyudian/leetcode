package 剑指offer.树;

/**
 * 平衡二叉树
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/55.2%20平衡二叉树.md
 *
 * 被考过，原题！！！
 *
 * 平衡二叉树左右子树高度差不超过 1。
 */
public class Solution55_2 {

    boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        Height(root);
        return isBalanced;
    }

    public int Height(TreeNode root) {
        if (root == null || !isBalanced) { // !isBalanced的目的是为了让递归尽早的结束
            return 0;
        }
        int left = Height(root.left);
        int right = Height(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }

}
