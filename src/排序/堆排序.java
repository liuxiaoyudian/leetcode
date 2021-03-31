package 排序;

public class 堆排序 {

    public static void main(String[] args) {
        int s[] = {2, 1, 20, -1, -5, 40, 3, 8, 8};
        heapSort(s);
        for (int i : s) {
            System.out.print(i + " ");
        }
    }

    /**
     * 堆排序的三个知识点：
     * 1、第一个非叶子节点是n/2-1
     * 2、某一个节点i的左孩子是2*i+1，右孩子是2*i+2
     * 3、堆排序的数据结构在逻辑上属于完全二叉树
     *
     * 大顶堆，用于升序
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, n, i);
        }

        // 排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call headAdjust on the reduced heap
            heapAdjust(arr, i, 0);
        }

    }

    /**
     *
     * @param arr
     * @param n is the size of heap
     * @param i is node
     */
    public static void heapAdjust(int[] arr, int n, int i) {
        // largest是下标，不是实际的值
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapAdjust the affected sub-tree
            // 这里largest存储的是最大的下标，因此只会对影响到的sub-tree进行调整
            heapAdjust(arr, n, largest);
        }

    }

}
