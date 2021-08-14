package 剑指offer.栈队列堆;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution40 {


    /**
     * 使用排序思想
     * 时间复杂度：O(Nlog(N))
     * 空间复杂度：O(log(N))
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    /**
     * 使用快速排序来完成
     * 平均时间复杂度：O(N)，最差的情况是O(N^2)
     * 空间复杂度：O(1)
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        quickSort(input, 0, input.length - 1, k);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }


    void quickSort(int[] arr, int l, int r, int k) {
        if (l < r) {
            int i = l, j = r, x = arr[l];
            while (i < j) {
                while (i < j && x <= arr[j]) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && x > arr[i]) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            if (k == i) { // 关键的修改点在这里，对比下和之前的区别（像二分法）
                return;
            } else if (k < i) {
                quickSort(arr, l, i - 1, k);
            } else if (k > i) {
                quickSort(arr, i + 1, r, k);
            }
        }
    }

    /**
     * 使用堆
     * 维护一个大小为 K 的最小堆过程如下：
     * 使用大顶堆。在添加一个元素之后，如果大顶堆的大小大于 K，那么将大顶堆的堆顶元素去除，也就是将当前堆中值最大的元素去除，从而使得留在堆中的元素都比被去除的元素来得小。
     * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
     * <p>
     * 时间复杂度：O(NlogK)
     * 空间复杂度：O(K)
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        // PriorityQueue 默认是小顶堆，可以在在初始化时使用 Lambda 表达式 (o1, o2) -> o2 - o1 来实现大顶堆
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : input) {
            maxQueue.offer(i); // 还有个方法是offer()
            if (maxQueue.size() > k) {
                maxQueue.poll();
            }
        }
        return new ArrayList<>(maxQueue);
    }

}
