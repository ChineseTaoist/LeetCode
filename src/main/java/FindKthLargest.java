public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++){
            int max = Integer.MIN_VALUE;
            int pos = i;
            for (int j = i; j < nums.length; j++){
                if (max < nums[j]){
                    pos = j;
                    max = nums[j];
                }
            }
            int temp = nums[pos];
            nums[pos] = nums[i];
            nums[i] = temp;
        }
        return nums[k - 1];
    }
}
