package 剑指offer.栈队列堆;

import java.util.ArrayList;
import java.util.Collections;

public class Solution40 {


    /**
     * 利用Collections.sort()来完成
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) {
            return list;
        }
        for (int i : input) {
            list.add(i);
        }
        Collections.sort(list);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i));
        }
        return res;
    }

    /**
     * 使用快速排序来完成
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        quickSort(input, 0, input.length - 1);
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length) {
            return res;
        }
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = arr[l];
            while (i < j) {
                while (i < j && x <= arr[j]) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && x > arr[i]) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }

            arr[i] = x;
            quickSort(arr, l, i - 1);
            quickSort(arr, i + 1, r);
        }

    }

}
