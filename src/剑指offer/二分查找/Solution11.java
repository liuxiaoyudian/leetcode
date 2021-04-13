package 剑指offer.二分查找;

/**
 * 旋转数组的最小数字
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/11.%20旋转数组的最小数字.md
 */
public class Solution11 {

    /**
     * 笨方法
     * 时间复杂度：O(n)
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                ret = array[i + 1];
                break;
            }
        }
        return ret;
    }

    /**
     * 思路：将旋转数组对半分可以得到一个包含最小元素的新旋转数组，以及一个非递减排序的数组。
     * 此时问题的关键在于确定对半分得到的两个数组哪一个是旋转数组，哪一个是非递减数组。
     *
     * 非递减数组的第一个元素一定小于等于最后一个元素。
     *
     * 通过修改二分查找算法进行求解（i 代表 low，m 代表 mid，j 代表 high）：
     *
     * 当 nums[m] <= nums[j] 时，表示 [m, j] 区间内的数组是非递减数组，[i, m] 区间内的数组是旋转数组，此时令 j = m；
     * 否则 [m + 1, j] 区间内的数组是旋转数组，令 i = m + 1。
     *
     * 但是这样的解法有一点点问题，即如果数组元素允许重复，会出现一个特殊的情况：nums[l] == nums[m] == nums[h]，
     * 此时无法确定解在哪个区间，需要切换到顺序查找。例如对于数组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，此时无法知道最小数字 0 在哪个区间。
     *
     * @param nums
     * @return
     */
    public int minNumberInRotateArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) { // 注意是i < j，结束的时候i == j
            int m = i + (j - i) / 2;
            if (nums[m] <= nums[j]) { // 右边是非递减数组，但不能排除此时的m不是最小值
                j = m;
            } else { // 右边是旋转数组，并且能够确定m不是最小值
                i = m + 1;
            }
        }
        return nums[i];
    }

}
