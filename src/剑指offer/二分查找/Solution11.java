package 剑指offer.二分查找;

/**
 * 旋转数组的最小数字
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/11.%20旋转数组的最小数字.md
 */
public class Solution11 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 1};
        System.out.println(minNumberInRotateArray1(nums));
    }

    /**
     * 暴力法
     * 直接遍历一遍数组，即可找到最小值。但是本题的附加条件就没有用上。肯定不是面试官所期望的答案。
     */
    public int minNumberInRotateArray(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            min = Math.min(min, i);
        }
        return min;
    }


    /**
     * 利用二分查找的思想
     */
    public static int minNumberInRotateArray1(int[] array) {
        int l = 0, r = array.length - 1;
        while (l <= r) { // l < r也可以
            int m = l + ((r - l) >> 1);
            if (array[m] == array[r]) { // 出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边还是右边,这时只好一个一个试
                r--;
            } else if (array[m] > array[r]) { // 最小值在右边（不包含m），出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边
                l = m + 1;
            } else if (array[m] < array[r]) { // 最小值在左边（可能包含m），出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左边。因为右边必然都是递增的。
                r = m;
            }
        }
        return array[l];
    }

}
