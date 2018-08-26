package ru.job4j.array;

/**
 * Программа возвращает результат заполнения массива.
 * Например:
 * {true, true, true} - вернет true;
 * {true, false, true} - вернет false;
 * {false, false, false} - вернет true.
 */
public class Check {
    /**
     * Проверяет, что все элементы в массиве являются true или false.
     * @param data проверяемый массив.
     * @return результат проверки.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] != data[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}

