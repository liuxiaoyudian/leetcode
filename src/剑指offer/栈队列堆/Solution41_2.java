package 剑指offer.栈队列堆;

import java.util.LinkedList;
import java.util.Queue;

public class Solution41_2 {

    int[] cnts = new int[128];

    /**
     * 使用队列（主题体会这个思想）
     * 使用队列来存储到达的字符，并在每次有新的字符从字符流到达时移除队列头部那些出现次数不再是一次的元素。
     * 因为队列是先进先出顺序，因此队列头部的元素为第一次只出现一次的字符。
     */
    Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }

//    /**
//     * 我的实现方法，较笨，更好的方法是使用队列
//     */
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
