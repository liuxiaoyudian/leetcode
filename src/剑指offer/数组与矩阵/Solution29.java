package 剑指offer.数组与矩阵;

import java.util.ArrayList;

public class Solution29 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2){
            // 上
            for (int i = c1; i <= c2; i++) {
                ret.add(matrix[r1][i]);
            }
            // 右
            for (int i = r1 + 1; i <= r2; i++) {
                ret.add(matrix[i][c2]);
            }
            // 下
            if (r1 != r2) {
                // 应当注意只有在 r1 != r2 时才打印最下一行，也就是在当前最外层的行数大于 1 时才打印最下一行
                // 这是因为当前最外层只有一行时，继续打印最下一行，会导致重复打印。打印最左一行也要做同样处理。
                for (int i = c2 - 1; i >= c1; i--) {
                    ret.add(matrix[r2][i]);
                }
            }
            // 左
            if (c1 != c2) {
                // 注意这里的边界条件
                for (int i = r2 - 1; i > r1; i--) {
                    ret.add(matrix[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ret;
    }

}
