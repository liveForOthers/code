package code.code_0036;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] chars = {new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        isValidSudoku(chars);
    }

    /*
     *  本题要求实现 矩阵 数独的 判断
     *  1 行 由1~9 不重复数字组成
     *  2 列 由1~9 不重复数字组成
     *  3 每一个3*3 的格子  由1~9 不重复数字组成
     * */
    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0] == null || board[0].length != 9) {
            throw new IllegalArgumentException("参数异常");
        }
        // row
        for (int i = 0; i < 9; i++) {
            int[] cache = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (cache[board[i][j] - '1'] == 0) {
                    cache[board[i][j] - '1']++;
                    continue;
                }
                return false;
            }
        }

        // col
        for (int i = 0; i < 9; i++) {
            int[] cache = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (cache[board[j][i] - '1'] == 0) {
                    cache[board[j][i] - '1']++;
                    continue;
                }
                return false;
            }
        }

        // 3*3
        for (int k = 0; k < 9; k++) {
            int[] cache = new int[9];
            for (int i = k / 3 * 3; i < k / 3 * 3 + 3; i++) {
                for (int j = (k % 3) * 3; j < (k % 3) * 3 + 3; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    if (cache[board[i][j] - '1'] == 0) {
                        cache[board[i][j] - '1']++;
                        continue;
                    }
                    return false;
                }
            }
        }
        return true;
    }
}