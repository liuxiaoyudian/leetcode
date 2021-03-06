package 剑指offer.数组与矩阵;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    /**
     * 使用set
     * @return
     */
    public int duplicate (int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i : numbers) {
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return -1;
    }

    /**
     * 使用额外的标记数组
     */
    public int duplicate1(int[] numbers) {
        int[] ret = new int[numbers.length];
        for (int i : numbers) {
            if (ret[i] != 0) {
                return i;
            }
            ret[i]++;
        }
        return -1;
    }

    /**
     * 交换法（最优）
     * 如果要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
     */
    public int duplicate2(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return -1;
    }

    public void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }



}
