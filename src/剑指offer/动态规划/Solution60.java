package 剑指offer.动态规划;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 60. n 个骰子的点数
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/60.%20n%20个骰子的点数.md
 */
public class Solution60 {

    /**
     * 动态规划
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[n + 1][pointNum + 1];

        for (int i = 1; i <= face; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= pointNum; j++) { // 使用 i 个骰子最小点数为 i
                for (int k = 1; k <= face && k <= j; k++) { // 只考虑最后一个骰子是几
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++) {
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
        }

        return ret;
    }

}
