package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort sort = new BubbleSort();
        int[] input = new int[]{12, 5, 2, 6, 4};
        int[] result = sort.sort(input);
        int[] expect = new int[]{2, 4, 5, 6, 12};
        assertThat(result, is(expect));
    }
    @Test
    public void whenSortArrayWithTenElementsThenSortedArraySecond() {
        BubbleSort sort = new BubbleSort();
        int[] input = new int[]{43, 1, 22, 2, 4, 19, 3, 23, 66, 9};
        int[] result = sort.sort(input);
        int[] expect = new int[]{1, 2, 3, 4, 9, 19, 22, 23, 43, 66};
        assertThat(result, is(expect));
    }
}
