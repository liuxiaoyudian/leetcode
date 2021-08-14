package 代码随想录.栈与队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/1047.删除字符串中的所有相邻重复项.md
 */
public class Solution1047 {

    /**
     * 使用栈
     */
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    /**
     * 注意体会这个思想！！！
     * 直接在char数组上原地操作
     */
    public String removeDuplicate1(String s) {
        char[] chars = s.toCharArray();
        int index = -1; // index和i错开了一位，index是i的前一位（注意体会这个思想）
        for (int i = 0; i < chars.length; i++) {
            if (index == -1 || chars[index] != chars[i]) {
                chars[++index] = chars[i];
            } else {
                index--;
            }
        }
        return String.valueOf(chars, 0, index + 1);
    }

}
