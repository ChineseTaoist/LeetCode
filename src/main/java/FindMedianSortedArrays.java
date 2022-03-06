public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int pos1 = 0;
        int pos2 = 0;
        int centre = 0;
        int current = 0;
        while (true){
            current += 1;
            if (pos1 >= nums1.length || (pos2 < nums2.length && nums1[pos1] >= nums2[pos2])){
                if (current == (length + 1) / 2){
                    if (length % 2 == 0){
                        centre = nums2[pos2];
                    }else {
                        return nums2[pos2];
                    }
                }else if (current > (length + 1) / 2){
                    return (double)(centre + nums2[pos2]) / 2;
                }
                pos2 += 1;
            }else if (pos2 >= nums2.length || (pos1 < nums1.length && nums1[pos1] < nums2[pos2])){
                if (current == (length + 1) / 2){
                    if (length % 2 == 0){
                        centre = nums1[pos1];
                    }else {
                        return nums1[pos1];
                    }
                }else if (current > (length + 1) / 2){
                    return (double)(centre + nums1[pos1]) / 2;
                }
                pos1 += 1;
            }
        }
    }
    public static void main(String[] args ){
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        int[] num1 = {0,0};
        int[] num2 = {0,0};
        double n = findMedianSortedArrays.findMedianSortedArrays(num1, num2);
        System.out.print(n);
    }
}
