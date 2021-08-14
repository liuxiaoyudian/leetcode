package 代码随想录.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * https://leetcode-cn.com/problems/4sum-ii/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0454.四数相加II.md
 */
public class Solution454 {

    /**
     *  仔细理解一下这个题的解题方法
     *  注意：这里要求的是四元组，所以就没有了重复的问题！
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        int res = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                if (map.containsKey(-i - j)) {
                    res += map.get(-i - j);
                }
            }
        }
        return res;
    }

}
