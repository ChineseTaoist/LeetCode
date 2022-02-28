import java.util.ArrayList;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 0;
        if (nums.length > 0){
            maxLength = 1;
            dp[0] = 1;
        }
        for (int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--){
                if (nums[i] > nums[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                    maxLength = dp[i] > maxLength ? dp[i] : maxLength;
                }
            }
        }
        return maxLength;
    }

}
