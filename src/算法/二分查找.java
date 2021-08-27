package 算法;

/**
 * 核心思想是分治法
 * https://blog.csdn.net/qwe0754444/article/details/84975295
 * https://www.cnblogs.com/kyoner/p/11080078.html
 */
public class 二分查找 {

    public static void main(String[] args) {
//        int[] nums = {4, 7, 8, 10, 14, 21, 22, 36, 62, 77, 81, 91};
//        System.out.println(binarySearch(nums, 21));

        int[] nums = {1, 2, 4, 4};
//        int[] nums = {1};
        System.out.println(rightBoundBinarySearch(nums, 100));

    }

    public static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);  // 注意这还有一个括号，右移运算符的优先级很低
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 寻找左侧边界的二分搜索（需要返回下标）
     */
    public static int leftBoundBinarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) { // 终止条件为i == j时，此时搜索空间[i, j)恰巧为空
            // 下一步的搜索区间应该去掉 mid 分割成两个区间 [left, mid) 或 [mid + 1, right)
            int mid = l + ((r - l) >> 1);
            if (target == nums[mid]) {
                r = mid; // 这一步就是算法为什么能够搜索左边界的原因，找到target不会立即返回，而是缩小搜索区间的上界j
            } else if (target < nums[mid]) { // [left, mid)
                r = mid;
            } else if (target > nums[mid]) { // [mid + 1, right)
                l = mid + 1;
            }
        }

        if (l == nums.length) { // target大于nums数组所有元素的情况（防止l越界） + nums数组为空的情况
            return -1;
        }

        return nums[l] == target ? l : -1;  // target小于nums数组所有元素的情况 + target位于中间且不存在的情况
    }

    public static int rightBoundBinarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (target == nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            }
        }

        if (l == 0) {  // target小于nums数组所有元素的情况（防止l-1越界） + nums数组为空的情况
            return -1;
        }

        return nums[l - 1] == target ? l - 1 : -1;  // target大于nums数组所有元素的情况 + target位于中间且不存在的情况
    }

}
