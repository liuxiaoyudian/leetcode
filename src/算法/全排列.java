package 算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://blog.csdn.net/u013309870/article/details/68941284
 * https://www.programcreek.com/2013/02/leetcode-permutations-java/
 */
public class 全排列 {

    public static void main(String[] args) {
        char[] chs = {'1', '2', '3', '4'};
//        char[] chs = {'a', 'b', 'c', 'd'};
//        Permutation(chs, 0);
        List<List<Character>> list = Permutation(chs);
        list.stream().forEach(System.out::println);
//        PermutationWithDictionary(chs);
    }

    /**
     * 1、递归法（结果直接输出）
     */
    public static void Permutation(char[] chs, int start) {
        if (start == chs.length - 1) {
            System.out.println(Arrays.toString(chs));
            return; // 这里需要加一个return，不然会多几次没用的递归
        }
        for (int i = start; i < chs.length; i++) {
            // 注意：这个方法会对重复元素进行交换，比如使用递归对{1，1}进行全排序会输出：{1，1}，{1，1}两个重复的结果。
            if (i == start || chs[start] != chs[i]) { // 加上这个if语句，就可以去重
                swap(chs, start, i);  // 把第一个元素分别与后面的元素进行交换，递归的调用其子数组进行排序
                Permutation(chs, start + 1);
                swap(chs, start, i); // 子数组排序返回后要将第一个元素交换回来
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    /**
     * 1、递归法（结果存储下来）
     */
    public static List<List<Character>> Permutation(char[] chs) {
        List<List<Character>> list = new ArrayList<>();
        helper(chs, 0, list);
        return list;
    }

    public static void helper(char[] chs, int start, List<List<Character>> list) {
        if (start == chs.length - 1) {
            List<Character> l = new ArrayList<>();
            for (char c : chs) {
                l.add(c);
            }
            list.add(l);
            return;
        }
        for (int i = start; i < chs.length; i++) {
            if (i == start || chs[start] != chs[i]) {
                swap(chs, start, i);
                helper(chs, start + 1, list);
                swap(chs, start, i);
            }
        }
    }


    /**
     * 字典排序法
     * 思想：
     * 每次找到当前排列的最后一对正序对AB（位置为i，i+1），再从尾向前找到第一个大于A的字符C，将AC交换位置，此时再将i后面的整个子串倒序接在i的后面，得到的就是下一次字典序排列的字符串。
     * 例如：12354->12453->12435, 可以看出12435是按字典序紧挨在12354后的排列
     * <p>
     * 具体步骤
     * 1、从右向左找到第一个非递增的数
     * 2、从右向左找到第一个比非递增元素大的元素
     * 3、交换找到的两个元素
     * 4、对第一个非递增元素位置后面的数组进行逆序排列
     */
    public static void PermutationWithDictionary(char chs[]) {
        // 先对数组的元素进行依次排序
        Arrays.sort(chs);
        while (true) {
            System.out.println(chs);
            for (int j = chs.length - 2; j >= 0; j--) {
                if (chs[j] < chs[j + 1]) {  // 从右向左找到第一个非递增的元素
                    for (int k = chs.length - 1; k >= 0; k--) {
                        if (chs[k] > chs[j]) {  // 从右向左找到第一个比非递增元素大的元素
                            swap(chs, j, k);  // 交换找到的两个元素
                            reverse(chs, j + 1);  // 对第一个非递增元素位置后面的数组进行逆序排列
                            break;
                        }
                    }
                    break;
                } else if (j == 0) {  // 如果遍布整个字符串都找不到非递增元素就说明算法结束了
                    return;
                }
            }
        }
    }

    public static void reverse(char chs[], int start) {
        int end = chs.length - 1;
        while (start < end) {
            swap(chs, start, end);
            start++;
            end--;
        }
    }

}
