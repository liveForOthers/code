package code.code_151_200.code_188;

public class BestTimeToBuyAndSellStockIV {

    /*
     * Say you have an array for which the i-th element is the price of a given stock on day i.
     * 给定每天股票售卖价格数组
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     * 最多完成k次交易，找到最大收益
     * Note:
     * You may not engage in multiple transactions at the same time
     * (ie, you must sell the stock before you buy again).
     * 同一天只能卖或买一次  只可存货一天
     * Example 1:
     * Input: [2,4,1], k = 2
     * Output: 2
     * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
     *
     * Example 2:
     * Input: [3,2,6,5,0,3], k = 2
     * Output: 7
     * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
     * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     *
     * 算法：
     * 动态规划
     * 影响因子：
     * 1 交易次数k
     * 2 持有 售卖状态
     * buy[i][k]  表示第i天为持有状态 且已交易次数为k次时的 最大收益
     * sell[i][k] 表示第i天为未持有状态 且已交易次数为k次时的 最大收益
     *
     * buy[i][j] = max(buy[i-1][j],sell[i-1][j-1]-prices[i])
     * sell[i][j] = max(sell[i-1][j],buy[i-1][j]+prices[i])
     *
     * 初始化
     * k>=i/2 时 不限制交易次数 算法退化为 峰谷与峰波 差值和
     * k<i/2 时
     * 初始化交易0次时  持有状态为最小值  因为不可能出现
     * 初始化第0天时的  持有状态数据为-prices[i]
     *
     * todo 学习方法二： https://leetcode.wang/leetcode-188-Best-Time-to-Buy-and-Sell-StockIV.html
     *
     * todo 滚动数组优化
     * */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k < 1) {
            return 0;
        }
        if (k >= (prices.length >> 1)) {
            return maxProfit(prices);
        }
        // 动态规划
        int[][] hold = new int[prices.length][k + 1];
        int[][] unhold = new int[prices.length][k + 1];
        // 初始化已交易0次且状态为持有
        for (int i = 0; i < prices.length; i++) {
            hold[i][0] = Integer.MIN_VALUE;
        }
        // 初始化第1天且状态为持有
        for (int i = 1; i <= k; i++) {
            hold[0][i] = -prices[0];
        }
        // 根据已知求未知 动态规划
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                hold[i][j] = Math.max(hold[i - 1][j], unhold[i - 1][j - 1] - prices[i]);
                unhold[i][j] = Math.max(unhold[i - 1][j], hold[i - 1][j] + prices[i]);
            }
        }
        return unhold[prices.length - 1][k];
    }

    private int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        int max = prices[0];
        for (int i = 0; i < prices.length; i++) {
            //寻找波谷
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            min = prices[i];
            //寻找当前波峰
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            max = prices[i];
            res += max - min;
        }
        return res;
    }
}
