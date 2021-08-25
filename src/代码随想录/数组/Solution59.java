package 代码随想录.数组;

/**
 * 59.螺旋矩阵II
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * https://github.com/liuxiaoyudian/leetcode-master/blob/master/problems/0059.螺旋矩阵II.md
 */
public class Solution59 {

    public static void main(String[] args) {
        int[][] ans  = generateMatrix(3);
        for (int[] a : ans) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int count = 1;
        while (left <= right && top <= bottom) {
            // 填充上行从左到右，采取左闭右闭的好处就是不需要单独n处理n为奇数的情况，即单独给矩阵最中间的位置赋值的情况
            for (int column = left; column <= right; column++) {
                matrix[top][column] = count++;
            }
            for (int row = top + 1; row <= bottom; row++) { // 左开右闭
                matrix[row][right] = count++;
            }
            for (int column = right - 1; column >= left; column--) {  // 左开右闭
                matrix[bottom][column] = count++;
            }
            for (int row = bottom - 1; row > top; row--) { // 左关右关
                matrix[row][left] = count++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }

    /**
     * 8.24美团技术终面手撕代码
     */
    public static int[][] generateMatrix1(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int count = 1;
        for (int k = 0; k <= n / 2; k++) { // 利用k来限制也是可以的
            for (int column = left; column <= right; column++) {
                matrix[top][column] = count++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = count++;
            }
            for (int column = right - 1; column >= left; column--) {
                matrix[bottom][column] = count++;
            }
            for (int row = bottom - 1; row > top; row--) {
                matrix[row][left] = count++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }

}
