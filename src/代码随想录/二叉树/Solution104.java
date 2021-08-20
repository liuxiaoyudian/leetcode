package 代码随想录.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0104.二叉树的最大深度.md
 */
public class Solution104 {

    /**
     * 递归的思想（不要拘泥于先序遍历的代码形式）
     */
    public int maxDepth(TreeNode root) {
        if (root == null) { // 递归的结束条件
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }

    /**
     * 迭代
     * 层序遍历
     */
    public int maxDepth1(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                // 因为这里没有碰断是否为空，即没有用list存起来，所以在遍历到最后一层的时候queue里都是null，所以返回depth的时候要减1
                queue.offer(node.left);
                queue.offer(node.right);
            }
            depth++;
        }
        return depth - 1;
    }

    /**
     * 利用先序遍历（自己实现的）
     */
    public int maxDepth2(TreeNode root) {
        return preorder(root, 0);
    }

    public int preorder(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        int l = preorder(root.left, depth);
        int r = preorder(root.right, depth);
        return depth > l ? depth > r ? depth : r : l > r ? l : r; // 返回最大值
    }

}
