package 代码随想录.栈与队列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * 347.前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/solution/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0347.前K个高频元素.md
 */
public class Solution347 {

    /**
     * map搭配堆的解法
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // {num: count}
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 使用小顶堆
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (pq.size() != k) {
                pq.offer(new int[] {num, count});
            } else {
                if (count > pq.peek()[1]) {
                    pq.poll();
                    pq.offer(new int[] {num, count});
                }
            }
        }
        int[] res = new int[k];
        while (k-- > 0) { // 找出前K个高频元素，因为小顶堆先弹出的是最小的，所以倒序来输出到数组
            res[k] = pq.poll()[0];
        }
        return res;
    }

}
