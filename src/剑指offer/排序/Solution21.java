package 剑指offer.排序;


import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/21.%20调整数组顺序使奇数位于偶数前面.md
 */
public class Solution21 {

    /**
     * 利用冒泡排序的思想，会超时
     */
    public static int[] reOrderArray(int[] array) {
        int even = array.length;
        for (int i = 0; i < even - 1; i++) {
            for (int j = 0; j < even - 1 - i; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }


    /**
     * 创建两个数组（奇数数组和偶数数组）
     */
    public int[] reOrderArray1(int[] array) {
        int n = array.length;
        int[] odds = new int[n]; // 奇数数组
        int[] evens = new int[n]; // 偶数数组
        int odd = 0, even = 0;
        for (int i : array) {
            if (i % 2 == 1) {
                odds[odd++] = i;
            } else {
                evens[even++] = i;
            }
        }
        for (int i = 0; i < n; i++) {
            array[i] = i < odd ? odds[i] : evens[i - odd];
        }
        return array;
    }


    /**
     * 也是通过创建新数组来实现（另外一种实现，先找oddCnt）
     * 这种方法只需要创建一个新数组就够了
     */
    public int[] reOrderArray2(int[] array) {
        int oddCnt = 0;
        for (int i : array) {
            if (i % 2 != 0) {
                oddCnt++;
            }
        }
        int[] copy = array.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1) {
                array[i++] = num;
            } else {
                array[j++] = num;
            }
        }
        return array;
    }

}
