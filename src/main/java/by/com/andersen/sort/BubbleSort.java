package by.com.andersen.sort;

import java.util.List;

class BubbleSort {

    void bubbleSort(List<Integer> array){
        boolean isSorted = true;

        while (isSorted){
            isSorted = false;
            for(int i = 0; i < array.size() - 1; i++){
                if(array.get(i) > array.get(i + 1)){
                    int temp = array.get(i);
                    array.set(i, array.get(i + 1));
                    array.set(i + 1, temp);
                    isSorted = true;
                }
            }
        }
    }
}
