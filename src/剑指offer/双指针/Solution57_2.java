package 剑指offer.双指针;

import java.util.ArrayList;

public class Solution57_2 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ret = FindContinuousSequence(3);
        System.out.println(ret.get(0));
    }

    /**
     * 注意一个关键点，是连续正数数列，关键是连续
     * 这里还有一个隐藏条件，因为要求的是所有和为s的连续正数序列，序列至少有2个数字组成，所以sum至少为3
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        // 两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int i = 1, j = 2;
        int cur = 3;
        while (i < j) { // 思考一下为什么是i < j
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    list.add(k);
                }
                ret.add(list);
                cur -= i++;
                cur += ++j;
            }
            if (cur < sum) {
                cur += ++j;
            }
            if (cur > sum) {
                cur -= i++;
            }
        }
        return ret;
    }

}
