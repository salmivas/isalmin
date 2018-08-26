package ru.job4j.array;

/**
 * Алгоритм сортировки пузырьком.
 */
public class BubbleSort {
    /**
     * Сортирует элементы массива по порядку.
     * @param array массив, который нужно отсортировать.
     * @return отсортированный массив.
     */
    public int[] sort(int[] array) {
        int i = 0;
        int j = 0;
        int tmp = 0;
        for (i = array.length - 1; i >= 0; i--) {
            for (j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
