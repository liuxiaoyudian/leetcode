package 剑指offer.树;

import java.util.Arrays;

/**
 * 7. 重建二叉树
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/7.%20重建二叉树.md
 */
public class Solution7 {

    /**
     * 递归
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        int n = pre.length;
        if (n == 0) { // 注意递归结束的条件
            return null;
        }
        if (n == 1) {
            return new TreeNode(pre[0]);
        }
        // 根据前序遍历的性质，第一个元素必然就是root
        TreeNode root = new TreeNode(pre[0]);
        //  找root所在的位置
        int index = 0;
        while (index < n && vin[index] != pre[0]) {
            index++;
        }
        // Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(vin, 0, index));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, n), Arrays.copyOfRange(vin, index + 1, n));
        return root;
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this. val = val;
    }
}