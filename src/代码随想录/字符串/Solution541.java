package 代码随想录.字符串;

/**
 * 541. 反转字符串 II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0541.反转字符串II.md
 */
public class Solution541 {

    /**
     * 直接进行模拟
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i =  0; i < n / (2 * k); i++) {
            swap(chars, i * 2 * k, i * 2 * k + k - 1);
        }
        int num = n % (2 * k);
        if (num > 0 && num < k) {  // 如果剩余字符少于 k 个，则将剩余字符全部反转
            swap(chars, n - num, n - 1);
        }
        if (num >= k && num < 2 * k) { // 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
            swap(chars, n - num , n - num + k - 1);
        }
        return new String(chars);
    }

    public void swap(char[] s, int l, int r) {
        while (l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }
    }

    /**
     * 更方便的一种写法
     */
    public String reverseStr1(String s, int k) {
        char[] chars = s.toCharArray();
        for (int start = 0; start < chars.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, chars.length - 1); // 关键点在于这个Math.min
            while (i < j) {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
        }
        return new String(chars);
    }

}
