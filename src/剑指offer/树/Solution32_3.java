package 剑指offer.树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按之字形顺序打印二叉树
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/32.3%20按之字形顺序打印二叉树.md
 */
public class Solution32_3 {

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0) {
                if (reverse) {
                    Collections.reverse(list);
                }
                ret.add(list);
            }
            reverse = !reverse;
        }
        return ret;
    }

}
