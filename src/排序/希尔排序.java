package 排序;

/**
 * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。
 * 希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
 *
 * 选择增量为gap=length/2，缩小增量以gap=gap/2的方式
 */
public class 希尔排序 {

    public static void main(String[] args) {
        int[] arr = {2, -10, 5, 1, 3, 8, 0, -5, -5, 29, 5, 7, 4, 3, -2, 100, 99};
        shellSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {  // 注意i是从gap开始的
                int j = i;
                // 注意理解这个while，假设一个很小的值交换到前面后，此时如果该小值还是小于其前面的值，则继续交换
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                    j -= gap;
                }
            }
        }
    }

}
