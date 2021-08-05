package 代码随想录.数组;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class Solution844 {

    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
        System.out.println(backspaceCompare(s, t));
    }

    /**
     * 双指针
     *
     * 时间复杂度：O(N + M)，其中 N 和 M 分别为字符串 S 和 T 的长度。我们需要遍历两字符串各一次
     * 空间复杂度：O(1)
     */
    public static boolean backspaceCompare(String s, String t) {
        // 这里的i和j就是两个指针
        int i = s.length() - 1, j = t.length() - 1; // 逆序遍历字符串
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) { // 从s中倒着找一个能够确定的字符
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) { // 从t中倒着找一个能够确定的字符
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                // 并不是一定能找到一个确定的字符，也有可能全部删了
                // 例子：ab##和c#d#，第一轮下来i=-1，j=-1
                if (i >= 0 || j >= 0) { // 必须要有这个if
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    /**
     * 栈
     */
    public boolean backspaceCompare1(String s, String t) {
        return getStack(s).equals(getStack(t));
    }

    public Stack<Character> getStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) { // 栈内没有元素的时候调用pop会报错，对应着条件：如果对空文本输入退格字符，文本继续为空
                    stack.pop();
                }
            }
        }
        return stack;
    }

}