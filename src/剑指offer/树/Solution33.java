package 剑指offer.树;

/**
 * 二叉搜索树的后序遍历序列
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/33.%20二叉搜索树的后序遍历序列.md
 *
 * 二叉搜索树BST后序遍历的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，那么T满足：
 * T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。
 */
public class Solution33 {

    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        System.out.println(VerifySquenceOfBST(sequence));
    }

    /**
     * 当需要利用递归来解决问题时，如果给定方法的参数不方便自己使用递归（也就是说想要更改方法参数的时候），就可以写一个新的方法。
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    /**
     *
     * @param sequence
     * @param start 左闭
     * @param end 右闭
     * @return
     */
    private static boolean verify(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int rootVal = sequence[end];
        // index对应的是右子树的第一个值
        int index = start;
        // 注意！！！下面for循环这种写法会有问题，如果输入为{1, 2, 3, 4, 5}的时候就会出问题
        while (index < end && sequence[index] < rootVal) {
            index++;
        }
//        for (int i = start; i < end; i++) {
//            if (sequence[i] > rootVal) {
//                index = i;
//                break;
//            }
//        }
        for (int i = index; i < end; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return verify(sequence, start, index - 1) && verify(sequence, index, end - 1);
    }

}
