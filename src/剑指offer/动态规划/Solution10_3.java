package 剑指offer.动态规划;

/**
 * 10.3 跳台阶
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/10.3%20跳台阶.md
 */
public class Solution10_3 {

    /**
     * 动态规划
     */
    public int jumpFloor(int target) {
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

    /**
     * 递归
     */
    public int jumpFloor1(int target) {
        if (target < 3) {
            return target;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

}
