package 剑指offer.树;

/**
 * 二叉查找树的第 K 个结点
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/54.%20二叉查找树的第%20K%20个结点.md
 *
 * 二叉查找树（二叉搜索树 | 二叉排序树）
 * 定义：（注意空树也是二叉查找树！）
 * （1）若左子树不空，则左子树上所有结点的值均小于它的根结点的值；（也可以是小于等于）
 * （2）若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；（注意这里是>=，如果能确保没有键值想等的点，就可以变成>）
 * （3）左、右子树也分别为二叉排序树；
 *
 * 思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序，按照中序遍历顺序找到第k个结点就是结果。
 */
public class Solution54 {

    int index = 0;

    /**
     * 这个对中序遍历进行了一点点改进，只有找到了才会返回node，不然只会返回null
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }

        TreeNode node = KthNode(pRoot.left, k);
        if (node != null) {
            return node;
        }
        index++;
        if (index == k) {
            return pRoot;
        }
        return KthNode(pRoot.right, k);

    }

}
