package 剑指offer.树;

/**
 * 树中两个节点的最低公共祖先(普通二叉树)
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/68.%20树中两个节点的最低公共祖先.md
 */
public class Solution68_2 {

    /**
     * 在左右子树中查找是否存在 p 或者 q，如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 基本上有两种情况，1、p和q分别位于两个子树中 2、p和q中的其中一个当作LCA（Lowest Common Ancestor）
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

}
