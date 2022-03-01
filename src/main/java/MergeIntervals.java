import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// 56
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            if (mergedIntervals.size() == 0){
                mergedIntervals.add(intervals[i]);
                continue;
            }
            int[][] merged = merge2Intervals(mergedIntervals.get(mergedIntervals.size() - 1), intervals[i]);
            mergedIntervals.set(mergedIntervals.size() - 1, merged[0]);
            if (merged[1] != null){
                mergedIntervals.add(merged[1]);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
    private boolean isOverlap(int[] intervals1, int[] intervals2){
        if (intervals1[1] >= intervals2[0] && intervals1[0] <= intervals2[0]){
            return true;
        }else if (intervals1[1] >= intervals2[1] && intervals1[0] <= intervals2[1]){
            return true;
        }else {
            return false;
        }
    }
    private int[][] merge2Intervals(int[] interval1, int[] interval2){
        int[][] res = new int[2][];
        if (!isOverlap(interval1, interval2)){
            res[0] = interval1;
            res[1] = interval2;
        }else {
            int[] res1 = new int[2];
            res1[0] = Math.min(interval1[0], interval2[0]);
            res1[1] = Math.max(interval1[1], interval2[1]);
            res[0] = res1;
        }
        return res;
    }
}
