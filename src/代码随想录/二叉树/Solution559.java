package 代码随想录.二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 559. N 叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0104.二叉树的最大深度.md
 */
public class Solution559 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0; // 初始值必须为0，children可能是空的
        for (Node node : root.children) {
            max = Math.max(maxDepth(node), max);
        }
        return max + 1;
    }

    /**
     * 另外一种等价写法，利用Collections.max求集合的最大值
     */
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        for (Node node : root.children) {
            list.add(maxDepth(node));
        }
        return Collections.max(list) + 1;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
