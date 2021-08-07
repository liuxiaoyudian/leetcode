package 排序;

/**
 * 插入排序的核心思想是将无序序列中的数据插入到有序的序列中。
 * 在遍历无序序列时，首先拿无序序列中的首元素去与有序序列中的每一个元素比较并插入到合适的位置，一直到无序序列中的所有元素插完为止。
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 0, -10, 3, 8, 1000, -200, 5, 7, 4, 3};
        insertionSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }


    }

    public static void insertionSort(int[] nums) {
        // 外层循环控制需要排序的趟数（从1开始因为将第0位看成了有序数据）
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i]; // 把要插入的这个数据暂存起来，因为后移操作，可能会覆盖这个值
            int j;
            for (j = i - 1; j >= 0 && nums[j] > temp; j--) {
                nums[j + 1] = nums[j];  // 后移
            }
            nums[j + 1] = temp;
        }
    }

}
