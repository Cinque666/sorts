package by.com.andersen.sort;

import java.util.ArrayList;
import java.util.List;

class MergeSort {

    List<Integer> mergeSort(List<Integer> array) {

        if(array == null){
            return null;
        }

        if(array.size() < 2){
            return  array;
        }

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (i < array.size() / 2) {
                leftArray.add(array.get(i));
            } else {
                rightArray.add(array.get(i));
            }
        }

        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);

        return mergeArrays(leftArray, rightArray);
    }


    private List<Integer> mergeArrays(List<Integer> leftArray, List<Integer> rightArray){
        List<Integer> result = new ArrayList<>();
        int leftPosition = 0, rightPosition = 0;

        for(int i = 0; i < leftArray.size() + rightArray.size(); i++){
            int leftValue, rightValue;
            if(leftPosition == leftArray.size()){
                rightValue = rightArray.get(rightPosition);
                result.add(rightValue);
                rightPosition++;
            } else if(rightPosition == rightArray.size()){
                leftValue = leftArray.get(leftPosition);
                result.add(leftValue);
                leftPosition++;
            } else if(leftArray.get(leftPosition) > rightArray.get(rightPosition)){
                rightValue = rightArray.get(rightPosition);
                result.add(rightValue);
                rightPosition++;
            } else {
                leftValue = leftArray.get(leftPosition);
                result.add(leftValue);
                leftPosition++;
            }
        }

        return result;
    }
}
