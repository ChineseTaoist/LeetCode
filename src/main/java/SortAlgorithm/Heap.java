package SortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

//最小堆
public class Heap {
    private ArrayList<Integer> vals;
    public Heap(){
        vals = new ArrayList<>();
    }
    // TODO： 建堆
    public Heap(int[] valList){
        vals = (ArrayList<Integer>) Arrays.stream(valList).boxed().collect(Collectors.toList());

    }

    private int getFather(int posSon){
        return (posSon + 1) / 2 - 1;
    }
    private int getSon(int posFather, boolean direction){
        // 左边
        if (direction){
            return (posFather + 1) * 2 - 1;
        }//右边
        else{
            return (posFather + 1) * 2;
        }
    }
    public void upOp(int pos){
        int father = getFather(pos);
        if (vals.get(father) >= vals.get(pos)){
            return;
        }
        int temp = vals.get(father);
        vals.set(father, vals.get(pos));
        vals.set(pos, temp);
        upOp(father);
    }
    public void downOp(int pos){
        int leftSonVal = getSon(pos, true) < vals.size() ? vals.get(getSon(pos, true)) : Integer.MAX_VALUE;
        int rightSonVal = getSon(pos, false) < vals.size() ? vals.get(getSon(pos, false)) : Integer.MAX_VALUE;
        int minVal;
        int changePos;
        if (leftSonVal < rightSonVal){
            minVal = leftSonVal;
            changePos = getSon(pos, true);
        }else if (rightSonVal <= leftSonVal && rightSonVal != Integer.MAX_VALUE){
            minVal = rightSonVal;
            changePos = getSon(pos, false);
        }else {
            return;
        }
        if (minVal >= vals.get(pos)){
            return;
        }
        int temp = vals.get(changePos);
        vals.set(changePos, vals.get(pos));
        vals.set(pos, temp);
        downOp(changePos);
    }
    public void insert(int val){
        int pos = vals.size();
        vals.add(val);
        upOp(pos);
    }
}
