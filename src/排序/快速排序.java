package 排序;

public class 快速排序 {

    public static void main(String[] args) {
        int s[] = {2, 1, 20, -1, -5, 0, 40, 3, 8, 100, 8};
        quickSort(s, 0, s.length - 1);
        for (int i : s) {
            System.out.print(i + " ");
        }
    }

    /**
     * 空间复杂度：O(logN)
     * 每次递归传参left，和right，平均递归次数是log(n)次，所以平均空间复杂度是O(log(n))
     */
    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) { // l = r的时候就只有一个元素，不需要排序
            int i = l, j = r, k = nums[l]; // 用x将关键字缓存起来
            while (i < j) {
                while (i < j && k <= nums[j]) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && k > nums[i]) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = k;
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
    }

}
