package by.com.andersen.sort;

import by.com.andersen.sort.MergeSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    private MergeSort mergeSort;

    @BeforeEach
    private void init(){
        mergeSort = new MergeSort();
    }

    @Test
    public void mergeNullTest(){
        List<Integer> nullList = null;

        assertEquals(null, mergeSort.mergeSort(nullList));
    }

    @Test
    public void mergePositiveTest(){
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> sort = new ArrayList<>(Arrays.asList(1, 6, 5, 4, 3, 2));

        sort = mergeSort.mergeSort(sort);

        assertEquals(expected.hashCode(), sort.hashCode());
    }

    @Test
    void bubbleSortNegative(){
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 4));
        List<Integer> sort = new ArrayList<>(Arrays.asList(1, 6, 5, 4, 3, 2));

        mergeSort.mergeSort(sort);
        assertNotEquals(expected.hashCode(), sort.hashCode());
    }
}