package 剑指offer.数组与矩阵;

public class Solution4 {

    /**
     * 从右上角开始查询
     */
    public boolean Find(int target, int [][] array) {
        if (array.length == 0) {
            return false;
        }
        int i = 0, j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            int num = array[i][j];
            if (target == num) {
                return true;
            } else if (target < num) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}
