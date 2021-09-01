package 剑指offer.贪心法;

/**
 * 121. 买卖股票的最佳时机
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/63.%20股票的最大利润.md
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution63 {

    /**
     * 暴力法（超时）
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for (int i = 0; i < n - 1; i++) {
            int max = prices[i + 1];
            for (int j = i + 2; j < n; j++) {
                max = Math.max(max, prices[j]);
            }
            profit = Math.max(profit, max - prices[i]);
        }
        return profit;
    }

    /**
     * 更优的解法，时间复杂度O(n)
     */
    public int maxProfit1(int prices[]) {
        int maxProfit = 0;
        int soFarMin = prices[0];
        for (int i : prices) {
            soFarMin = Math.min(soFarMin, i);
            maxProfit = Math.max(maxProfit, i - soFarMin);
        }
        return maxProfit;
    }
}
