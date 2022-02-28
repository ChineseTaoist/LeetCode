import java.util.Stack;

public class Trap {
    public int trap(int[] height) {
        Stack<Integer> decrease = new Stack<>();
        int totalWater = 0;
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            while (!decrease.empty() && height[i] > height[decrease.peek()]){
                int p = decrease.pop();
                if (decrease.empty()){
                    break;
                }
                totalWater += (i - decrease.peek() - 1) * (Math.min(height[decrease.peek()], height[i]) - height[p]);
            }
            decrease.push(i);
        }
        return totalWater;
    }

    public static void main(String[]args){
        Trap trap = new Trap();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap.trap(nums);
    }
}
