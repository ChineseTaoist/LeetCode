public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int rotatePos = nums.length - 1;
        // 先找到旋转点，再二分查找
        for (int i = 0; i < nums.length; i++){
            if (i + 1 < nums.length && nums[i] > nums[i + 1]){
                rotatePos = i;
                break;
            }
        }
        if (target >= nums[0] && target <= nums[rotatePos]){
            int centerPos = rotatePos / 2;
            int startPos = 0;
            int endPos = rotatePos;
            return find(nums, startPos, endPos, centerPos, target);
        }else {
            int centerPos = (rotatePos + nums.length - 1) / 2;
            int startPos = rotatePos + 1 < nums.length ? rotatePos + 1 : nums.length - 1;
            int endPos = nums.length - 1 > 0 ? nums.length - 1 : 0;
            return find(nums, startPos, endPos, centerPos, target);
        }
    }
    private int find(int[] nums, int startPos, int endPos, int centerPos, int target){
        if (nums[centerPos] == target){
            return centerPos;
        }else if (nums[startPos] == target){
            return startPos;
        }else if (nums[endPos] == target){
            return endPos;
        }
        if (endPos - startPos <= 2){
            return -1;
        }
        if (target >= nums[centerPos]){
            startPos = centerPos;
            centerPos = (centerPos + endPos) / 2;
            return find(nums, startPos, endPos, centerPos, target);
        }else {
            endPos = centerPos;
            centerPos = (centerPos + startPos) / 2;
            return find(nums, startPos, endPos, centerPos, target);
        }
    }
}
