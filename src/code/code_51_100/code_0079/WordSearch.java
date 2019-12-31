package code.code_51_100.code_0079;

public class WordSearch {

    /*
     * Given a 2D board and a word,
     * find if the word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cell,
     * where "adjacent" cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     *
     * Example:
     *
     * board =[['A','B','C','E'],
     *         ['S','F','C','S'],
     *         ['A','D','E','E']]
     *
     * Given word = "ABCCED", return true.
     * Given word = "SEE", return true.
     * Given word = "ABCB", return false.
     *
     * 判定给定矩阵中是否存在
     * 1 每个元素仅使用一次 且
     * 2 水平 或 垂直位置相连的 串能覆盖给定的单词
     *
     * 算法：
     * 广度优先搜索  并标记已经使用过的元素
     *
     * */
    public static boolean exist(char[][] board, String word) {
        if (board == null
                || board.length == 0
                || board[0] == null
                || board[0].length == 0
                || word == null
                || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                if (bfs(board, i, j, new boolean[board.length][board[0].length], word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean bfs(char[][] board, int i, int j, boolean[][] used, String word, int cur) {
        if (cur >= word.length()) {
            return true;
        }
        if (i < 0
                || j < 0
                || i >= board.length
                || j >= board[0].length
                || used[i][j]
                || word.charAt(cur) != board[i][j]) {
            return false;
        }
        used[i][j] = true;
        if (bfs(board, i + 1, j, used, word, cur + 1)
                || bfs(board, i - 1, j, used, word, cur + 1)
                || bfs(board, i, j + 1, used, word, cur + 1)
                || bfs(board, i, j - 1, used, word, cur + 1)){
            return true;
        }
        used[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCB");
    }
}
