package 剑指offer.树;

/**
 * 二叉树的深度
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/55.1%20二叉树的深度.md
 *
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution55_1 {

    /**
     * 体会一下递归的思想！！！
     * 一行解决问题！
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    int max = 1;

    /**
     * 自己的笨方法
     * @param root
     * @return
     */
    public int TreeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth(root, 1);
        return max;
    }

    public void depth(TreeNode node, int depth) {
        if (depth > max) {
            max = depth;
        }
        if (node.left != null) {
            depth(node.left, depth + 1);
        }
        if (node.right != null) {
            depth(node.right, depth + 1);
        }
    }

}
