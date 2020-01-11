package code.code_101_150.code_130;

public class SurroundedRegions {


    /*
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     *
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     * Explanation:
     *
     * Surrounded regions shouldn’t be on the border,
     * which means that any 'O' on the border of the board are not flipped to 'X'.
     * Any 'O' that is not on the border and
     * it is not connected to an 'O' on the border will be flipped to 'X'.
     * Two cells are connected if they are adjacent cells connected horizontally or vertically.
     *
     * 目标： 将被'X' 水平以及垂直方向团团围住的'O' 改写为'X' 当'O' 出于边界 或与边界的'O' 水平或垂直相连时存活
     *
     * 算法:
     * bfs+原地算法
     *
     * 时间复杂度：O(N^2) 空间复杂度O(1)
     *
     * TODO 思考全面 bugfree
     * */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                bfs(board, i, board[0].length - 1);
            }
        }
        for (int j = 1; j < board[0].length - 1; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                bfs(board, board.length - 1, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int row, int col) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
            return;
        }
        if (board[row][col] == 'X' || board[row][col] == 'S') {
            return;
        }
        board[row][col] = 'S';
        bfs(board, row - 1, col);
        bfs(board, row + 1, col);
        bfs(board, row, col - 1);
        bfs(board, row, col + 1);
    }

    public static void main(String[] args) {

    }
}
