package 排序;

public class 归并排序 {

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 8, 5, 7, 4, 3};
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);  // 左边归并排序，使得左子序列有序
            sort(arr, m + 1, r); // 右边归并排序，使得右子序列有序
            merge(arr, l, m, r);
        }
    }

    /**
     * Merges two subarray of arr[]
     * First subarray is arr[l...m]
     * Second subarray is arr[m+1...r]
     * @param arr
     * @param l
     * @param m
     * @param r
     */
    public static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarray to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int k = l;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}
