package 代码随想录.数组;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class Solution844 {

    /**
     * 双指针
     *
     * 时间复杂度：O(N + M)，其中 N 和 M 分别为字符串 S 和 T 的长度。我们需要遍历两字符串各一次
     * 空间复杂度：O(1)
     */
    public boolean backspaceCompare(String s, String t) {
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
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return stack;
    }

}