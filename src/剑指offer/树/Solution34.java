package 剑指offer.树;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/34.%20二叉树中和为某一值的路径.md
 */
public class Solution34 {

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    /**
     * 碰到这种需要递归解决，但是又不需要有返回值的情况，可以尝试将逻辑写在一个新的方法里（两者的逻辑也可以合在一起，但是需要在类成员变量里再声明一个list）。
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    /**
     * @param root
     * @param target
     * @param path 理解这个path是这个递归思想的关键所在
     */
    private void backtracking(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null) {
            return ;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            // 注意为什么这里是new了一个List对象，因为后续还会对path对象进行改动。
            ret.add(new ArrayList<>(path));
        } else {
            backtracking(root.left, target, path);
            backtracking(root.right, target, path);
        }
        // 这个递归方法的另外一个关键点！！！
        path.remove(path.size() - 1);
    }

}
