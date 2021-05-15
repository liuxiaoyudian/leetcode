package 剑指offer.排序;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/45.%20把数组排成最小的数.md
 */
public class Solution45 {

    public static void main(String[] args) {
        int[] a = {3, 32, 321};
        System.out.println(PrintMinNumber(a));
    }

    /**
     * 解题思路：
     * 可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，
     * 应该比较的是 S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int n = numbers.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++)
            strs[i] = numbers[i] + "";
        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String ret = "";
        for (String str : strs) {
            ret += str;
        }
        return ret;
    }


}
