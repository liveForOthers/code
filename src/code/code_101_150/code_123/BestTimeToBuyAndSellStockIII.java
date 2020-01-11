package code.code_101_150.code_123;

public class BestTimeToBuyAndSellStockIII {

    /*
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * 最多完成两次交易
     * Note: You may not engage in multiple transactions at the same time
     * (i.e., you must sell the stock before you buy again).
     * 同一天 只能买或者卖
     * Example 1:
     *
     * Input: [3,3,5,0,0,3,1,4]
     * Output: 6
     *
     * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
     *
     * Example 2:
     *
     * Input: [1,2,3,4,5]
     * Output: 4
     *
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later,
     * as you are engaging multiple transactions at the same time. You must sell before buying again.
     *
     * Example 3:
     *
     * Input: [7,6,4,3,1]
     * Output: 0
     *
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     *
     *
     * 目标：给出股票价格列表，只能交易两次，给出最大收益
     *
     * 算法：
     *
     * 学习code友给出的通用解法，
     * 链接: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
     * 虽然是三维数组，但是持有状态仅可为0未持有 或1 持有 所以仅为二维空间复杂度
     * 当交易次数为常量时，空间复杂度为 线性复杂度
     *
     * 针对 买卖股票 1 以及2 可使用贪心策略的算法来说 空间复杂度升高
     * 但针对 其他使用动态规划算法来说 空间复杂度无变化
     *
     * 算法：
     * dp[i][k][s] 表示 第i天最大交易次数为k次持有状态为s 的最大收益
     *
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+cur)
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-cur)
     *
     * 时间复杂度:O(N) 空间复杂度:O(N)
     *
     * TODO 滚动数组优化空间复杂度 到O(1)
     *
     * */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // 第i天持有股票时且最多交易k次最大收益
        int[][] hold = new int[prices.length][3];
        // 第i天无股票时且最多交易k次最大收益
        int[][] sell = new int[prices.length][3];
        // 初始化第1天的数据
        for (int k = 1; k <= 2; k++) {
            hold[0][k] = -prices[0];
        }
        // 初始化最多交易0次 且为持有状态为负无穷
        for (int i = 0; i < prices.length; i++) {
            hold[i][0] = Integer.MIN_VALUE;
        }

        // 根据已知求未知
        // 遍历天数
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= 2; k++) {
                hold[i][k] = Math.max(hold[i - 1][k], sell[i - 1][k - 1] - prices[i]);
                sell[i][k] = Math.max(sell[i - 1][k], hold[i - 1][k] + prices[i]);
            }
        }
        return sell[prices.length - 1][2];
    }

    public static void main(String[] args) {
        maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
    }
}
