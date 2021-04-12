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
//            int mid = (i + j) / 2;
            int mid = j + (i - j) / 2; // 避免mid溢出
            if (target > arr[mid]) {
                i = mid + 1;
            } else if (target < arr[mid]) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
