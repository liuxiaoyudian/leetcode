package 剑指offer.动态规划;

/**
 * 10.1 斐波那契数列
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/10.1%20斐波那契数列.md
 */
public class Solution10_1 {

    /**
     * 递归
     * 时间复杂度：O(2^n)
     */
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n - 2);
    }

    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int Fibonacci1(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 在动态规划的基础上继续进行优化
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int Fibonacci2(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1, c = 0; // c的初始值是什么不重要
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
