import java.util.ArrayList;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        // 对于dp[i]，dp[i][0]为最大和，dp[i][1]为最前面的位置
        int[][] dp = new int[nums.length][2];

        dp[0][0] = nums[0];
        dp[0][1] = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (dp[i - 1][0] > 0){
                dp[i][0] = dp[i - 1][0] + nums[i];
                dp[i][1] = dp[i - 1][1];
            }else {
                dp[i][0] = nums[i];
                dp[i][1] = i;
            }
            max = max > dp[i][0] ? max : dp[i][0];
        }
        return max;
    }
}
