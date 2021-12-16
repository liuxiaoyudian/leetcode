package 排序;

public class 堆排序 {

    public static void main(String[] args) {
        int nums[] = {2, 1, 20, -1, -5, 40, 3, 8, 8};
        heapSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    /**
     * 堆排序的三个知识点：
     * 1、第一个非叶子节点是n/2-1
     * 2、某一个节点i的左孩子是2*i+1，右孩子是2*i+2
     * 3、堆排序的数据结构在逻辑上属于完全二叉树
     * <p>
     * 大顶堆，用于升序
     */
    public static void heapSort(int[] nums) {
        int n = nums.length;
        // 构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapAdjust(nums, n, i);
        }

        // 排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = n - 1; i > 0; i--) { // 注意这里是>0，不是>=0
            // Move current root to end
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            // call headAdjust on the reduced heap
            heapAdjust(nums, i, 0);
        }

    }

    /**
     * @param nums
     * @param n    is the size of heap
     * @param i    is node
     */
    public static void heapAdjust(int[] nums, int n, int i) {
        // largest是下标，不是实际的值
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && nums[l] > nums[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && nums[r] > nums[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) { // 注意判断这个条件
            int tmp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = tmp;

            // Recursively heapAdjust the affected sub-tree
            // 这里largest存储的是最大的下标，因此只会对影响到的sub-tree进行调整
            heapAdjust(nums, n, largest);
        }

    }

}
