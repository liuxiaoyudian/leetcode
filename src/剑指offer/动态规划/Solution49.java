package 剑指offer.动态规划;

/**
 * 49. 丑数
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/49.%20丑数.md
 */
public class Solution49 {

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution1(1500));
    }

    /**
     * 动态规划
     * 状态转移方程：dp[i]=min(dp[i2] * 2, dp[i3] * 3, dp[i5] * 5)
     * 丑数的形式：2^x * 3^y * 5^z
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 6) { // 前6个丑数为1 2 3 4 5 6
            return index;
        }
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[index];
        dp[0] = 1; // 第一个丑数为 1
        for (int i = 1; i < index; i++) {
            dp[i] = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (dp[i] == dp[i2] * 2) { // 不能写成if-else的形式，因为可能存在v[i]*2==v[j]*3这种情况
                i2++;
            }
            if (dp[i] == dp[i3] * 3) {
                i3++;
            }
            if (dp[i] == dp[i5] * 5) {
                i5++;
            }
        }
        return dp[index - 1];
    }

    public static int GetUglyNumber_Solution1(int index) {
        int count = 0; // 存储找到的丑数的数量
        int num = 1;
        while (count < index) {
            if (judge(num)) {
                count++;
            }
            num++;
        }
        return num - 1;
    }

    // 判断是否是丑数
    public static boolean judge(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

}
