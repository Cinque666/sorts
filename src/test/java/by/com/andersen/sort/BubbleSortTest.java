package by.com.andersen.sort;

import by.com.andersen.sort.BubbleSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private BubbleSort bubbleSort;

    @BeforeEach
    private void init(){
        bubbleSort = new BubbleSort();
    }

    @Test
    void bubbleSortPositive() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> sort = new ArrayList<>(Arrays.asList(1, 6, 5, 4, 3, 2));

        bubbleSort.bubbleSort(sort);
        assertEquals(expected.hashCode(), sort.hashCode());
    }

    @Test
    void bubbleSortNegative(){
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 4));
        List<Integer> sort = new ArrayList<>(Arrays.asList(1, 6, 5, 4, 3, 2));

        bubbleSort.bubbleSort(sort);
        assertNotEquals(expected.hashCode(), sort.hashCode());
    }
}