public class ClimbStairs {
    // 递归
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }else if (n == 2){
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    // 非递归
    public int climbStairs2(int n){
        if (n == 1){
            return 1;
        }else if (n == 2){
            return 2;
        }
        int val1 = 1;
        int val2 = 2;
        for (int i = 3; i <= n; i++){
            int res = val1 + val2;
            val1 = val2;
            val2 = res;
        }
        return val2;
    }
}
