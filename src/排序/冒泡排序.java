package 排序;

public class 冒泡排序 {

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 8, 5, 7, 4, -10, 3};
        bubbleSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) { // n-1趟
            boolean flag = true; // 记录是否交换
            for (int j = 0; j < nums.length - 1 - i; j++) { // 每趟比较的次数
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {  // 如果没有交换过元素，则已经有序
                return;
            }
        }
    }

}
