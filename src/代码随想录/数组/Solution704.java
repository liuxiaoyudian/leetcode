package 代码随想录.数组;

/**
 * 704. 二分查找
 * https://leetcode-cn.com/problems/binary-search/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0704.二分查找.md
 *
 * 二分查找的两个前提 (核心思想是分治法)
 * 1. 有序
 * 2. 无重复元素
 *
 * 拓展内容：
 * https://blog.csdn.net/qwe0754444/article/details/84975295
 * https://www.cnblogs.com/kyoner/p/11080078.html
 */
class Solution704 {

    // 写法1：左闭右闭[left, right]
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
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

    // 写法2：左闭右开[left, right)
    public int search1(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            }
        }
        return -1;
    }

}
