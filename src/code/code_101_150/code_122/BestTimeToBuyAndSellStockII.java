package code.code_101_150.code_122;

public class BestTimeToBuyAndSellStockII {

    /*
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit.
     * You may complete as many transactions as you like
     * (i.e., buy one and sell one share of the stock multiple times).
     *
     * Note: You may not engage in multiple transactions at the same time
     * (i.e., you must sell the stock before you buy again).
     *
     * Example 1:
     *
     * Input: [7,1,5,3,6,4]
     *
     * Output: 7
     *
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5),
     * profit = 5-1 = 4.Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3
     *
     * Example 2:
     *
     * Input: [1,2,3,4,5]
     *
     * Output: 4
     *
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     *
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     * engaging multiple transactions at the same time. You must sell before buying again.
     *
     * Example 3:
     *
     * Input: [7,6,4,3,1]
     *
     * Output: 0
     *
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     *
     * 目标：找出能获得的最大收益，可以多次买卖，但是同一天只能买或卖1次，且必须先买后卖
     *
     * 算法：
     * 动态规划
     *
     * bug[i] 表示到达第i天的时候为持有状态时最大收益
     * sell[i] 表示到达第i天的时候不持有股票时的最大收益
     *
     * buy[i] = max(buy(i-1),sell(i-1)-cur)
     * sell[i] = max(sell[i-1],buy[i-1]+cur)
     * 初始化时 buy[0] = -prices[0] sell[0] = 0
     *
     * 时间复杂度：O(N) 空间复杂度：O(N)
     *
     * 学习：
     * 本题可以使用贪心算法，相比动态规划，减少了空间复杂度以及部分计算
     *
     * TODO 学习官方给出的 峰值峰谷差异法  并code
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode/
     *
     * */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        maxProfit(new int[]{7,6,4,3,1});
    }
}
