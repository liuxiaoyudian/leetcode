package 剑指offer.树;

/**
 * 对称的二叉树
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/28.%20对称的二叉树.md
 */
public class Solution28 {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            // 树为空也是对称的
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        // 仔细体会下这段代码
        // 例子，层序遍历：{8,6,6,5,7,7,5,1,2,3,4,4,3,2,1}
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
    }

}
