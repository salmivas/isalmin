package ru.job4j.array;

/**
 * Программа проверки заполнения массивы булевыми значениями по диагоналям.
 */
public class MatrixCheck {
    /**
     * Проверяет что все элементы по диагоналям true или false.
     * Например:
     * {
     *    {true, true, true},
     *    {false, true, true},
     *    {true, false, true}
     * } - вернет true;
     * {
     *     {true, false, true},
     *     {false, false, false},
     *     {true, false, true}
     * } - вернет false;
     * @param data входящий массив.
     * @return результат проверки.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int i;
        for (i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i] || data[0][0] != data[data.length - 1 - i][i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
