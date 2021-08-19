package 代码随想录.字符串;

/**
 * 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0028.实现strStr.md
 */
public class Solution28 {

    /**
     * 暴力法
     * 时间复杂度：O(N * M)
     * 空间复杂度：O(1)
     */
    public int strStr1(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    /**
     * KMP
     * 最长公共前后缀（前戳表中存的就是 - 最长相等前后缀）
     * 前缀是指不包含最后一个字符的所有以第一个字符开头的连续子串
     * 后缀是指不包含第一个字符的所有以最后一个字符结尾的连续子串
     *
     * 时间复杂度：O(N + M)
     * 空间复杂度：O(M)
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }

        // 求next数组
        int[] next = new int[m];
        // i是后戳末尾
        // j是前戳末尾
        for (int i = 1, j = 0; i < m; i++) { // i是从1开始的
            // 注意这里是个while循环
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) { // 前后戳不相同的情况
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) { // 前后戳相同的情况
                j++;
            }
            next[i] = j;
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }


}
