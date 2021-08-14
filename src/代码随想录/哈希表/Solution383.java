package 代码随想录.哈希表;

/**
 * 383. 赎金信
 * https://leetcode-cn.com/problems/ransom-note/submissions/
 *
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0383.赎金信.md
 */
public class Solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] records = new int[26];
        for (char c : magazine.toCharArray()) {
            records[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            records[c - 'a']--;
            if (records[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
