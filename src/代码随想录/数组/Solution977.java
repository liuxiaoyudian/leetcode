package 代码随想录.数组;

import java.util.Arrays;

public class Solution977 {

    /**
     * 直接排序
     */
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    /**
     * 双指针
     * 思路：找出负数与非负数的分界线，然后一个指针从左往右走，一个指针从右往左走
     */
    public int[] sortedSquares1(int[] nums) {
        int index = 0;
        int[] ans = new int[nums.length];
        int t = 0; // 找到负数与非负数的分界线
        while (t < nums.length - 1 && nums[t] < 0) {
            t++;
        }
        int i = t - 1, j = t; // 双指针，i往左走，j往右走
        while (i >= 0 && j < nums.length) {
            int v1 = nums[i] * nums[i];
            int v2 = nums[j] * nums[j];
            if (v1 == v2) {
                ans[index++] = v1;
                ans[index++] = v2;
                i--;
                j++;
            } else if (v1 < v2) {
                ans[index++] = v1;
                i--;
            } else if (v1 > v2) {
                ans[index++] = v2;
                j++;
            }
        }
        while (i >= 0) {
            ans[index++] = nums[i] * nums[i];
            i--;
        }
        while (j < nums.length) {
            ans[index++] = nums[j] * nums[j];
            j++;
        }
        return ans;
    }


    /**
     * 双指针
     * 思路：使用两个指针分别指向位置0和n−1，每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针
     */
    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int index = n - 1, i = 0, j = n - 1;
        while (i <= j) {
            int v1 = nums[i] * nums[i];
            int v2 = nums[j] * nums[j];
            if (v1 > v2) {
                i++;
                ans[index--] = v1;
            } else {
                j--;
                ans[index--] = v2;
            }
        }
        return ans;
    }


}
