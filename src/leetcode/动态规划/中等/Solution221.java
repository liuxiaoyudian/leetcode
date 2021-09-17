package leetcode.动态规划.中等;

/**
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class Solution221 {

    /**
     * 暴力法
     *
     * 由于正方形的面积等于边长的平方，因此要找到最大正方形的面积，首先需要找到最大正方形的边长，然后计算最大边长的平方即可。
     * 暴力法是最简单直观的做法，具体做法如下：
     * 遍历矩阵中的每个元素，每次遇到1，则将该元素作为正方形的左上角；
     * 确定正方形的左上角后，根据左上角所在的行和列计算可能的最大正方形的边长（正方形的范围不能超出矩阵的行数和列数），在该边长范围内寻找只包含1 的最大正方形；
     * 每次在下方新增一行以及在右方新增一列，判断新增的行和列是否满足所有元素都是1。
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') { // 遇到一个 1 作为正方形的左上角
                    maxSide = Math.max(maxSide, 1); // 一旦能进入这个if语句，就说明maxSide至少为1了
                    int currentMaxSide = Math.min(rows - i, columns - j); // 计算可能的最大正方形边长
                    for (int k = 1; k < currentMaxSide; k++) {
                        boolean flag = true; // 判断新增的一行一列是否均为 1
                        for (int m = 0; m <= k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1); // 注意是k+1
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }


    /**
     * 动态规划
     * dp[i][j]表示以(i,j)为右下角，且只包含1的正方形的边长最大值
     * 递推公式：
     * dp[i][j] = 0, if matrix[i][j] = 0
     * dp[i][j] = min(dp[i−1][j], dp[i−1][j−1], dp[i][j−1]) + 1, if matrix[i][j] = 1
     * 时间复杂度：O(nm)
     * 空间复杂度；O(nm)
     */
    public int maximalSquare1(char[][] matrix) {
        int maxSide = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

}
