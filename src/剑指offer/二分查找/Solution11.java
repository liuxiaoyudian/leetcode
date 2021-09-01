package 剑指offer.二分查找;

/**
 * 旋转数组的最小数字
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/11.%20旋转数组的最小数字.md
 */
public class Solution11 {

    /**
     * 暴力法
     * 直接遍历一遍数组，即可找到最小值。但是本题的附加条件就没有用上。肯定不是面试官所期望的答案。
     */
    public int minNumberInRotateArray(int [] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        int min = array[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }


    /**
     * 利用二分查找的思想
     */
    public int minNumberInRotateArray1(int [] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        int l = 0, r = n - 1;
        while (l <= r) { // l < r也可以
            int m = l + ((r - l) >> 1);
            if (array[m] == array[r]) {
                r--;
            } else if (array[m] > array[r]) {
                l = m + 1;
            } else if (array[m] < array[r]) {
                r = m;
            }
        }
        return array[l];
    }

}
