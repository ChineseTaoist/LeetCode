import java.lang.reflect.Array;
import java.util.ArrayList;

public class SortArray {
    public int[] sortArray(int[] nums) {
        if (nums.length == 1 || nums.length == 0){
            return nums;
        }
        int seed = nums[0];
        int[] listLeft = new int[nums.length];
        int leftSize = 0;
        int[] listRight = new int[nums.length];
        int rightSize = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > seed){
                listRight[rightSize] = nums[i];
                rightSize ++;
            }else {
                listLeft[leftSize] = nums[i];
                leftSize ++;
            }
        }
        int[] finalLeft = new int[leftSize];
        for (int i = 0; i < leftSize; i++){
            finalLeft[i] = listLeft[i];
        }
        int[] finalRight = new int[rightSize];
        for (int i = 0; i < rightSize; i++){
            finalRight[i] = listRight[i];
        }

        finalLeft = sortArray(finalLeft);
        finalRight = sortArray(finalRight);

        for (int i = 0; i < finalLeft.length; i++){
            nums[i] = finalLeft[i];
        }
        nums[finalLeft.length] = seed;
        for (int i = 0; i < finalRight.length; i++){
            nums[finalLeft.length + 1 + i] = finalRight[i];
        }
        return nums;

    }

}
