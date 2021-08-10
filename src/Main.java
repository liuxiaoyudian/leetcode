import 代码随想录.二叉树.TreeNode;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(pushA, popA));
    }


    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushA.length && j < popA.length) {
            stack.push(pushA[i++]);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }

        while (j < popA.length && !stack.isEmpty() && stack.peek() == popA[j]) {
            stack.pop();
            j++;
        }

        if (j == popA.length) {
            return true;
        }

        return false;
    }
}
