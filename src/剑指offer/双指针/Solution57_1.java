package 剑指offer.双指针;

import java.util.ArrayList;

/**
 * 57.1 和为 S 的两个数字
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/57.1%20和为%20S%20的两个数字.md
 */
public class Solution57_1 {

    /**
     * 两个指针，一前一后
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        int i = 0, j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];
            if (cur == sum) {
                ret.add(array[i]);
                ret.add(array[j]);
                return ret;
            } else if (cur < sum) {
                i++;
            } else {
                j--;
            }
        }
        return ret;
    }

}
