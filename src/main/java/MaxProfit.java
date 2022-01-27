public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int[] dp = new int[prices.length];
        int max = 0;
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < dp[i - 1]){
                dp[i] = prices[i];
            }else {
                dp[i] = dp[i - 1];
            }
            int profit = prices[i] - dp[i - 1];
            if (max < profit){
                max = profit;
            }
        }
        return max;
    }
}
