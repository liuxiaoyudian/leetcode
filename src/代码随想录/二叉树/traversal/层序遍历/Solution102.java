package 代码随想录.二叉树.traversal.层序遍历;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0102.二叉树的层序遍历.md
 */
public class Solution102 {

    /**
     * cyc的写法
     * 这两种写法是一样的没什么特别大的区别，下面一种写法执行效率会搞一丢丢
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) { // 一次循环就对应一层
            int cnt = queue.size();
            List<Integer> level = new ArrayList<>();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) { // 对应着null的情况
                    continue;
                }
                level.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (level.size() > 0) {
                list.add(level);
            }
        }
        return list;
    }

    /**
     * 代码随想录和官方的写法
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> level = new ArrayList<>();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(level);
        }
        return list;
    }

}
