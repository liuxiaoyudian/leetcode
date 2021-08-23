package 排序;

public class 归并排序 {

    public static void main(String[] args) {
        int[] nums = {2, -12, 0, 5, 1, -10, 0, 100, 3, 8, 5, 7, -99, 4, 3, 200};
        sort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + ((r - l) >> 1);
            sort(nums, l, m);  // 左边归并排序，使得左子序列有序
            sort(nums, m + 1, r); // 右边归并排序，使得右子序列有序
            merge(nums, l, m, r);
        }
    }

    /**
     * Merges two subarray of nums[]
     * First subarray is nums[l...m]
     * Second subarray is nums[m+1...r]
     */
    public static void merge(int[] nums, int l, int m, int r) {
        // Find sizes of two subarray to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = nums[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = nums[m + 1 + j];
        }

        int k = l; // 注意k的值不是0哦
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k++] = L[i++];
            } else {
                nums[k++] = R[j++];
            }
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            nums[k++] = L[i++];
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            nums[k++] = R[j++];
        }
    }

}
