package leetcode.简单;

import java.util.Scanner;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/submissions/
 */
public class Solution53 {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        String[] array = new String[T];
//        sc.nextLine();
//        for (int i = 0; i < T; i++) {
//            array[i] = sc.nextLine();
//        }
//
//        for (int i = 0; i < T; i++) {
//            String[] split = array[i].split("\\s+");
//            int n = split.length;
//            int[] nums = new int[n];
//            for (int j = 0; j < n; j++) {
//                nums[j] = Integer.valueOf(split[j]);
//            }
//
//            int sum = nums[0];
//            int maxSum = Integer.MIN_VALUE;
//            int start = 0;
//            int end = 0;
//            for (int j = 0; j < n; j++) {
//                if (sum > 0) {
//                    sum += nums[j];
//                } else {
//                    start = j;
//                    sum = nums[j];
//                }
//                if (sum > maxSum) {
//                    maxSum = sum;
//                    end = j;
//                }
//            }
//            System.out.println(start);
//            System.out.println(end);
//
//            break;
//        }
//    }

    /**
     * 暴力法
     * 时间复杂度：O(n^2)
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i; j < n; j++) {
                temp += nums[j];
                res = Math.max(res, temp);
            }
        }
        return res;
    }

    /**
     * 动态规划
     * 状态定义：dp[i]为以nums[i]结尾的最大子序和
     * 状态转移方程：dp[i]=max( dp[i-1] + nums[i] , nums[i] ) 注意：题目要求是连续的，所以状态转移方程只能这么些
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]); // dp[i - 1]并不一定是最大值
        }
        return max;
    }

    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x); // 如果前边累加后还不如自己本身大，那就把前边的都扔掉，从此自己本身重新开始累加
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
