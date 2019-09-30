import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        for (int i = 0;i < nums.length ;i ++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R){
                int sum = nums[L] + nums[R] + nums[i];
                if (sum == 0){
                    ArrayList<Integer> res = new ArrayList<Integer>();
                    res.add(nums[i]);
                    res.add(nums[L]);
                    res.add(nums[R]);
                    resList.add(res);
                    while (L<R && nums[L] == nums[L+1]){
                        L++;
                    }
                    while (L<R && nums[R] == nums[R-1]) {
                        R--;
                    }
                    L ++;
                    R --;
                }
                else if (sum < 0) {
                    while (L<R && nums[L] == nums[L+1]){
                        L++;
                    }
                    L ++;
                }
                else if (sum > 0) {
                    while (L<R && nums[R] == nums[R-1]) {
                        R--;
                    }
                    R --;
                }
            }
        }
        return resList;

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        int pastVali = 0;
        for (int i = 0;i < nums.length ;i ++){
            if (i != 0 && pastVali == nums[i]){
                continue;
            }
            int pastValj = 0;
            for (int j = i + 1;j < nums.length;j ++){
                if (j != i + 1 && pastValj == nums[j]){
                    continue;
                }
                int pastValk = 0;
                for (int k = j + 1;k < nums.length;k ++){
                    if (k != j + 1 && pastValk == nums[k]){
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0){
                        ArrayList<Integer> res = new ArrayList<Integer>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[k]);
                        resList.add(res);
                    }
                    pastValk = nums[k];
                }
                pastValj = nums[j];
            }
            pastVali = nums[i];
        }
        return resList;
    }
    public static void main(String[]args){
        ThreeSum sol = new ThreeSum();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0;i < n;i ++){
            nums[i] = sc.nextInt();
        }
        System.out.println(sol.threeSum2(nums));
    }
}
