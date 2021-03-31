package 剑指offer.栈队列堆;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution59 {

    /**
     * 维护一个大小为窗口大小的大顶堆，顶堆元素则为当前窗口的最大值。
     * 假设窗口的大小为 M，数组的长度为 N。
     * 在窗口向右移动时，需要先在堆中删除离开窗口的元素，并将新到达的元素添加到堆中，
     * 这两个操作的时间复杂度都为 log2M，因此算法的时间复杂度为 O(Nlog2M)，空间复杂度为 O(M)。
     *
     * 碰到这类问题，需要频繁插入，删除，且求最值的问题，要想起来用堆啊！！！！！！！！！
     * @param num
     * @param size
     * @return
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
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }


        return ret;
    }

}
