package 剑指offer.数组与矩阵;

public class Solution4 {

    /**
     * 从右上角开始查询
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int r = 0;
        int c = array[0].length - 1;
        while (r < array.length && c >= 0) {
            if (target == array[r][c]) {
                return true;
            }
            if (target < array[r][c]) {
                c--;
            } else { // 这里必须用else！！！ 因为一次while循环，只能出现c--或者r++，不能同时出现！
                r++;
            }
        }
        return false;
    }

}
