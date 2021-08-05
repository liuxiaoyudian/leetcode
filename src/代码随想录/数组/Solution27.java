package 代码随想录.数组;

/**
 * 27. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0027.移除元素.md
 */
public class Solution27 {

    /**
     * 暴力法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }


    /**
     * 快慢指针（慢指针指向的就是需要被替换掉的那个）
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int removeElement1(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow; // 注意此时slowIndex就等于数组的新长度
    }

}
