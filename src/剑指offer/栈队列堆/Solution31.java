package 剑指offer.栈队列堆;

import java.util.ArrayList;
import java.util.Stack;

public class Solution31 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        System.out.println(IsPopOrder1(a, b));
    }

    /**
     * 自己的解法
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < pushA.length && j < popA.length) {
            if (list.size() != 0 && list.get(list.size() - 1) == popA[j]) {
                j++;
                list.remove(list.size() - 1);
            }
            if (pushA[i] != popA[j]) {
                list.add(pushA[i++]);
            } else {
                i++;
                j++;
            }
        }
        for (int k = list.size() - 1; k >= 0; k--) {
            if (list.get(k) != popA[j++]) {
                return false;
            }
        }
        return true;
    }

    public static boolean IsPopOrder1(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (j < popA.length && !stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }

        }
        return stack.isEmpty();
    }

}
