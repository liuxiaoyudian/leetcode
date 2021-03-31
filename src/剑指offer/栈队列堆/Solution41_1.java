package 剑指offer.栈队列堆;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution41_1 {

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 1, 6, 7, 0, 8};
    }


    /**
     * 默认情况下，PriorityQueue是小顶堆
     * 注意这个和堆排序不一样，堆排序升序构造大顶堆，降序构造小顶堆。
     */
    /* 大顶堆，存储左半边元素 */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    /* 当前数据流读入的元素个数 */
    private int N = 0;

    public void Insert(Integer num) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N % 2 == 0) {
            /* N 为偶数的情况下插入到右半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else { // 为奇数的时候总是右边多一个，因为是先插入右边的
            return (double) right.peek();
        }
    }


//    static ArrayList<Integer> list = new ArrayList<>();
//
//    public static void Insert(Integer num) {
//        list.add(num);
//    }
//
//    /**
//     * 自己的笨方法
//     * @return
//     */
//    public static Double GetMedian() {
//        int l = list.size();
//        if (l % 2 == 0) {
//
//            return Double.valueOf((list.get(l / 2 - 1) + list.get(l / 2))) / 2;
//        } else {
//            return Double.valueOf(list.get(l / 2));
//        }
//    }


}
