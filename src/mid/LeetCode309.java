package mid;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 *     你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *     卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 状态方程：
 * dp[i][0]: 第i天买入的最大收益  dp[i][1]：第i天卖出的最大收益
 * dp[i][0] = max(dp[i-2][1] - prices[i], dp[i-1][0]) （前天卖出今天买入，或者昨天买入今天啥也没干）
 * dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i])  (前一天卖出，或者前一天买入今天卖出)
 *
 * 临界值：
 * dp[0][0]: 代表第0天买入，此时收益为-price[0]
 * dp[0][1]：代表第0天卖出，此时收益为0
 */
public class LeetCode309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][1] = 0;
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(i > 1 ? dp[i - 2][1] - prices[i] : -prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[prices.length-1][1];
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,2};
        int i = new LeetCode309().maxProfit(a);
        System.out.println();
       "".intern();
    }
}
