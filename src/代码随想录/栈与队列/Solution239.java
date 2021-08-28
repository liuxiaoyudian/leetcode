package 代码随想录.栈与队列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0239.滑动窗口最大值.md
 */
public class Solution239 {

    public static void main(String[] args) {
        Solution239 instance = new Solution239();
//        int[] nums = {-7, -8, 7, 5, 7, 1, 6, 0};
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(maxSlidingWindow(nums, 3));
//        System.out.println(Arrays.toString(instance.maxSlidingWindow1(nums, 3)));
    }

    /**
     * 大顶堆
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 特殊的大顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int[] res = new int[n - k + 1];
        int i = 0, j = 0;
        while (j < n) {
            if (j - i < k) {
                pq.offer(new int[]{nums[j], j});
                j++;
            } else {
                res[i] = pq.peek()[0];
                pq.offer(new int[]{nums[j], j});
                // 每当我们向右移动窗口时，我们就可以把一个新的元素放入优先队列中，此时堆顶的元素就是堆中所有元素的最大值。
                // 然而这个最大值可能并不在滑动窗口中，在这种情况下，这个值在数组 nums 中的位置出现在滑动窗口左边界的左侧。
                // 因此，当我们后续继续向右移动窗口时，这个值就永远不可能出现在滑动窗口中了，我们可以将其永久地从优先队列中移除。
                while (pq.peek()[1] <= j - k) { // 关键点在这里
                    pq.poll();
                }
                i++;
                j++;
            }
        }
        res[i] = pq.peek()[0]; // 不要漏了这一句
        return res;
    }


    /**
     * 使用单调队列来实现
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        MyQueue myQueue = new MyQueue();
        int i = 0, j = 0;
        while (j < n) {
            if (j - i < k) {
                myQueue.offer(nums[j++]);
            } else {
                int max = myQueue.peek();
                res[i] = max;
                myQueue.offer(nums[j++]);
                myQueue.poll(nums[i++]);
            }
        }
        res[i] = myQueue.peek(); // 不要漏了这一行代码！
        return res;
    }

    // 单调队列（递减）
    // 其实没必要维护窗口里的所有元素，只需要维护有可能成为窗口里最大值的元素就可以了，同时保证队里里的元素数值是由大到小的。

    /**
     * 单调队列（递减）
     * 实没必要维护窗口里的所有元素，只需要维护有可能成为窗口里最大值的元素就可以了，同时保证队里里的元素数值是由大到小的。
     * 注意队列的几个方法：pollLast() 和 getLast()
     */
    class MyQueue {

        Deque<Integer> deque = new LinkedList<>();

        // 弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
        void poll(int val) {
            if (val == deque.peek()) {
                deque.poll();
            }
        }

        // 添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        // 比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
        void offer(int val) {
            // 注意这里不能是>=，只能是=，因为不光光有offer操作，还会有poll操作
            // 例子：{-7, -8, 7, 5, 7, 1, 6, 0} - k = 4
            while (!deque.isEmpty() && val > deque.peekLast()) { // 注意是末尾元素！peekLast
                deque.pollLast(); // 注意是末尾元素！pollLast
            }
            deque.offer(val);
        }

        // 队顶元素始终为最大值
        int peek() {
            return deque.peek();
        }

    }
}
