package 排序;

public class 快速排序 {

    public static void main(String[] args) {
        int s[] = {2, 1, 20, -1, -5, 40, 3, 8, 8};
        quickSort(s, 0, s.length - 1);
        for (int i : s) {
            System.out.print(i + " ");
        }
    }

    /**
     * 空间复杂度：O(logN)
     * 每次递归传参left，和right，平均递归次数是log(n)次，所以平均空间复杂度是O(log(n))
     * @param arr
     * @param l
     * @param r
     */
    public static void quickSort(int[] arr, int l, int r) {
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
