package 剑指offer.树;

/**
 * 树的子结构
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/26.%20树的子结构.md
 *
 *
 */
public class Solution26 {

    /**
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtreeWithRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        // 因为求的是子结构，root2只需要是root1的一部分即可
        // 具体可以参考这个博客（https://www.cnblogs.com/heyonggang/archive/2013/11/03/3405482.html）里的图
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }

}
