import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permute {
    void permuteRest(ArrayList<List<Integer>> all, List<Integer> temp, int pos){
        for (int i = pos; i < temp.size(); i++){
            if (i != pos) {
                ArrayList<Integer> newArray = new ArrayList<Integer>(temp);
                int tempV = newArray.get(pos);
                newArray.set(pos, newArray.get(i));
                newArray.set(i, tempV);
                all.add(newArray);
                permuteRest(all, newArray, pos + 1);
            }else {
                permuteRest(all, temp, pos + 1);
            }

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        ArrayList<List<Integer>> all = new ArrayList<List<Integer>>();
        all.add(numsList);
        permuteRest(all, numsList, 0);
        return all;
    }
    public static void main(String[] args){
        Permute permute = new Permute();
        int[] nums = {1, 2, 3};
        permute.permute(nums);
    }

}
