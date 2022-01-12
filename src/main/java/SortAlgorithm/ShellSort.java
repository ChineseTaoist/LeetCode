package SortAlgorithm;

import java.util.ArrayList;

public class ShellSort {
    ArrayList solution(ArrayList<Integer> list, boolean isAsc){
        int gap = list.size() / 2;
        // 对gap进行遍历
        while (gap > 0){
            // 对gap内的所有初始元素遍历
            for (int pos = 0; pos < gap; pos ++){
                // 插入排序
                for (int i = pos; i < list.size(); i += gap){
                    for (int j = i; j > pos; j -= gap){
                        if (isAsc) {
                            if (list.get(j) < list.get(j - gap)) {
                                int temp = list.get(j);
                                list.set(j, list.get(j - gap));
                                list.set(j - gap, temp);
                            }else {
                                break;
                            }
                        } else {
                            if (list.get(j) > list.get(j - gap)){
                                int temp = list.get(j);
                                list.set(j, list.get(j - gap));
                                list.set(j - gap, temp);
                            }else {
                                break;
                            }
                        }
                    }

                }
            }
            gap /= 2;
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
        ShellSort bubbleSort = new ShellSort();

        bubbleSort.solution(list, true);
        bubbleSort.solution(list, false);
        System.out.print("Finish");

    }
}
