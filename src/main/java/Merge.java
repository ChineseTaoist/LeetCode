// 88
public class Merge {
    // 每次取最大的放到最后面
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos1 = m - 1;
        int pos2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--){
            if (pos1 == -1 || pos2 == -1){
                nums1[i] = pos1 == -1 ? nums2[pos2--] : nums1[pos1--];
                continue;
            }
            nums1[i] = nums1[pos1] > nums2[pos2] ? nums1[pos1--] : nums2[pos2--];
        }
    }

}
