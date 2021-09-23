package 剑指offer.二分查找;

/**
 * 53. 数字在排序数组中出现的次数
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/53.%20数字在排序数组中出现的次数.md
 */
public class Solution53 {

    /**
     * 寻找左侧边界的二分搜索
     */
    public int GetNumberOfK(int [] array , int k) {
        int l = 0, r = array.length;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (k == array[m]) {
                r = m; // // 关键点在这里，找到后，并没有立马返回，而是一直搜小范围
            } else if (k < array[m]) {
                r = m;
            } else if (k > array[m]) {
                l = m + 1;
            }
        }
        int cnt = 0;
        for (int i = l; i < array.length; i++) {
            if (array[i] != k) {
                break;
            }
            cnt++;
        }
        return cnt;
    }

}
