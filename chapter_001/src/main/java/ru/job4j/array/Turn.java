package ru.job4j.array;

/**
 * Программа переварачивающая массив.
 */
public class Turn {
    /**
     * Переворачивает массив задом - наперёд.
     * @param array входящий массив.
     * @return перевернутый массив.
     */
    public int[] turn(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return array;
    }
}
