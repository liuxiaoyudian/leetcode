package 剑指offer.双指针;

import java.util.ArrayList;

public class Solution57_1 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        int i = 0, j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];
            if (cur == sum) {
                ret.add(array[i]);
                ret.add(array[j]);
                return ret;
            }
            if (cur < sum) {
                i++;
            } else {
                j--;
            }
        }
        return ret;
    }

}
