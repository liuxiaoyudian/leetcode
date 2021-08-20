package 代码随想录.二叉树;

import 代码随想录.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0111.二叉树的最小深度.md
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量，注意是叶子节点！！！
 */
public class Solution111 {

    /**
     * 迭代法，注意体会这个思想
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (root.left == null) { // 当一个左子树为空，右不为空，这时并不是最低点，看代码随想录的图
            return r + 1;
        }
        if (root.right == null) { // 当一个右子树为空，左不为空，这时并不是最低点
            return l + 1;
        }
        return Math.min(l, r) + 1; // 左右结点都不为null
    }

    /**
     * 迭代法
     */
    public int minDepth1(TreeNode root) {
        if (root == null) { // 注意这个条件在这个题里面是不能少的
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.left == null && node.right == null) { // 如果到达最后一层会直接返回了，null不可能被加到queue中
                    return depth;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            depth++; // 这里就不用考虑到最后一层的情况
        }
        return depth;
    }

}


