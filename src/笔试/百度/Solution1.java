package 笔试.百度;
import java.util.*;

public class Solution1 {


    public static void main(String[] args) {
        // [100, 99, 82, 30, 20, 8, 1, -2, -10]
        int[] nums = {1, 20, 30, -10, -2, 99, 82, 100, 100, 8};
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        Integer[] l = set.toArray(new Integer[]{}); // 去重复操作
        for (int k = 1; k <= nums.length; k++) {
            System.out.print(findKMax(l, 0, l.length - 1, k - 1) + " ");
        }
    }

    /**
     * 百度一面手撕代码
     * 无序数组第k大元素的值（要考虑重复值的情况）
     */
    public static int findKMax(Integer[] nums, int l, int r, int k) {
        if (l <= r) {
            int index = partition(nums, l, r);
            if (k == index) {
                return nums[index];
            } else if (k < index) {
                return findKMax(nums, l, index - 1, k);
            } else if (k > index) {
                return findKMax(nums, index + 1, r, k);
            }
        }
        return -1;
    }

    // 注意这里是降序
    public static int partition(Integer[] nums, int l, int r) {
        int i = l, j = r, k = nums[l];
        while (i < j) {
            while (i < j && k >= nums[j]) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && k < nums[i]) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = k;
        return i;
    }


}
