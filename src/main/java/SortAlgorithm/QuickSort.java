package SortAlgorithm;

import java.util.ArrayList;

public class QuickSort {

    ArrayList<Integer> solution(ArrayList<Integer> list, boolean isAsc){
        if (list.size() == 0 || list.size() == 1){
            return list;
        }
        int seed = list.get(0);
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 1; i < list.size(); i++){
            if (isAsc) {
                if (seed > list.get(i)) {
                    list1.add(list.get(i));
                } else {
                    list2.add(list.get(i));
                }
            }else {
                if (seed < list.get(i)){
                    list1.add(list.get(i));
                } else {
                    list2.add(list.get(i));
                }
            }
        }
        list1 = solution(list1, isAsc);
        list1.add(seed);
        list2 = solution(list2, isAsc);
        list = new ArrayList<Integer>();
        list.addAll(list1);
        list.addAll(list2);
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
        QuickSort bubbleSort = new QuickSort();
        ArrayList<Integer> sortedAsc = bubbleSort.solution(list, true);
        ArrayList<Integer> sortedDesc = bubbleSort.solution(list, false);
        System.out.print("Finish");
    }


}
