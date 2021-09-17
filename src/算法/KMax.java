package 算法;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 无序数组中寻找第K大的元素
 */
public class KMax {

    public static void main(String[] args) {
        int[] nums = {1, 20, 30, -10, -2, 99, 82, 100, 100, 8};
        for (int i = 1; i < 11; i++) {
            System.out.println(findKthMax3(nums, 0, nums.length - 1, i));
        }
    }


    /**
     * 排序（不考虑重复的情况）
     * <p>
     * 时间复杂度：O(nlog(n)
     */
    public static int findKthMax1(int[] nums, int k) {
        Arrays.sort(nums);
        System.err.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }


    /**
     * 最小堆（不考虑重复的情况）
     * <p>
     * 时间复杂度：O(nlog(k))
     */
    public static int findKthMax2(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(nums[i]);
            } else {
                if (minHeap.peek() < nums[i]) {
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }

    /**
     * 利用快速排序的思想
     *
     * 平均时间复杂度：O(n)，最差时间复杂度：O(n^2)
     */
    public static int findKthMax3(int[] nums, int l, int r, int k) {
        if (l <= r) { // 注意这里有等号！
            int pivot = partition(nums, l, r);
            if (pivot == k - 1) {
                return nums[pivot];
            } else if (pivot > k - 1) {
                return findKthMax3(nums, l, pivot - 1, k);
            } else if (pivot < k - 1) {
                return findKthMax3(nums, pivot + 1, r, k);
            }
        }
        return -1;
    }

    // 降序
    public static int partition(int[] nums, int l, int r) {
        int i = l, j = r, k = nums[l];
        while (i < j) {
            while (i < j && nums[j] <= k) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] > k) {
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
