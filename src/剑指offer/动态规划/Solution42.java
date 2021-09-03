package 剑指offer.动态规划;

/**
 * 42. 连续子数组的最大和
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/42.%20连续子数组的最大和.md
 */
public class Solution42 {

    /**
     * 注意体会这个思想
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : array) {
            sum = sum <= 0 ? val : sum + val; // 这一行是关键
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }

    /**
     * 动态规划
     * 状态定义：dp[i]表示以i结尾的连续子数组的最大和
     * 状态转移方程：dp[i] = max(array[i], dp[i-1]+array[i-1])
     *
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int FindGreatestSumOfSubArray1(int[] array) {
        int n = array.length;
        int[] dp = new int[n + 1];
        int max = array[0]; // 返回的结果
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(array[i - 1], dp[i - 1] + array[i - 1]);
            max = Math.max(max, dp[i]); // 注意求的是连续子数组的最大和，而不是dp[i]的最大值
        }
        return max;
    }

}
