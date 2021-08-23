package 笔试.腾讯;

import java.util.Scanner;

/**
 * 第4题
 * https://www.nowcoder.com/test/21283868/summary
 */
public class Solution1 {

    /**
     * 动态规划
     */
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // n天
//        int[] work = new int[n];
//        int[] gym = new int[n];
//        for (int i = 0; i < n; i++) {
//            work[i] = sc.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            gym[i] = sc.nextInt();
//        }

        int n = 4;
        int[] work = {1, 1, 0, 0};
        int[] gym = {0, 1, 1, 0};

        // dp[i][0] 休息
        // dp[i][1] 工作
        // dp[i][2] 锻炼
        int[][] dp = new int[n + 1][3];

        // 将二维数组初始化成每天都休息的情况（其实就是对不可以工作，锻炼情况下的处理）
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = i;
            }
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + 1; // 休息
            if (work[i - 1] == 1) { // 可以工作
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
            }
            if (gym[i - 1] == 1) { // 可以锻炼
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        int min = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));

        System.out.println(min);

    }

}
