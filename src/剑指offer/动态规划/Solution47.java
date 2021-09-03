package 剑指offer.动态规划;

/**
 * 47. 礼物的最大价值
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/47.%20礼物的最大价值.md
 */
public class Solution47 {

    /**
     * 动态规划
     * 当前点的最大总价值 = max(上面点最大总价值，左边点的最大总价值) + 当前点价值
     * (0, 0)点以及第一行和第一列要先初始化一波
     */
    public int getMost(int[][] board) {
        int[][] dp = new int[6][6];
        dp[0][0] = board[0][0]; // 注意这个初始化的方法
        for (int j = 1; j < 6; j++) {
            dp[0][j] = dp[0][j - 1] + board[0][j];
        }
        for (int i = 1; i < 6; i++) {
            dp[i][0] = dp[i - 1][0] + board[i][0];
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + board[i][j];
            }
        }
        return dp[5][5];
    }

}
