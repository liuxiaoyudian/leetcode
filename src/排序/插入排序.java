package 排序;

/**
 * 插入排序的核心思想是将无序序列中的数据插入到有序的序列中。
 * 在遍历无序序列时，首先拿无序序列中的首元素去与有序序列中的每一个元素比较并插入到合适的位置，一直到无序序列中的所有元素插完为止。
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 8, 5, 7, 4, 3};
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 外层循环控制需要排序的趟数（从1开始因为将第0位看成了有序数据）
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];  // 后移
            }
            arr[j + 1] = temp;
        }
    }

}
