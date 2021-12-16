package 排序;

import java.util.Arrays;

/**
 * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。
 * 希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
 * <p>
 * 选择增量为gap=length/2，缩小增量以gap=gap/2的方式
 */
public class 希尔排序 {

    public static void main(String[] args) {
        int[] nums = {2, -10, 5, 1, 3, 8, 0, -5, -5, 29, 5, 7, 4, 3, -2, 100, 99};
        shellSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void shellSort(int[] nums) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {  // 注意i是从gap开始的
                int j = i; // 不是j=gap，是j=i！！！
                // 注意理解这个while，假设一个很小的值交换到前面后，此时如果该小值还是小于其前面的值，则继续交换
                while (j - gap >= 0 && nums[j] < nums[j - gap]) {
                    int temp = nums[j];
                    nums[j] = nums[j - gap];
                    nums[j - gap] = temp;
                    j -= gap;
                }
            }
        }
    }

}
