package 代码随想录.数组;

/**
 * 26. 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution26 {


    /**
     * 快慢指针
     * 慢指针：需要确保唯一性的元素
     * 快指针：当前需要检测的元素
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) { // 如果数组nums的长度为0，则数组不包含任何元素，因此返回0
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1; // 注意数组的新长度是slow + 1
    }

}
