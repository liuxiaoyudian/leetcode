package leetcode.简单;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * https://mp.weixin.qq.com/s?__biz=MzUxNjY5NTYxNA==&mid=2247484214&idx=1&sn=0dc1cba149de626db52189c684f353e5&scene=21#wechat_redirect
 */
public class Solution1 {

    /**
     * 暴力解法
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    /**
     * 使用哈希表
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // {value:index}
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) { // containsKey是O(1)
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
