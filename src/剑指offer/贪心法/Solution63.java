package 剑指offer.贪心法;

public class Solution63 {

    public static void main(String[] args) {
//        int[] arr = {7, 1, 5, 3, 6, 4};
//        System.out.println(maxProfit(arr));
    }

    /**
     * 暴力法
     * @param prices
     * @return
     */
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    /**
     * 更优的解法，时间复杂度O(n)
     * @param prices
     * @return
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
