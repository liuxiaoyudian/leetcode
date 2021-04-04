package 剑指offer.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树（层序遍历）
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/32.1%20从上往下打印二叉树.md
 */
public class Solution32_1 {

    /**
     * 利用队列实现
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) { // 层次遍历，外层的while循环，循环一次就是一层
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                ret.add(node.val);
                // 利用队列先进先出的特性，后面的先存起来
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return ret;
    }

    /**
     * 先序遍历(NLR)
     * @param root
     */
    public void pre_order(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            pre_order(root.left);
            pre_order(root.right);
        }
    }

    /**
     * 中序遍历(LNR)
     * @param root
     */
    public void in_order(TreeNode root) {
        if (root != null) {
            in_order(root.left);
            System.out.println(root.val);
            in_order(root.right);
        }
    }

    /**
     * 后序遍历(LRN)
     * @param root
     */
    public void post_order(TreeNode root) {
        if (root != null) {
            post_order(root.left);
            post_order(root.right);
            System.out.println(root.val);
        }
    }

}
