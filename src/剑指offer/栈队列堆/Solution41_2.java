package 剑指offer.栈队列堆;

import java.util.LinkedList;
import java.util.Queue;

public class Solution41_2 {

    int[] cnts = new int[128];

    /**
     * 更好的方法，使用了队列，队列是FIFO
     * LinkedList的实现是基于链表，因此对于频繁的插入操作性能比ArrayList好
     */
    Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return queue.isEmpty() ? '#' : queue.peek();
    }

    /**
     * 我的实现方法，较笨，更好的方法是使用队列
     */
//    List<Character> list = new ArrayList<>();
//
//    int[] cnts = new int[128];
//
//    //Insert one char from stringstream
//    public void Insert(char ch)
//    {
//        list.add(ch);
//        cnts[ch]++;
//    }
//    //return the first appearence once char in current stringstream
//    public char FirstAppearingOnce()
//    {
//        for (char c : list) {
//            if (cnts[c] == 1) {
//                return c;
//            }
//        }
//        return '#';
//    }

}
