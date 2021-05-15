package 剑指offer.排序;


/**
 * 调整数组顺序使奇数位于偶数前面
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/21.%20调整数组顺序使奇数位于偶数前面.md
 */
public class Solution21 {


    /**
     * 这个ac不了，超时了，通过率80%
     * @param array
     * @return
     */
    public int[] reOrderArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
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
     * 通过创建两个数组（奇数数组和偶数数组）来实现
     *
     * @param array
     * @return
     */
    public int[] reOrderArray1(int[] array) {
        // write code here
        int len = array.length;
        int[] odds = new int[len];
        int[] evens = new int[len];
        int n = 0, m = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                odds[m++] = i;
            } else {
                evens[n++] = i;
            }
        }
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            if (i < n) {
                ret[i] = evens[i];
            } else {
                ret[i] = odds[i - n];
            }
        }
        return ret;
    }

    /**
     * 也是通过创建新数组来实现（另外一种实现，先找oddCnt）
     * 这种方法只需要创建一个新数组就够了
     *
     * @param array
     * @return
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
