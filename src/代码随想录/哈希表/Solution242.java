package 代码随想录.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0242.有效的字母异位词.md
 */
public class Solution242 {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map1.get(c) == null) {
                map1.put(c, 1);
            } else {
                map1.put(c, map1.get(c) + 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (map2.get(c) == null) {
                map2.put(c, 1);
            } else {
                map2.put(c, map2.get(c) + 1);
            }
        }
        return map1.equals(map2);
    }

    /**
     * 更优的方法：可以拿数组当哈希表来用，但哈希值不要太大
     */
    public boolean isAnagram1(String s, String t) {
        // 这道题目中字符串只有小写字符，那么就可以定义一个数组，来记录字符串s里字符出现的次数
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a']--;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
