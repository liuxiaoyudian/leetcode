package leetcode.困难;

/**
 * 面试题 17.24. 最大子矩阵
 * https://leetcode-cn.com/problems/max-submatrix-lcci/
 *
 */
public class 最大子矩阵 {

    /**
     * 动态规划
     *
     * 主要思路：将二维矩阵压成一维，然后按照 53. 最大子序和 的思路写
     */
    public int[] getMaxMatrix(int[][] matrix) {
        int[] ans = new int[4]; // 保存最大子矩阵的左上角和右下角的行列坐标
        int n = matrix.length;
        int m = matrix[0].length;
        int[] b = new int[m]; // 记录当前i~j行组成大矩阵的每一列的和，将二维转化为一维
        int sum = 0; // 相当于dp[i]
        int maxSum = Integer.MIN_VALUE; // 记录最大值
        int r1 = 0, c1 = 0; // //记录左上角

        for (int i = 0; i < n; i++) { // 子矩阵的上边，从上而下扫描
            for (int t = 0; t < m; t++) { // 每次更换子矩形上边，就要清空b，重新计算每列的和
                b[t] = 0;
            }
            for (int j = i; j < n; j++) { // 子矩阵的下边，从i到N-1，不断增加子矩阵的高
                // 以下就相当于求一次最大子序列和（简单.Solution53）
                sum = 0; // 从头开始求dp
                for (int k = 0; k < m; k++) {
                    b[k] += matrix[j][k];
                    if (sum > 0) {
                        sum += b[k];
                    } else {
                        sum = b[k];
                        r1 = i; // 保存其左上角
                        c1 = k;
                    }
                    if (sum > maxSum) {
                        maxSum = sum;
                        ans[0] = r1;
                        ans[1] = c1;
                        ans[2] = j;
                        ans[3] = k;
                    }

                }
            }
        }


        return ans;
    }

}
