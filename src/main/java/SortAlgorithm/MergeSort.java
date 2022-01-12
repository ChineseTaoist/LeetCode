package SortAlgorithm;

import java.util.ArrayList;

public class MergeSort {

    private ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2, boolean isAsc){
        ArrayList<Integer> mergeList = new ArrayList<Integer>();
        int mergeSize = list1.size() + list2.size();
        int currentPos1 = 0;
        int currentPos2 = 0;
        for (int i = 0; i < mergeSize; i++){
            if (currentPos1 >= list1.size()) {
                mergeList.add(list2.get(currentPos2));
                currentPos2++;
                continue;
            }
            if (currentPos2 >= list2.size()) {
                mergeList.add(list1.get(currentPos1));
                currentPos1++;
                continue;
            }
            if (isAsc) {
                if (list1.get(currentPos1) > list2.get(currentPos2)) {
                    mergeList.add(list2.get(currentPos2));
                    currentPos2++;
                } else {
                    mergeList.add(list1.get(currentPos1));
                    currentPos1++;
                }
            }else {
                if (list1.get(currentPos1) < list2.get(currentPos2)) {
                    mergeList.add(list2.get(currentPos2));
                    currentPos2++;
                } else {
                    mergeList.add(list1.get(currentPos1));
                    currentPos1++;
                }
            }
        }
        return mergeList;
    }

    public ArrayList<Integer> solution(ArrayList<Integer> list, boolean isAsc){
        if (list.size() == 1 || list.size() == 0){
            return list;
        }
        int centrePos = list.size() / 2;
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < centrePos; i++){
            list1.add(list.get(i));
        }
        list1 = solution(list1, isAsc);
        for (int i = centrePos; i < list.size(); i++){
            list2.add(list.get(i));
        }
        list2 = solution(list2, isAsc);

        return merge(list1, list2, isAsc);
    }

    public static void main(String[]args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(5);
        MergeSort bubbleSort = new MergeSort();
        ArrayList<Integer> sortedAsc = bubbleSort.solution(list, true);
        ArrayList<Integer> sortedDesc = bubbleSort.solution(list, false);
        System.out.print("Finish");

    }

}
