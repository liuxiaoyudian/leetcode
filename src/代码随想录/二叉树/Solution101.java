package 代码随想录.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0101.对称二叉树.md
 */
public class Solution101 {

    /**
     * 递归实现
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    /**
     * 考虑四种情况，左右子树都空为true，左右子树有一个不空一个空为false，左右子树都不空，值相等就true，否则false
     */
    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    /**
     * 迭代法
     * 使用队列
     * 把递归程序改写成迭代程序的常用方法:引入队列
     */
    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if ((left == null || right == null) || (left.val != right.val)) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    /**
     * 先层序遍历，然后利用双指针法判断每一层是否对称
     */
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) { // 层序遍历
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    list.add(null);
                    continue;
                }
                list.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            int i = 0, j = list.size() - 1; // 判断是否对称
            while (i < j) {
                if (list.get(i) != list.get(j)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

}
