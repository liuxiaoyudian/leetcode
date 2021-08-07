package 代码随想录.二叉树.traversal;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/二叉树的递归遍历.md
 */
public class Solution94 {

    /**
     * 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inoder(root, list);
        return list;
    }

    public void inoder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inoder(root.left, list);
        list.add(root.val);
        inoder(root.right, list);
    }

}
