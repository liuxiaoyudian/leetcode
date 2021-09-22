package 剑指offer.排序;

/**
 * 51. 数组中的逆序对
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/51.%20数组中的逆序对.md
 */
public class Solution51 {

    int cnt = 0;

    public int InversePairs(int [] array) {
        mergeSort(array, 0, array.length - 1);
        return cnt;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + ((r - l) >> 1);
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

    public void merge(int[] nums, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else { // 如果前面的元素大于后面的 (nums[i] > nums[j])，那么在前面元素之后的元素都能和后面的元素构成逆序对
                // 假设我们要求解[A,B]这样的数组的逆序对，其中[A]是一个已经排序的子数组，其中的逆序对为AA，[B]是另外一个已经排序的子数组，其中的逆序对为BB，
                // 然后我们用归并排序将A和B进行排序，此时发现可组成的逆序对为CC，[A B]这个数组 中的逆序对数目就=AA+BB+CC
                temp[k++] = nums[j++];
                cnt = (cnt + (m - i + 1)) % 1000000007;
            }
        }
        while (i <= m) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }
        for (int n = 0; n < k; n++) {
            nums[n + l] = temp[n];
        }
    }

}
