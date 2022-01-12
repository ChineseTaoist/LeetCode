package SortAlgorithm;

import java.util.ArrayList;

public class SelectionSort {
    ArrayList solution(ArrayList<Integer> list, boolean isAsc){
        for(int i = 0; i < list.size(); i ++){
            int temp = list.get(i);
            int id = i;
            for (int j = i + 1; j < list.size(); j++){
                // 升序把小的放到前面来
                if (isAsc){
                    if(list.get(j) < list.get(id)){
                        id = j;
                        temp = list.get(j);
                    }
                }
                // 降序把大的放到前面来
                else {
                    if (list.get(j) > list.get(id)){
                        id = j;
                        temp = list.get(j);
                    }
                }
            }
            list.set(id, list.get(i));
            list.set(i, temp);
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
        SelectionSort bubbleSort = new SelectionSort();

        bubbleSort.solution(list, true);
        bubbleSort.solution(list, false);
        System.out.print("Finish");

    }
}
