package code.code_151_200.code_200;

public class NumberOfIslands {

    /*
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands
     * horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     * 给定二维视图，计算陆地(1)的数目
     * 相邻的陆地被认为是同一块陆地
     * 边界认为是水
     * Example 1:
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     * Output: 1
     *
     * Example 2:
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     * Output: 3
     * 算法：
     * dfs，+ 原地算法：标记已经遍历过的点
     * 时间复杂度：O(N^2)
     * 空间复杂度:最坏情况下为 O(M×N)，此时整个网格均为陆地，深度优先搜索的深度达到 M×N。
     *
     * todo 使用bfs 能减少空间复杂度到线性复杂度
     * */
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return res;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    bfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        bfs(grid, i - 1, j);
        bfs(grid, i + 1, j);
        bfs(grid, i, j - 1);
        bfs(grid, i, j + 1);
    }
}
