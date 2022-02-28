public class Search {
    public int search(int[] nums, int target) {
        int headPos = 0;
        int tailPos = nums.length - 1;
        int centerPos = (headPos + tailPos) / 2;
        while (true){
            if (nums[headPos] == target){
                return headPos;
            }else if (nums[tailPos] == target){
                return tailPos;
            }else if (nums[tailPos] < target || nums[headPos] > target){
                return -1;
            }else if (tailPos - headPos <= 1){
                return -1;
            }
            if (target == nums[centerPos]){
                return centerPos;
            }else if (target > nums[centerPos]){
                headPos = centerPos;
            }else if (target < nums[centerPos]){
                tailPos = centerPos;
            }
            centerPos = (headPos + tailPos) / 2;
        }
    }
}
