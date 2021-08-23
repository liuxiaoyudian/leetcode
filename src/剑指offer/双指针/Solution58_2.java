package 剑指offer.双指针;

/**
 * 58.2 左旋转字符串
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/58.2%20左旋转字符串.md
 */
public class Solution58_2 {

    /**
     * 教训：1、需要考虑特殊情况的处理，如字符串为空或者为null的情况
     *      2、对于需要实现字符串交换的题，要想到能不能利用翻转字符串做到
     * 解题思路：
     * 先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
     */
    public String LeftRotateString(String str, int n) {
        if (str.length() == 0) { // 不要漏掉这一步！
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, str.length() - 1);
        reverse(chars, 0, str.length() - 1);
        return new String(chars);
    }

    public void reverse(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
    }

}
