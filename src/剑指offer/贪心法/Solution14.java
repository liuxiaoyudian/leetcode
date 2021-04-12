package 剑指offer.贪心法;

/**
 * 剪绳子
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/14.%20剪绳子.md
 */
public class Solution14 {

    /**
     * 思路：尽可能得多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。
     * 如果出现了，就从已经切好长度为 3 的绳子中拿出一段与长度为 1 的绳子重新组合，把它们切成两段长度为 2 的绳子。
     *
     * @param n
     * @return
     */
    public int cutRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            return 4 * (int) Math.pow(3, n / 3 - 1);
        } else {
            return 2 * (int) Math.pow(3, n / 3);
        }
    }

    public static void main(String[] args) {
        System.err.println(cutRope1(8));
    }

    /**
     * 划分型动态规划
     * 考虑到必然有一个点把绳子分成两份，两份各自分割得出的乘积最大值，组成整条绳子乘积的最大值。因此存在最小子问题。
     * <p>
     * 即必然有一个点，把target分成两段，两段分别构成最小子问题。两段的最大值的乘积，也是target所求的最大值。
     * 设划分点为i，f[i]表示长度为i的绳子的乘积最大值。
     * <p>
     * 当n=8时，dp = {0 1 1 2 4 6 9 12 18}
     *
     * @param n
     * @return
     */
    public static int cutRope1(int n) {
        int[] f = new int[n + 1];
        f[1] = 1; // 不使用f[0]
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) { // j就是要找的划分点，所以j的范围是0 < j < i
                f[i] = Math.max(f[i], Math.max(j * (i - j), f[j] * (i - j)));
            }
        }
        return f[n];
    }

}
