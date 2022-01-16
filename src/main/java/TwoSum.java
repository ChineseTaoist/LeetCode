import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> val2Pos = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++){
            if (val2Pos.containsKey(nums[i])){
                ArrayList<Integer> posList = val2Pos.get(nums[i]);
                posList.add(i);
            }else {
                ArrayList<Integer> posList = new ArrayList<Integer>();
                posList.add(i);
                val2Pos.put(nums[i], posList);
            }
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            if (val2Pos.containsKey(target - nums[i])){
                res[0] = i;

                if (val2Pos.get(target - nums[i]).get(0) == i){
                    if (val2Pos.get(target - nums[i]).size() <= 1){
                        continue;
                    }
                    res[1] = val2Pos.get(target - nums[i]).get(1);
                }else {
                    res[1] = val2Pos.get(target - nums[i]).get(0);
                }
                return res;
            }
        }
        return res;
    }
    public static void main(String[] args){
        TwoSum twoSum = new TwoSum();
        int[] input = new int[3];
        input[0] = 3;
        input[1] = 2;
        input[2] = 4;
        twoSum.twoSum(input, 6);
    }
}
