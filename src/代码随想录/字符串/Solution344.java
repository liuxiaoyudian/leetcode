package 代码随想录.字符串;

/**
 * 344. 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0344.反转字符串.md
 */
public class Solution344 {

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            // 通过异或操作完成swap
//            s[i] ^= s[j]; // 构造 a ^ b 的结果，并放在 a 中
//            s[j] ^= s[i]; // 将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
//            s[i] ^= s[j]; // a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

}
