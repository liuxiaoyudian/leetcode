package 剑指offer.双指针;

public class Solution58_2 {

    /**
     * 教训：1、需要考虑特殊情况的处理，如字符串为空或者为null的情况
     *      2、对于需要实现字符串交换的题，要想到能不能利用翻转字符串做到！！
     * 解题思路：
     * 先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str, int n) {
        if (str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, str.length() - 1);
        reverse(chars, 0, str.length() - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            swap(c, i++, j--);
        }
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

}
