package code.code_101_150.code_121;

public class BestTimeToBuyAndSellStock {


    /*
    * Say you have an array for which the ith element is the price of a given stock on day i.
    *
    * If you were only permitted to complete at most one transaction
    * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    *
    * Note that you cannot sell a stock before you buy one.
    *
    * Example 1:
    *
    * Input: [7,1,5,3,6,4]
    *
    * Output: 5
    *
    * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6),
    * profit = 6-1 = 5.
    * Not 7-1 = 6, as selling price needs to be larger than buying price.
    *
    * Example 2:
    *
    * Input: [7,6,4,3,1]
    * Output: 0
    * Explanation: In this case, no transaction is done, i.e. max profit = 0.
    *
    * 目标：
    *
    * 算法:
    * 贪心 当前小于min  更新min
    *      否则   尝试更新profit
    *
    * 学习： 不能维护最大以及 最小， 因为最大出现的地方可能是最小元素下标之前 没有意义
    *
    * */
    public int maxProfit(int[] prices) {
        if(prices==null ||prices.length<=1){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int cur:prices){
            if(cur <= min){
                min = cur;
                continue;
            }
            profit = Math.max(profit,cur-min);
        }
        return profit;
    }
}
