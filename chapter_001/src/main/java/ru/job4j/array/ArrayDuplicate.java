package ru.job4j.array;
import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int out;
        int in;
        int bunch = array.length;

        for (out = 0; out < bunch; out++) {
            for (in = out + 1; in < bunch; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[bunch - 1];
                    bunch--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, bunch);
    }
}
