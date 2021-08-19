package 代码随想录.字符串;

import java.util.Arrays;

/**
 * 459. 重复的子字符串
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0459.重复的子字符串.md
 */
public class Solution459 {

    public static void main(String[] args) {
        String s = "abcdddabc";
        int n = s.length();
        int[] next = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        System.err.println(Arrays.toString(next));

        System.out.println(next[n - 1] != 0 && n % (n - next[n - 1]) == 0);
    }

    /**
     * 暴力法（自己实现）
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) { // 代表字串的长度
            if (n % i == 0 && n / i >= 2) { // 条件：s的长度是子串长度的整数倍（至少2倍以上）
                int k = 0; // 子串的下标
                int j;
                for (j = i; j < n; j++) {
                    if (s.charAt(k++) != s.charAt(j)) {
                        break;
                    }
                    if (k == i) {
                        k = 0;
                    }
                }
                if (j == n) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 利用KMP算法的next数组
     * 数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，也就是一个周期的长度，
     * 如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
     */
    public boolean repeatedSubstringPattern1(String s) {
        int n = s.length();
        int[] next = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        // next[n - 1] != 0 说明该字符串有最长相同的前后戳
        // n % (n - next[n - 1])
        return next[n - 1] != 0 && n % (n - next[n - 1]) == 0;
    }

}
