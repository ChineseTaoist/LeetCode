package SortAlgorithm;

import java.util.ArrayList;

public class InsertSort {
    ArrayList solution(ArrayList<Integer> list, boolean isAsc){
        for (int i = 1; i < list.size(); i ++){
            for (int j = i; j > 0; j --){
                if (isAsc){
                    if (list.get(j) < list.get(j - 1)){
                        int temp = list.get(j);
                        list.set(j, list.get(j - 1));
                        list.set(j - 1, temp);
                    }else {
                        break;
                    }
                }
                else {
                    if (list.get(j) > list.get(j - 1)){
                        int temp = list.get(j);
                        list.set(j, list.get(j - 1));
                        list.set(j - 1, temp);
                    }else {
                        break;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[]args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(5);
        InsertSort bubbleSort = new InsertSort();

        bubbleSort.solution(list, true);
        bubbleSort.solution(list, false);
        System.out.print("Finish");

    }
}
