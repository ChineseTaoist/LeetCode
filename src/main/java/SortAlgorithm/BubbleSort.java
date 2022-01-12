package SortAlgorithm;

import java.util.ArrayList;

public class BubbleSort {
    ArrayList solution(ArrayList<Integer> list, boolean isAsc){
        for (int i = 0; i < list.size(); i++){
            for (int j = 1; j < list.size() - i; j++){
                // 如果升序
                if(isAsc) {
                    if (list.get(j) < list.get(j - 1)) {
                        int temp = list.get(j - 1);
                        list.set(j - 1, list.get(j));
                        list.set(j, temp);
                    }
                }
                // 如果降序
                else {
                    if (list.get(j) > list.get(j - 1)){
                        int temp = list.get(j - 1);
                        list.set(j - 1, list.get(j));
                        list.set(j, temp);
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
        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.solution(list, true);
        bubbleSort.solution(list, false);
        System.out.print("Finish");

    }
}
