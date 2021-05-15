package 剑指offer.栈队列堆;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution40 {



    /**
     * 利用Collections.sort()来完成
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) {
            return list;
        }
        for (int i : input) {
            list.add(i);
        }
        Collections.sort(list);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i));
        }
        return res;
    }

    /**
     * 使用快速排序来完成
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        quickSort(input, 0, input.length - 1);
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length) {
            return res;
        }
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public void quickSort(int[] arr, int l, int r) {
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
            quickSort(arr, l, i - 1);
            quickSort(arr, i + 1, r);
        }

    }

    /**
     * 使用堆
     * 维护一个大小为 K 的最小堆过程如下：使
     * 用大顶堆。在添加一个元素之后，如果大顶堆的大小大于 K，那么将大顶堆的堆顶元素去除，也就是将当前堆中值最大的元素去除，从而使得留在堆中的元素都比被去除的元素来得小。
     * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
     *
     * PriorityQueue 默认是小顶堆
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        if (input == null || k > input.length) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : input) {
            maxQueue.add(i);
            if (maxQueue.size() > k) {
                maxQueue.poll();
            }
        }
        return new ArrayList<>(maxQueue);
    }

}
