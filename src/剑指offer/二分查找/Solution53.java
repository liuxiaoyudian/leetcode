package 剑指offer.二分查找;

public class Solution53 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(GetNumberOfK(arr, 3));
    }


    public static int GetNumberOfK(int [] array , int k) {
        // 寻找左侧边界的二分搜索
        int i = 0;
        int j = array.length;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (k == array[mid]) {
                j = mid; // 关键点在这里，找到了，并没有立马返回，而是一直搜小范围
            } else if (k < array[mid]) {
                j = mid;
            } else if (k > array[mid]) {
                i = mid + 1;
            }
        }
//         if (i == array.length || array[i] != k) {
//             return 0;
//         }
        int count = 0; // 对于没有出现过的数字来说，就是0
        for (;i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }
        }
        return count;
    }

}
