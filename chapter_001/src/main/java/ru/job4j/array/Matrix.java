package ru.job4j.array;

/**
 * Таблица умножения.
 */
public class Matrix {
    /**
     * Создаёт таблицу умножения.
     * @param size длина массива.
     * @return таблица умножения по заданной длине.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        int i, j = 0;
        for (i = 0; i < table.length; i++) {
            for (j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
