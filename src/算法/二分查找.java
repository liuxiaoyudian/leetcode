package 算法;

/**
 * 核心思想是分治法
 * https://blog.csdn.net/qwe0754444/article/details/84975295
 * https://www.cnblogs.com/kyoner/p/11080078.html
 */
public class 二分查找 {

    public static void main(String[] args) {
        int[] arr = {4, 7, 8, 10, 14, 21, 22, 36, 62, 77, 81, 91};
        System.out.println(binarySearch(arr, 21));
    }

    public static int binarySearch(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) { // 注意这里是是<=，意味着是区间是左闭右闭的
            int mid = j + (i - j) / 2; // 避免mid溢出
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                j = mid - 1;
            } else if (target > arr[mid]) {
                i = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 寻找左侧边界的二分搜索
     * @param arr
     * @param target
     * @return
     */
    public static int leftBoundBinarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int i = 0;
        int j = arr.length; // 左闭右开

        while (i < j) { // 终止条件为i == j时，此时搜索空间[i, j)恰巧为空
            // 下一步的搜索区间应该去掉 mid 分割成两个区间 [left, mid) 或 [mid + 1, right)
            int mid = i + (j - i) / 2;
            if (target == arr[mid]) {
                j = mid; // 这一步就是算法为什么能够搜索左边界的原因，找到target不会立即返回，而是缩小搜索区间的上界j
            } else if (target < arr[mid]) { // [left, mid)
                j = mid;
            } else if (target > arr[mid]) { // [mid + 1, right)
                i = mid + 1;
            }
        }
        // 此时的i有特殊的含义
        if (i == arr.length - 1) {
            return -1;
        }
        return arr[i] == target ? i : -1;
    }

}
