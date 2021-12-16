package 排序;

import java.util.Arrays;

public class 快速排序 {

    public static void main(String[] args) {
        int nums[] = {2, 1, 20, -1, -5, 0, 40, 3, 8, 100, 8};
        quickSort1(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 时间复杂度：O(nlog(n))
     * 空间复杂度：O(logn)
     * 每次递归传参left，和right，平均递归次数是log(n)次，所以平均空间复杂度是O(log(n))
     */
    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) { // l = r的时候就只有一个元素，不需要排序
            int i = l, j = r, k = nums[l]; // 用k将关键字缓存起来
            while (i < j) {
                while (i < j && nums[j] >= k) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && nums[i] < k) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = k;
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
    }


    /**
     * 快速排序的另外一种写法
     */
    public static void quickSort1(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = partition(nums, l, r);
            quickSort1(nums, l, pivot - 1);
            quickSort1(nums, pivot + 1, r);
        }
    }

    public static int partition(int[] nums, int l, int r) {
        int i = l, j = r, k = nums[l];
        while (i < j) {
            while (i < j && nums[j] >= k) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < k) {
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
