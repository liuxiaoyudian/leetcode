package leetcode.动态规划.中等;

import java.util.Arrays;

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class Solution191 {


    /**
     * 题解：【宫水三叶】根据数据范围切换「递归」与「递推」
     */
    public int numDecodings(String s) {
        int n = s.length();
        s = " " + s; // 追加空格可以使得下标从1开始，并且可以避免讨论前导0
        char[] cs = s.toCharArray();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            // a : 代表「当前位置」单独形成 item
            // b : 代表「当前位置」与「前一位置」共同形成 item
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            // 如果 a 属于有效值，那么 f[i] 可以由 f[i - 1] 转移过来
            if (1 <= a && a <= 9) f[i] = f[i - 1];
            // 如果 b 属于有效值，那么 f[i] 可以由 f[i - 2] 或者 f[i - 1] & f[i - 2] 转移过来
            if (10 <= b && b <= 26) f[i] += f[i - 2];
        }
        return f[n];
    }


}
