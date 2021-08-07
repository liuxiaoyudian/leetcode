package 代码随想录.二叉树.traversal;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/二叉树的递归遍历.md
 */
public class Solution144 {

    /**
     * 递归
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

}
