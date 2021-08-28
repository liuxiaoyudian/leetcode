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
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0) { // 注意递归结束的条件
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        // 根据前序遍历的性质，第一个元素必然就是root
        TreeNode root = new TreeNode(pre[0]);
        //  找root所在的位置
        int rootIndex = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                rootIndex = i;
                break;
            }
        }
        // Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1), Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length), Arrays.copyOfRange(in, rootIndex + 1, in.length));
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