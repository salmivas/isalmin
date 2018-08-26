package ru.job4j.array;

/**
 * Программа поиска элемента в массиве.
 */
public class FindLoop {
    /**
     * Поиск по индексу удовлетворяющему условию.
     * @param data входящий массив.
     * @param el индекс искомого элемента.
     * @return индекс искомого элемента или "-1" если элемент не найден.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
