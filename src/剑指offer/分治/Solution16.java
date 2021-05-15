package 剑指offer.分治;

/**
 * 数值的整数次方
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/16.%20数值的整数次方.md
 */
public class Solution16 {

    public static void main(String[] args) {
        System.out.println(Power(2, -2));
    }

    /**
     * 分治法，时间复杂度O(logN)
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double res = pow(base, exponent);
        return isNegative ? 1 / res : res;
    }

    private static double pow(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double res = pow(base, exponent / 2);
        res = res * res;
        if (exponent % 2 != 0) {
            res *= base;
        }
        return res;
    }

    /**
     * 简单暴力的for循环，时间复杂度O(N)
     * @param base
     * @param exponent
     * @return
     */
    public static double Power1(double base, int exponent) {
        double res = 1;
        if (exponent == 0) {
            res = 1;
        }
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                res *= base;
            }
        }
        if (exponent < 0) {
            for (int i = 0; i < -exponent; i++) {
                res /= base;
            }
        }
        return res;
    }
}
