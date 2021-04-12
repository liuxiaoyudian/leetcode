package 剑指offer.树;

/**
 * 树中两个节点的最低公共祖先(二叉查找树BST)
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/68.%20树中两个节点的最低公共祖先.md
 */
public class Solution68_1 {

    /**
     * 自己的实现方法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val <= root.val && q.val >= root.val || p.val >= root.val && q.val <= root.val) {
            return root;
        }
        TreeNode node = lowestCommonAncestor(root.left, p, q);
        if (node != null) return node;
        return lowestCommonAncestor(root.right, p, q);
    }

    /**
     * 更简洁的一种实现方法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) { // p和q都在root的左边
            return lowestCommonAncestor1(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) { // p和q都在root的右边
            return lowestCommonAncestor1(root.right, p, q);
        }
        return root;
    }

}
