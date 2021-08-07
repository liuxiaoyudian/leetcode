package 排序;

/**
 * 选择排序是一种简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 8, 5, 7, 4, 3, -1, 200, -20, 0};
        selectionSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void selectionSort(int[] nums) {
         // 总共要经过 N-1 轮比较
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }

}
