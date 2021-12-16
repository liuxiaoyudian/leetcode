public class Main1 {

    /**
     * X O
     * O反转成X
     */
    public static void main(String[] args) {
        char[][] chs = {
                {'x', 'x', 'x', 'x'},
                {'x', 'o', 'o', 'x'},
                {'x', 'o', 'x', 'x'},
                {'x', 'x', 'o', 'o'},
                {'x', 'x', 'o', 'x'},
                {'x', 'x', 'x', 'o'}
        };

        int[][] flags = new int[chs.length][chs[0].length];
        System.err.println(chs[3][3]);
        DFS(3, 3, chs, flags);
    }

    public static void DFS(int i, int j, char[][] chs, int[][] flags) {
        flags[i][j] = 1;
        if (i > 1 && chs[i - 1][j] == 'o') { // up
            flags[i - 1][j] = 1;
            DFS(i - 1, j, chs, flags);
        }
        if (i < chs.length - 1 && chs[i + 1][j] == 'o') { // down
            flags[i + 1][j] = 1;
            DFS(i + 1, j, chs, flags);
        }
        if (j > 1 && chs[i][j - 1] == 'o') { // left
            flags[i][j - 1] = 1;
            DFS(i, j - 1, chs, flags);
        }
        if (j < chs[0].length - 1 && chs[i][j + 1] == 'o') { // right
            flags[i][j + 1] = 1;
            DFS(i, j + 1, chs, flags);
        }
    }


}
