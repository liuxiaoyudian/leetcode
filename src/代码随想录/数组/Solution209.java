package 代码随想录.数组;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0059.螺旋矩阵II.md
 */
public class Solution209 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen1(7, nums));
    }

    /**
     * 暴力法
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) { // 注意题目里的条件是>=
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 滑动窗口（双指针）
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        int i = 0, j = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) { // 注意这个while，窗口的左边界可能会连续移动多次
                min = Math.min(min, j - i + 1);
                sum -= nums[i++];
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
