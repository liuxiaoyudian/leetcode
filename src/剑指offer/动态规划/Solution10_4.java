package 剑指offer.动态规划;

/**
 * 10.4 变态跳台阶
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/10.4%20变态跳台阶.md
 */
public class Solution10_4 {

    /**
     * 动态规划
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public int jumpFloorII(int target) {
        if (target < 2) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }

    /**
     * 公式推导可以得出 f(n) = 2 * f(n-1)，即等比数列
     */
    public int jumpFloorII1(int target) {
        return (int) Math.pow(2, target - 1);
    }

}
