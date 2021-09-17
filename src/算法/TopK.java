package 算法;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Top K问题
 */
public class TopK {

    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 1, 8, 2, 9, 4, 7, 2, 6, 6};
//        System.out.println(Arrays.toString(topK1(nums, 5)));
//        System.out.println(Arrays.toString(topK3(nums, 6)));
        System.out.println(Arrays.toString(topK4(nums, 0, nums.length - 1, 6)));
    }

    /**
     * 思路1
     * 全局排序（注意：该方法需要保证数组能够全部加载进内存）
     * <p>
     * 时间复杂度：O(nlog(n))
     */
    public static int[] topK1(int[] nums, int k) {
        Arrays.sort(nums);
        return Arrays.copyOfRange(nums, nums.length - 5, nums.length);
    }

    /**
     * 思路2
     * 局部排序，利用冒泡排序
     * <p>
     * 时间复杂度：O(n*k)
     */
    public static int[] topK2(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            boolean flag = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return Arrays.copyOfRange(nums, n - 5, n);
    }

    /**
     * 思路3
     * 最小堆（Top K的经典算法）
     * <p>
     * 时间复杂度：O(nlog(k))
     * 一次堆调整log(k)，如果k远小于n，O(nlogK)其实就接近于O(n)了
     */
    public static int[] topK3(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(nums[i]);
            } else {
                if (minHeap.peek() < nums[i]) { // 如果被扫描的元素大于堆顶，则替换堆顶的元素，并调整堆，以保证堆内的k个元素，总是当前最大的k个元素
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    /**
     * 利用快速排序的思想
     *
     * 平均时间复杂度：O(n)，最差时间复杂度：O(n^2)
     */
    public static int[] topK4(int[] nums, int l, int r, int k) {
        if (l <= r) { // 注意是等号！！！
            int pivot = partition(nums, l, r);
            if (pivot + 1 == k) {
                return Arrays.copyOfRange(nums, 0, k);
            } else if (pivot + 1 < k) {
                return topK4(nums, pivot + 1, r, k);
            } else if (pivot + 1 > k) {
                return topK4(nums, l, pivot - 1, k);
            }
        }
        return null;
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

    /**
     * 分治法
     * 比如，如果要在100亿个数里面找最大的1000个，可以将100亿个数分为若干个区，然后找每个区的最大的1000个，最后再合并
     */
    public static int[] topK5(int[] nums, int k) {
        return null;
    }

    /**
     * 哈希法
     * 如果这1亿个书里面有很多重复的数，先通过Hash法，把这1亿个数字去重复，这样如果重复率很高的话，会减少很大的内存用量，从而缩小运算空间，
     * 然后通过分治法或最小堆法查找最大的10000个数。
     */
    public static int[] topK6(int[] nums, int k) {
        return null;
    }

}
