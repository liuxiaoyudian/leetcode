package 剑指offer.栈队列堆;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 59. 滑动窗口的最大值
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/59.%20滑动窗口的最大值.md
 *
 * 这一题和leetcode 239. 滑动窗口最大值是一样的
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class Solution59 {

    /**
     * 最笨的一种方法
     * 堆
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size == 0 || size > num.length) {
            return ret;
        }
        // 大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            heap.remove(num[i]); // 这里的时间复杂度会比较高，leetcode中这样写会超时
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }

    /**
     * 堆，改进的算法
     */
    public ArrayList<Integer> maxInWindows1(int [] num, int size) {
        int n = num.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0 || size > n) {
            return res;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int i = 0, j = 0;
        while (j < n) {
            if (j - i < size) {
                maxHeap.offer(new int[]{num[j], j});
                j++;
            } else {
                res.add(maxHeap.peek()[0]);
                maxHeap.offer(new int[]{num[j], j});
                while (maxHeap.peek()[1] <= j - size) {
                    maxHeap.poll();
                }
                i++;
                j++;
            }
        }
        res.add(maxHeap.peek()[0]);
        return res;
    }

    /**
     * 使用单调队列实现
     */
    public ArrayList<Integer> maxInWindows2(int [] num, int size) {
        int n = num.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0 || size > num.length) {
            return res;
        }
        MyQueue deque = new MyQueue();
        int i = 0, j = 0;
        while (j < n) {
            if (j - i < size) {
                deque.offer(num[j++]);
            } else {
                res.add(deque.peek());
                deque.offer(num[j++]);
                deque.poll(num[i++]);
            }
        }
        res.add(deque.peek());
        return res;
    }

}

class MyQueue {
    Deque<Integer> deque = new LinkedList<>();
    void offer(int val) {
        while (!deque.isEmpty() && val > deque.peekLast()) {
            deque.pollLast();
        }
        deque.offer(val);
    }

    void poll(int val) {
        if (val == deque.peek()) {
            deque.poll();
        }
    }

    int peek() {
        return deque.peek();
    }
}
