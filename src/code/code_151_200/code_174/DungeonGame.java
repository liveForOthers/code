package code.code_151_200.code_174;

public class DungeonGame {

    /*
     * 目标，找到从左上到右下的最大数
     * 算法：
     * 限制因素两个：
     * 1 之前的能力最小值     Math.max(dp[i - 1][j], dp[i][j - 1])
     * 2 到当前点的能量最小值  dungeon[i][j]+Math.max(dungeon[i-1][j],dungeon[i][j-1])
     *
     * 每一个点有两个属性 1 到达该点所需能量最小值  2 该点剩余能量
     * 顺序思想时，到达(i,j) 点 是从(i-1,j)走 还是从(i,j-1) 走  需要考虑以上两个属性，由于依赖之后节点的属性因此难以决断。
     *
     * 逆序思想，从(i,j) 点 到达 终点 需要补充多少能量。依赖于(i+1,j) 以及(i,j+1)的到达终点所需能量值。
     * 表达式：
     * dp[i][j] = min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]
     * 如 dp[i][j]<0 则将dp[i][j]设置为1即可 因为可以到达(i,j)点至少要有1点能量
     *
     * 动态规划+滚动数组
     * 时间复杂度：O(n^2) 空间复杂度：O(n)
     *
     * todo dfs+dfs&&map+滚动数组解法
     * */
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            throw new IllegalArgumentException("参数异常");
        }
        // dp[i][j] 标识(i,j) 到达终点的最少血量
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[dungeon.length - 1][dungeon[0].length - 1] = dungeon[dungeon.length - 1][dungeon[0].length - 1] >= 0 ? 1 : (dungeon[dungeon.length - 1][dungeon[0].length - 1] * (-1) + 1);
        for (int i = dungeon.length - 2; i >= 0; i--) {
            dp[i][dungeon[0].length - 1] = Math.max(dp[i + 1][dungeon[0].length - 1] - dungeon[i][dungeon[0].length - 1], 1);
        }
        for (int i = dungeon[0].length - 2; i >= 0; i--) {
            dp[dungeon.length - 1][i] = Math.max(dp[dungeon.length - 1][i + 1] - dungeon[dungeon.length - 1][i], 1);
        }
        for (int i = dungeon.length - 2; i >= 0; i--) {
            for (int j = dungeon[0].length - 2; j >= 0; j--) {
                int right = dp[i][j + 1] - dungeon[i][j];
                int low = dp[i + 1][j] - dungeon[i][j];
                dp[i][j] = Math.min(right, low);
                dp[i][j] = Math.max(dp[i][j], 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{{1, -4, 5, -99}, {2, -2, -2, -1}};
        int i = calculateMinimumHP(dungeon);
        System.out.println(i);
    }


}
