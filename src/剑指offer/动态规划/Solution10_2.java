package 剑指offer.动态规划;

/**
 * 10.2 矩形覆盖
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/10.2%20矩形覆盖.md
 */
public class Solution10_2 {

    public int rectCover(int target) {
        if (target < 3) {
            return target;
        }
        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
