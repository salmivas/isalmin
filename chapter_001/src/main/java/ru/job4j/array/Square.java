package ru.job4j.array;

/**
 * Программа, создающая массив чисел, возведённых в квадрат.
 */
public class Square {
    /**
     *
     * @param bound длина массива.
     * @return массив чисел (от 0) возведённых в квадрат.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < rst.length; i++) {
            rst[i] =  (i + 1) * (i + 1);
        }
        return rst;
    }
}
