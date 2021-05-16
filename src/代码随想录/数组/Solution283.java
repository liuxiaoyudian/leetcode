package 代码随想录.数组;

/**
 * 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class Solution283 {

    /**
     * 双指针
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        // 将slowIndex之后的冗余元素赋值为0
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }

}
