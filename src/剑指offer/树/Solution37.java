package 剑指offer.树;

/**
 *  序列化二叉树
 *  https://github.com/CyC2018/CS-Notes/blob/master/notes/37.%20序列化二叉树.md
 *  本来从先序遍历不能反推出二叉树，但是如果加了一些限定条件，即null用#来表示，就可以反推出二叉树
 */
public class Solution37 {

    String s;

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        // 先序遍历
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        s = str;
        return Deserialize();
    }

    /**
     * 递归
     * @return
     */
    TreeNode Deserialize() {
        int index = s.indexOf(" ");
        String val = index == -1 ? s : s.substring(0, index);
        s = index == -1 ? "" : s.substring(index + 1);
        if (val == "#") {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = Deserialize();
        root.right = Deserialize();
        return root;
    }

}
