package 代码随想录.栈与队列;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0020.有效的括号.md
 */
public class Solution20 {

    /**
     * 自己实现的
     * 思路：先看栈空不空，空了就直接进栈，否则就看栈顶和c是否匹配，匹配就出栈，不匹配就入栈，最后看栈是否为空即可。
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char peek = stack.peek();
                if (peek == '(' && c == ')') {
                    stack.pop();
                } else if (peek == '{' && c == '}') {
                    stack.pop();
                } else if (peek == '[' && c == ']') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

        }
        return stack.isEmpty();
    }


    /**
     * 官方答案
     * 思路：先判断是左括号还是右括号，如果是左括号则直接入栈，如果是右括号，则栈顶的左括号必须与之匹配，否则就返回false
     */
    public boolean isValid1(String s) {
        if (s.length() % 2 == 1) { // 一个小优化
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
