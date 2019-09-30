import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int[]res = new int[3];
        int closest = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0;i < nums.length ;i ++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R){
                int sum = nums[L] + nums[R] + nums[i];
                if (sum == target){
                    return sum;
                }
                else if (sum < target){
                    int temp = target - sum;
                    if (temp < closest){
                        closest = temp;
                        closestSum = sum;
                    }
                    while (L<R && nums[L] == nums[L+1]){
                        L++;
                    }
                    L ++;
                }
                else if (sum > target) {
                    int temp = sum - target;
                    if (temp < closest){
                        closest = temp;
                         closestSum = sum;
                    }
                    while (L<R && nums[R] == nums[R-1]) {
                        R--;
                    }
                    R --;
                }
            }
        }
        return closestSum;
    }
    public static void main(String[]args){
        ThreeSumClosest sol = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(sol.threeSumClosest(nums, target));
    }
}
