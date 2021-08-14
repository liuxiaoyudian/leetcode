package 代码随想录.字符串;

import java.util.*;

/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class Solution151 {

    /**
     * 使用Java的API实现
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }


    /**
     * 不使用API，自己编写函数实现
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * 要学会使用StringBuilder！
     */
    public String reverseWords1(String s) {
        // 去除首尾以及中间多余空格
        StringBuilder sb = trimSpace(s);
        // 反转整个字符串
        reverse(sb, 0, sb.length() - 1);
        // 反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    // 理解这个方法的实现！
    public StringBuilder trimSpace(String s) {
        int l = 0, r = s.length() - 1;
        while (s.charAt(l) == ' ') {
            l++;
        }
        while (s.charAt(r) == ' ') {
            r--;
        }
        StringBuilder sb = new StringBuilder();
        while (l <= r) {
            char c = s.charAt(l);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') { // 这一行很关键
                sb.append(c);
            }
            l++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l++, sb.charAt(r));
            sb.setCharAt(r--, temp);
        }
    }

    // 理解这个方法的实现！
    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int l = 0, r = 0;
        while (l < n) {
            while (r < n && sb.charAt(r) != ' ') {
                r++;
            }
            reverse(sb, l, r - 1);
            l = r + 1;
            r++;
        }
    }

    /**
     * 使用了双端队列来实现
     * Java中Queue和Deque的区别：
     * 1. Deque继承自Queue
     * 2. Deque是双端队列（由于双端队列的定义，Deque可以作为栈或者队列使用），可以在首尾插入或删除元素。Queue是单端队列，即普通的FIFO队列
     * 3. Queue有一个直接子类PriorityQueue，而Deque中直接子类有两个：LinkedList以及ArrayDeque
     * 4. ArrayDeque和LinkedList都可以作为栈以及队列使用，但是从执行效率来说，ArrayDeque作为队列以及LinkedList作为栈使用会是更好的选择。
     */
    public String reverseWords2(String s) {
        int l = 0, r = s.length() - 1;
        while (s.charAt(l) == ' ') {
            l++;
        }
        while (s.charAt(r) == ' ') {
            r--;
        }

        // Queue被定义成单端队列使用，Deque被定义成双端队列使用。
        Deque<String> d = new LinkedList<>();
        StringBuilder word = new StringBuilder();

        while (l <= r) {
            char c = s.charAt(l);
            if (c != ' ') {
                word.append(c);
            } else if (word.length() != 0 && c == ' ') {
                d.offerFirst(word.toString());
                word.setLength(0); // 清空StringBuilder
            }
            l++;
        }
        d.offerFirst(word.toString());
        return String.join(" ", d);
    }



}
