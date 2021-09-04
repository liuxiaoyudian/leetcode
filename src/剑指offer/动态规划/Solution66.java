package 剑指offer.动态规划;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 66. 构建乘积数组
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/66.%20构建乘积数组.md
 * https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
 */
public class Solution66 {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = multiply1(A);
        System.out.println(Arrays.toString(B));
    }

    /**
     * 暴力法
     */
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int base = 1;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    base *= A[j];
                }
            }
            res[i] = base;
        }
        return res;
    }

    /**
     * 表格分区，双向遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int[] multiply1(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= A[i], i++) {      /* 从左往右累乘 */
            B[i] = product;
        }
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--) {  /* 从右往左累乘 */
            B[i] *= product;
        }
        return B;
    }

}
