package 代码随想录.栈与队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/submissions/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0150.逆波兰表达式求值.md
 */
public class Solution150 {


    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                // 注意两个弹出的顺序，先弹出来的位于operator的右边，后弹出来的位于operator的左边
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
//                if (s.equals("+")) {
//                    stack.push(num1 + num2);
//                } else if (s.equals("-")) {
//                    stack.push(num1 - num2);
//                } else if (s.equals("*")) {
//                    stack.push(num1 * num2);
//                } else if (s.equals("/")) {
//                    stack.push(num1 / num2);
//                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

}
