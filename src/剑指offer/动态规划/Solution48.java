package 剑指offer.动态规划;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 48. 最长不含重复字符的子字符串
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/48.%20最长不含重复字符的子字符串.md
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/submissions/
 */
public class Solution48 {

    public static void main(String[] args) {
    }

    /**
     * 滑动窗口
     *
     * 时间复杂度：O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, max = 0;
        while (j < s.length()) {
            if (!set.contains(cs[j])) {
                set.add(cs[j++]);
                max = Math.max(max, set.size());
            } else {
                // 进入这个else循环就说明cs[j]已经和set集合中的某个元素冲突了，那么就从i开始一直移除set中的元素，直到不冲突为止
                while (cs[i] != cs[j]) {
                    set.remove(cs[i++]);
                }
                set.remove(cs[i++]);
                set.add(cs[j++]);
            }

        }
        return max;
    }

    /**
     * 动态规划
     *
     * 结合例子abbcdb来理解
     */
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>(); // {char, index}
        int res = 0, tmp = 0; // tmp就记录着遍历过程中各个阶段的长度
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j),  -1);
            map.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }

}
