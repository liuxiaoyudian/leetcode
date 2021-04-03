package 剑指offer.树;

/**
 * 二叉树的镜像
 * https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=13&tqId=11171&tab=answerKey&from=cyc_github
 */
public class Solution27 {

    public TreeNode Mirror (TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        swap(pRoot);
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }

    public void swap(TreeNode pRoot) {
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
    }

}
